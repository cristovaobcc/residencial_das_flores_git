package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import javax.swing.JOptionPane;

import Model.Apartamento;
import Model.BaseDados;
import Model.Morador;
import Model.Sindico;
import Model.StatusApartamentos;
import View.TelaMensagem;

public class controllerMorador extends Observable implements ActionListener,KeyListener,MouseListener {
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
		
		controllerlogin.viewmorador.getNovoButton().addKeyListener(this);
		controllerlogin.viewmorador.getAlterarButton().addKeyListener(this);
		controllerlogin.viewmorador.getRemoverButton().addKeyListener(this);
		controllerlogin.viewmorador.getSairButton().addKeyListener(this);
		
		controllerlogin.viewmorador.getFieldNome().addKeyListener(this);
		controllerlogin.viewmorador.getFieldCpf().addKeyListener(this);
		controllerlogin.viewmorador.getFieldData().addKeyListener(this);
		controllerlogin.viewmorador.getFieldRg().addKeyListener(this);
		controllerlogin.viewmorador.getFieldTelefone().addKeyListener(this);
		
		controllerlogin.viewmorador.getFieldNome().addMouseListener(this);
		controllerlogin.viewmorador.getFieldCpf().addMouseListener(this);
		controllerlogin.viewmorador.getFieldData().addMouseListener(this);
		controllerlogin.viewmorador.getFieldRg().addMouseListener(this);
		controllerlogin.viewmorador.getFieldTelefone().addMouseListener(this);
		
		
		StatusApartamentos.atualizarDisponibilidade(controllerlogin);
		}
	
	
	public void areatext() {
		controllerlogin.viewmorador.getAreaText().setText(null);
		for(Morador morador : BaseDados.moradores) {
			controllerlogin.viewmorador.getAreaText().append(
					"********Dados*********" +
					"\nHospede do Quarto Nº"+morador.numeroapartamento +
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
				if(controllerlogin.viewmorador.getFieldNome().getText().isEmpty()) {
					controllerlogin.viewmorador.getFieldNome().setBackground(Color.RED);
				}
				if(controllerlogin.viewmorador.getFieldCpf().getText().equals("   .   .   -  ")) {
					controllerlogin.viewmorador.getFieldCpf().setBackground(Color.RED);
				}
				if(controllerlogin.viewmorador.getFieldRg().getText().isEmpty()) {
					controllerlogin.viewmorador.getFieldRg().setBackground(Color.RED);
				}
				if(controllerlogin.viewmorador.getFieldTelefone().getText().equals("(  )     -    ")) {
					controllerlogin.viewmorador.getFieldTelefone().setBackground(Color.RED);
				}
				if(controllerlogin.viewmorador.getFieldData().getText().equals("  /  /    ")) {
					controllerlogin.viewmorador.getFieldData().setBackground(Color.RED);
				}
				
				
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
			if(JOptionPane.showConfirmDialog(null, "Deseja sair do cadastro?","Alerta",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			controllerlogin.viewmorador.dispose();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==controllerlogin.viewmorador.getFieldNome()) {
			controllerlogin.viewmorador.getFieldNome().setBackground(Color.white);
		}
		if(e.getSource()==controllerlogin.viewmorador.getFieldCpf()) {
			controllerlogin.viewmorador.getFieldCpf().setBackground(Color.white);
		}
		if(e.getSource()==controllerlogin.viewmorador.getFieldData()) {
			controllerlogin.viewmorador.getFieldData().setBackground(Color.white);
		}
		if(e.getSource()==controllerlogin.viewmorador.getFieldRg()) {
			controllerlogin.viewmorador.getFieldRg().setBackground(Color.white);
		}
		if(e.getSource()==controllerlogin.viewmorador.getFieldTelefone()) {
			controllerlogin.viewmorador.getFieldTelefone().setBackground(Color.white);
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

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		if(controllerlogin.viewmorador.getNovoButton().hasFocus()) {
			controllerlogin.viewmorador.getNovoButton().doClick();
		}
		if(controllerlogin.viewmorador.getSairButton().hasFocus()) {
			controllerlogin.viewmorador.getSairButton().doClick();
		}
		if(controllerlogin.viewmorador.getAlterarButton().hasFocus()) {
			controllerlogin.viewmorador.getAlterarButton().doClick();
		}
		if(controllerlogin.viewmorador.getRemoverButton().hasFocus()) {
			controllerlogin.viewmorador.getRemoverButton().doClick();
		}
		
		if(controllerlogin.viewmorador.getFieldNome().hasFocus()) {
			controllerlogin.viewmorador.getNovoButton().doClick();
		}
		if(controllerlogin.viewmorador.getFieldCpf().hasFocus()) {
			controllerlogin.viewmorador.getNovoButton().doClick();
		}
		if(controllerlogin.viewmorador.getFieldData().hasFocus()) {
			controllerlogin.viewmorador.getNovoButton().doClick();
		}
		if(controllerlogin.viewmorador.getFieldRg().hasFocus()) {
			controllerlogin.viewmorador.getNovoButton().doClick();
		}
		if(controllerlogin.viewmorador.getFieldTelefone().hasFocus()) {
			controllerlogin.viewmorador.getNovoButton().doClick();
		}
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			controllerlogin.viewmorador.getSairButton().doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
