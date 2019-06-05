package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import Model.Apartamento;
import Model.BaseDados;
import Model.Morador;
import Model.StatusApartamentos;
import View.TelaMensagem;

public class controllerRemoverMorador extends Observable implements ActionListener{
	controllerLogin controllerlogin;
	public controllerRemoverMorador(controllerLogin controllerlogin) {
		this.controllerlogin = controllerlogin;
		control();
	}
	
	public void areatext() {
		controllerlogin.viewmorador.getAreaText().setText(null);
		for(Morador morador : BaseDados.moradores) {
			controllerlogin.viewmorador.getAreaText().append(
					"********Dados*********" +
					"\nHóspede do Quarto Nº"+morador.numeroapartamento +
					"\nNome : "+ morador.nome +
					"\nCPF : "+ morador.cpf +
					"\nRG : "+ morador.rg +
					"\nTelefone : " + morador.telefone +
					"\nData Entrada :" + morador.dataentrada +
					"\n************************\n");
		}
	}
	
	public void control() {
		controllerlogin.removermorador.getButtonConfirmar().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controllerlogin.removermorador.getButtonConfirmar()) {
			if(controllerlogin.removermorador.getFieldCpf().getText().isEmpty() == true) {
				TelaMensagem.Exibir("Preencha o campo!");
			}
			
			else if(BaseDados.existeMorador(controllerlogin.removermorador.getFieldCpf().getText()) == false) {
				TelaMensagem.Exibir("CPF não encontrado ou removido!");
			}
			
			else {
			Apartamento a = BaseDados.Buscar(BaseDados.buscarMorador(controllerlogin.removermorador.getFieldCpf().getText()).getNumeroapartamento());
			a.setTipoOcupacao("Vazio");
			
			StatusApartamentos.CalcularAlugados();
			StatusApartamentos.CalcularDisponiveis();
			StatusApartamentos.CalcularTotal();
			setChanged();
			notifyObservers();
			StatusApartamentos.AtualizarDisponibilidade(controllerlogin);
			
			BaseDados.removerMorador(controllerlogin.removermorador.getFieldCpf().getText());
			TelaMensagem.Exibir("Morador removido com Sucesso!");
			areatext();
		
			}
		}	
	}
}
