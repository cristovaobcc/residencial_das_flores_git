package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.BaseDados;
import Model.StatusApartamentos;

public class controllerPrincipal implements ActionListener{
	controllerLogin controllerlogin;

	public controllerPrincipal(controllerLogin controllerlogin) {
		this.controllerlogin = controllerlogin;
		control();
	}
	
	public void control() {
		
		controllerlogin.viewprincipal.getMenuItemControleMoradores().addActionListener(this);
		controllerlogin.viewprincipal.getButtonCadastroApt().addActionListener(this);
		controllerlogin.viewprincipal.getButtonCadastroMorador().addActionListener(this);
		controllerlogin.viewprincipal.getMenuItemSair().addActionListener(this);
		controllerlogin.viewprincipal.getButtonCadastroItem().addActionListener(this);
		controllerlogin.viewprincipal.getButtonCadastroItem().addActionListener(this);
		
		StatusApartamentos.CalcularAlugados();
		StatusApartamentos.CalcularDisponiveis();
		StatusApartamentos.CalcularTotal();
		controllerlogin.viewprincipal.getLabelNumeroApt().setText(StatusApartamentos.getTotal()+"");
		controllerlogin.viewprincipal.getLabelNumeroAptAlg().setText(StatusApartamentos.getAlugados()+"");
		controllerlogin.viewprincipal.getLabelNumeroAptDsp().setText(StatusApartamentos.getDisponiveis()+"");
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controllerlogin.viewprincipal.getMenuItemControleMoradores()) {
			StatusApartamentos.AtualizarDisponibilidade(controllerlogin);
			controllerlogin.viewmorador.setVisible(true);
		}
		if(e.getSource() == controllerlogin.viewprincipal.getButtonCadastroApt()) {
			
			controllerlogin.viewprincipal.getMenuItemControleApartamentos().doClick();
		}
		if(e.getSource() == controllerlogin.viewprincipal.getButtonCadastroMorador()) {
			controllerlogin.viewprincipal.getMenuItemControleMoradores().doClick();
		}
		
		//acabei de inserir isso aqui
		if(e.getSource() == controllerlogin.viewprincipal.getMenuItemControleItens()) {
			controllerlogin.viewitem.setVisible(true);
		}
//		if(e.getSource() == controllerlogin.viewprincipal.getButtonCadastroItem()) {
//			controllerlogin.viewprincipal.getMenuItemControleItens().doClick();
//		}
		
		
		if(e.getSource()==controllerlogin.viewprincipal.getMenuItemSair()) {
			if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema ?","Alerta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		if(e.getSource() ==  controllerlogin.viewprincipal.getButtonCadastroItem()) {
			controllerlogin.viewitem.setVisible(true);
		}
		
		
	}
	
}
