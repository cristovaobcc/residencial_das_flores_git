package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Model.BaseDados;
import Model.StatusApartamentos;

public class controllerPrincipal implements ActionListener,KeyListener{
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
		controllerlogin.viewprincipal.addKeyListener(this);
		
		controllerlogin.viewprincipal.getButtonCadastroMorador().addKeyListener(this);
		controllerlogin.viewprincipal.getButtonCadastroApt().addKeyListener(this);
		controllerlogin.viewprincipal.getButtonCadastroDespesa().addKeyListener(this);
		controllerlogin.viewprincipal.getButtonCadastroItem().addKeyListener(this);
		controllerlogin.viewprincipal.getButtonStatusResidencia().addKeyListener(this);
		
		StatusApartamentos.calcularAlugados();
		StatusApartamentos.calcularDisponiveis();
		StatusApartamentos.calcularTotal();
		controllerlogin.viewprincipal.getLabelNumeroApt().setText(StatusApartamentos.getTotal()+"");
		controllerlogin.viewprincipal.getLabelNumeroAptAlg().setText(StatusApartamentos.getAlugados()+"");
		controllerlogin.viewprincipal.getLabelNumeroAptDsp().setText(StatusApartamentos.getDisponiveis()+"");
		
		controllerlogin.viewprincipal.getMenuItemControleItens().addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controllerlogin.viewprincipal.getMenuItemControleMoradores()) {
			StatusApartamentos.atualizarDisponibilidade(controllerlogin);
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
		
		if (e.getSource()==controllerlogin.viewprincipal.getMenuItemControleFinancas()) {
			controllerlogin.viewRegistrarFinancas.setVisible(true);
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			controllerlogin.viewprincipal.getMenuItemSair().doClick();
			
		}
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if(controllerlogin.viewprincipal.getButtonCadastroMorador().hasFocus()) {
				controllerlogin.viewprincipal.getButtonCadastroMorador().doClick();
			}else if(controllerlogin.viewprincipal.getButtonCadastroApt().hasFocus()) {
				controllerlogin.viewprincipal.getButtonCadastroApt().doClick();
			}else if(controllerlogin.viewprincipal.getButtonCadastroDespesa().hasFocus()) {
				controllerlogin.viewprincipal.getButtonCadastroDespesa().doClick();
			}else if(controllerlogin.viewprincipal.getButtonCadastroItem().hasFocus()) {
				controllerlogin.viewprincipal.getButtonCadastroItem().doClick();
			}else if(controllerlogin.viewprincipal.getButtonStatusResidencia().hasFocus()) {
				controllerlogin.viewprincipal.getButtonStatusResidencia().doClick();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
