package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import Model.Apartamento;
import Model.BaseDados;
import Model.Morador;
import Model.Sindico;
import Model.StatusApartamentos;
import View.TelaMensagem;

public class controllerMorador extends Observable implements ActionListener {
	controllerLogin controllerlogin;
	
	public controllerMorador(controllerLogin controllerlogin) {
		this.controllerlogin = controllerlogin;
		control();
	}
	
	public void control() {
		controllerlogin.viewmorador.getNovoButton().addActionListener(this);
		controllerlogin.viewmorador.getAlterarButton().addActionListener(this);
		controllerlogin.viewmorador.getRemoverButton().addActionListener(this);
		controllerlogin.viewmorador.getSairButton().addActionListener(this);
		StatusApartamentos.atualizarDisponibilidade(controllerlogin);
		}
	
	
	public void areatext() {
		controllerlogin.viewmorador.getAreaText().setText(null);
		for(Morador morador : BaseDados.moradores) {
			controllerlogin.viewmorador.getAreaText().append(
					"********Dados*********" +
					"\nH�spede do Quarto N�"+morador.numeroapartamento +
					"\nNome : "+ morador.nome +
					"\nCPF : "+ morador.cpf +
					"\nRG : "+ morador.rg +
					"\nTelefone : " + morador.telefone +
					"\nData Entrada :" + morador.dataentrada +
					"\n************************\n");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==  controllerlogin.viewmorador.getNovoButton()) {
			if(controllerlogin.viewmorador.getFieldNome().getText().isEmpty() == true ||
					controllerlogin.viewmorador.getFieldCpf().getText().isEmpty() == true ||
					controllerlogin.viewmorador.getFieldRg().getText().isEmpty() == true ||
					controllerlogin.viewmorador.getFieldTelefone().getText().isEmpty() == true ||
					controllerlogin.viewmorador.getFieldData().getText().isEmpty() == true ) {
				TelaMensagem.Exibir("Preencha todos os campos!");
			}
			else {
				Sindico.sindicoAdicionarMorador(controllerlogin.viewmorador.getFieldNome().getText(),
						controllerlogin.viewmorador.getFieldRg().getText(),
						controllerlogin.viewmorador.getFieldCpf().getText(),
						controllerlogin.viewmorador.getFieldTelefone().getText(),
						controllerlogin.viewmorador.getFieldData().getText(),
						controllerlogin.viewmorador.getCombobox().getSelectedItem()+"");
				Apartamento a = BaseDados.Buscar((String)controllerlogin.viewmorador.getCombobox().getSelectedItem());
				a.setTipoOcupacao("Inquilino");
				StatusApartamentos.calcularAlugados();
				StatusApartamentos.calcularDisponiveis();
				StatusApartamentos.calcularTotal();
				setChanged();
				notifyObservers();
				
				String x = controllerlogin.viewmorador.getCombobox().getSelectedItem()+"";
				controllerlogin.viewmorador.getCombobox().removeItem(x);
				TelaMensagem.Exibir("Morador Cadastrado com Sucesso!");
				areatext();
				
				controllerlogin.viewmorador.getFieldNome().setText("");
				controllerlogin.viewmorador.getFieldRg().setText("");
				controllerlogin.viewmorador.getFieldCpf().setText("");
				controllerlogin.viewmorador.getFieldTelefone().setText("");
				controllerlogin.viewmorador.getFieldData().setText("");		
			}
			
		}
		if(e.getSource() == controllerlogin.viewmorador.getAlterarButton()) {
			controllerlogin.viewalterarmorador.setVisible(true);
		}
		if(e.getSource() == controllerlogin.viewmorador.getRemoverButton()) {
			controllerlogin.removermorador.setVisible(true);
		}
		if(e.getSource() == controllerlogin.viewmorador.getSairButton()) {
			controllerlogin.viewmorador.dispose();
		}
		
	}
	
}
