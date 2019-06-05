package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Model.Sindico;
import View.TelaMensagem;
import View.viewAlterarItens;
import View.viewAlterarMorador;
import View.viewAlterarSenha;
import View.viewItem;
import View.viewLogin;
import View.viewMorador;
import View.viewPrincipal;
import View.viewRemoveItens;
import View.viewRemoverMorador;

public class controllerLogin implements ActionListener{
	public viewLogin viewlogin;
	
	//instanciar os viewrs para poder implementalos em seus próprios controllers,
	//no construtor de cada viewer deve possuir só o "this.controllermenu = controllermenu".
	public viewPrincipal viewprincipal = new viewPrincipal();
	public viewAlterarSenha viewalterarsenha = new viewAlterarSenha();
	public viewMorador viewmorador = new viewMorador();
	public viewAlterarMorador viewalterarmorador = new viewAlterarMorador();
	public viewRemoverMorador removermorador = new viewRemoverMorador();
	
	public viewItem viewitem = new viewItem();
	public viewAlterarItens viewalteraritens = new viewAlterarItens();
	public viewRemoveItens viewremoveritensItens = new viewRemoveItens();
	
	public controllerLogin(viewLogin viewlogin){
		this.viewlogin = viewlogin;	
		control();
	}
	
	public void control() {
		viewlogin.getEntrarButton().addActionListener(this);
		viewlogin.getCancelarButton().addActionListener(this);
		viewlogin.getEsqueceusenhaButton().addActionListener(this);
		viewlogin.getFieldSenha().addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					viewlogin.getEntrarButton().doClick();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					viewlogin.getEntrarButton().doClick();
				}
				
			}
		
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewlogin.getEntrarButton()) {
			if(viewlogin.getFieldLogin().getText().equalsIgnoreCase(Sindico.login) 
					&& 
					viewlogin.getFieldSenha().getText().equalsIgnoreCase(Sindico.senha)) {
				viewprincipal.setVisible(true);
				viewlogin.dispose();			
			}
			else {
				TelaMensagem.Exibir("Login ou Senha incorretos!");
			}
		}
		if(e.getSource() == viewlogin.getCancelarButton()) {
			System.exit(0);
		}
		if(e.getSource() == viewlogin.getEsqueceusenhaButton()) {
			viewalterarsenha.setVisible(true);		
		}
		
		
	}
	
	
	
}
