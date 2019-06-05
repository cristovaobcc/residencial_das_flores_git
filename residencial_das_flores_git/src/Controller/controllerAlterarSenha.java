package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Sindico;
import View.TelaMensagem;

public class controllerAlterarSenha implements ActionListener {
	controllerLogin controllerlogin;
	

	public controllerAlterarSenha(controllerLogin controllerlogin) {
		this.controllerlogin = controllerlogin;
		control();
	}
	
	public void control() {
		controllerlogin.viewalterarsenha.getButtonSair().addActionListener(this);
		controllerlogin.viewalterarsenha.getButtonConfirmar().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controllerlogin.viewalterarsenha.getButtonSair()) {
			controllerlogin.viewalterarsenha.dispose();
		}
		if(e.getSource() == controllerlogin.viewalterarsenha.getButtonConfirmar()) {
			if(controllerlogin.viewalterarsenha.getFieldCpf().getText().isEmpty() == true||
					controllerlogin.viewalterarsenha.getFieldCpf().getText().isEmpty() == true||
						controllerlogin.viewalterarsenha.getFieldCpf().getText().isEmpty() == true) {
					TelaMensagem.Exibir("Complete todos os Campos!");
					
			}
			else if(controllerlogin.viewalterarsenha.getFieldLogin().getText().equalsIgnoreCase(Sindico.login) 
						&&
						controllerlogin.viewalterarsenha.getFieldCpf().getText().equalsIgnoreCase(Sindico.cpf)) {
					Sindico.setSenha(controllerlogin.viewalterarsenha.getFieldSenha().getText());
					TelaMensagem.Exibir("Senha alterada com Sucesso!");
					controllerlogin.viewalterarsenha.dispose();
				}
			
			else{
				TelaMensagem.Exibir("CPF ou Login Incorretos!");
			}
			
			
		}
		
	}
	

}
