package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.BaseDados;
import Model.Morador;
import View.TelaMensagem;


public class controllerAlterarMorador implements ActionListener{
	controllerLogin controllerlogin;
	public controllerAlterarMorador(controllerLogin controllerlogin) {
		this.controllerlogin = controllerlogin;
		control();
	}
	public void control() {
		controllerlogin.viewalterarmorador.getButtonCancelar().addActionListener(this);
		controllerlogin.viewalterarmorador.getButtonConfirmar().addActionListener(this);
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controllerlogin.viewalterarmorador.getButtonCancelar()) {
			controllerlogin.viewalterarmorador.dispose();
		}
		if(e.getSource() == controllerlogin.viewalterarmorador.getButtonConfirmar()) {
			if(controllerlogin.viewalterarmorador.getFieldCPF().getText().isEmpty() == true ||
					controllerlogin.viewalterarmorador.getFieldNovoCPF().getText().isEmpty() == true ||
					controllerlogin.viewalterarmorador.getFieldNovoNome().getText().isEmpty() == true ||
					controllerlogin.viewalterarmorador.getFieldNovoRG().getText().isEmpty() == true ||
					controllerlogin.viewalterarmorador.getFieldNovoTelefone().getText().isEmpty() == true ){
				TelaMensagem.Exibir("Preencha Todos os Campos!");
			}
			else if(BaseDados.existeMorador(controllerlogin.viewalterarmorador.getFieldCPF().getText()) == true) {
				BaseDados.alterarMorador(controllerlogin.viewalterarmorador.getFieldCPF().getText(),
						controllerlogin.viewalterarmorador.getFieldNovoNome().getText(),
						controllerlogin.viewalterarmorador.getFieldNovoCPF().getText(),
						controllerlogin.viewalterarmorador.getFieldNovoRG().getText(),
						controllerlogin.viewalterarmorador.getFieldNovoTelefone().getText());
				
				TelaMensagem.Exibir("Morador alterado com sucesso!");
				areatext();
			}
			else {
				TelaMensagem.Exibir("CPF informado não encontrado");
			}
		}
	
	}
		
}
	

