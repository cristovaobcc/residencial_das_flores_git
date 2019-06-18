package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Model.Sindico;
import View.TelaMensagem;
import View.ViewRegistrarFinancas;
import View.viewAlterarItens;
import View.viewAlterarMorador;
import View.viewAlterarSenha;
import View.viewExibirFinancas;
import View.viewItem;
import View.viewLogin;
import View.viewMorador;
import View.viewPrincipal;
import View.viewRemoveItens;
import View.viewRemoverMorador;

public class controllerLogin extends KeyAdapter implements ActionListener,MouseListener{
	public viewLogin viewlogin;
	
	//instanciar os viewrs para poder implementalos em seus pr�prios controllers,
	//no construtor de cada viewer deve possuir s� o "this.controllermenu = controllermenu".
	public viewPrincipal viewprincipal = new viewPrincipal();
	public viewAlterarSenha viewalterarsenha = new viewAlterarSenha();
	public viewMorador viewmorador = new viewMorador();
	public viewAlterarMorador viewalterarmorador = new viewAlterarMorador();
	public viewRemoverMorador removermorador = new viewRemoverMorador();
	
	public viewItem viewitem = new viewItem();
	public viewAlterarItens viewalteraritens = new viewAlterarItens();
	public viewRemoveItens viewremoveritensItens = new viewRemoveItens();
	
	public ViewRegistrarFinancas viewRegistrarFinancas = new ViewRegistrarFinancas();
	public viewExibirFinancas viewExibirfinancas = new viewExibirFinancas();
	
	public controllerLogin(viewLogin viewlogin){
		this.viewlogin = viewlogin;	
		control();
	}
	
	public void control() {
		viewlogin.getEntrarButton().addActionListener(this);
		viewlogin.getCancelarButton().addActionListener(this);
		viewlogin.getEsqueceusenhaButton().addActionListener(this);
		viewlogin.getFieldSenha().addKeyListener(this);
		viewlogin.getEntrarButton().addKeyListener(this);
		viewlogin.getCancelarButton().addKeyListener(this);
		viewlogin.getEsqueceusenhaButton().addKeyListener(this);
		viewlogin.getFieldLogin().addKeyListener(this);
		viewlogin.getFieldLogin().addMouseListener(this);
		viewlogin.getFieldSenha().addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewlogin.getEntrarButton()) {
			if(viewlogin.getFieldLogin().getText().equalsIgnoreCase(Sindico.login) 
					&& 
					viewlogin.getFieldSenha().getText().equalsIgnoreCase(Sindico.senha)) {
				viewprincipal.setVisible(true);
				viewprincipal.requestFocus();
				viewlogin.dispose();			
			}
			else {
				TelaMensagem.Exibir("Login ou Senha incorretos!");
				viewlogin.getFieldLogin().setBackground(Color.RED);
				viewlogin.getFieldSenha().setBackground(Color.RED);
				
			}
		}
		if(e.getSource() == viewlogin.getCancelarButton()) {
			if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?","Alerta",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			System.exit(0);
			}
		}
		if(e.getSource() == viewlogin.getEsqueceusenhaButton()) {
			viewalterarsenha.setVisible(true);		
		}
		
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			if(viewlogin.getCancelarButton().hasFocus()) {
				viewlogin.getCancelarButton().doClick();
			}
			if(viewlogin.getEntrarButton().hasFocus()) {
				viewlogin.getEntrarButton().doClick();
			}
			if(viewlogin.getEsqueceusenhaButton().hasFocus()) {
				viewlogin.getEsqueceusenhaButton().doClick();
			}
			if(viewlogin.getFieldLogin().hasFocus()) {
				viewlogin.getEntrarButton().doClick();
			}
			if(viewlogin.getFieldSenha().hasFocus()) {
				viewlogin.getEntrarButton().doClick();
			}
			
			
		}
		if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE) {
			viewlogin.getCancelarButton().doClick();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == viewlogin.getFieldLogin()) {
			viewlogin.getFieldLogin().setBackground(Color.WHITE);
		}
		if(e.getSource() == viewlogin.getFieldSenha()) {
			viewlogin.getFieldSenha().setBackground(Color.WHITE);
		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
