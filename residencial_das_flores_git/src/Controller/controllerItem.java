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

import Model.BaseDados;
import Model.Item;
import View.viewItem;

public class controllerItem extends Observable implements ActionListener,KeyListener,MouseListener{

	controllerLogin controllerlogin;
	private viewItem item;
	
	public controllerItem(controllerLogin controllerlogin) {
		this.controllerlogin = controllerlogin;
		control();
	}
	
	public void control() {
		controllerlogin.viewitem.getButtomAdicionar().addActionListener(this);
		controllerlogin.viewitem.getButtomRemover().addActionListener(this);
		controllerlogin.viewitem.getButtomAlterar().addActionListener(this);
		controllerlogin.viewitem.getButtomSair().addActionListener(this);
		
		controllerlogin.viewitem.getButtomAdicionar().addKeyListener(this);
		controllerlogin.viewitem.getButtomRemover().addKeyListener(this);
		controllerlogin.viewitem.getButtomAlterar().addKeyListener(this);
		controllerlogin.viewitem.getButtomSair().addKeyListener(this);
		
		controllerlogin.viewitem.getTextfieldItem().addKeyListener(this);
		controllerlogin.viewitem.getTextfieldValor().addKeyListener(this);
		controllerlogin.viewitem.getComboboxDia().addKeyListener(this);
		controllerlogin.viewitem.getComboboxMes().addKeyListener(this);
		controllerlogin.viewitem.getComboboxParcelamento().addKeyListener(this);
		
		controllerlogin.viewitem.getTextfieldItem().addMouseListener(this);
		controllerlogin.viewitem.getTextfieldValor().addMouseListener(this);
		controllerlogin.viewitem.getComboboxDia().addMouseListener(this);
		controllerlogin.viewitem.getComboboxMes().addMouseListener(this);
		controllerlogin.viewitem.getComboboxParcelamento().addMouseListener(this);
		
		
		
		
	}
	
	public void textArea() {
		controllerlogin.viewitem.getAreaText().setText(null);
		for(Item list : BaseDados.itens) {
			controllerlogin.viewitem.getAreaText().append(
					"**********Dados**********"
					+ "\nItem: " + list.nome
					+ "\nDia: " + list.dia
					+ "\nMês: " + list.mes
					+ "\nParcelas: " + list.parcelamento
					+ "\nValor: " + list.valor
					+ "\n***************************\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//adicionar
		if(e.getSource() == controllerlogin.viewitem.getButtomAdicionar()) {
			if(controllerlogin.viewitem.getTextfieldItem().getText().isEmpty() == true 
					|| controllerlogin.viewitem.getComboboxDia().getSelectedItem() == ""
						|| controllerlogin.viewitem.getComboboxMes().getSelectedItem() == "" 
						|| controllerlogin.viewitem.getComboboxParcelamento().getSelectedItem() == ""
						|| controllerlogin.viewitem.getTextfieldValor().getText().isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				if(controllerlogin.viewitem.getTextfieldItem().getText().isEmpty()) {
					controllerlogin.viewitem.getTextfieldItem().setBackground(Color.RED);
				}
				if(controllerlogin.viewitem.getComboboxDia().getSelectedItem() == "") {
					controllerlogin.viewitem.getComboboxDia().setBackground(Color.RED);
				}
				if(controllerlogin.viewitem.getComboboxMes().getSelectedItem() == "") {
					controllerlogin.viewitem.getComboboxMes().setBackground(Color.RED);
				}
				if(controllerlogin.viewitem.getComboboxParcelamento().getSelectedItem() == "") {
					controllerlogin.viewitem.getComboboxParcelamento().setBackground(Color.RED);
				}
				if(controllerlogin.viewitem.getTextfieldValor().getText().isEmpty()) {
					controllerlogin.viewitem.getTextfieldValor().setBackground(Color.RED);
				}
			}else {
				if(BaseDados.adicionarItem(new Item(controllerlogin.viewitem.getTextfieldItem().getText(), 
						controllerlogin.viewitem.getComboboxDia().getSelectedItem() + "",
						controllerlogin.viewitem.getComboboxMes().getSelectedItem() + "", 
						controllerlogin.viewitem.getComboboxParcelamento().getSelectedItem() + "",
						controllerlogin.viewitem.getTextfieldValor().getText()))) {
					
					setChanged();
					notifyObservers();
					
					JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
					
					textArea();
					
					controllerlogin.viewitem.getTextfieldItem().setText("");
					controllerlogin.viewitem.getComboboxDia().setSelectedIndex(0);
					controllerlogin.viewitem.getComboboxMes().setSelectedIndex(0);
					controllerlogin.viewitem.getComboboxParcelamento().setSelectedIndex(0);
					controllerlogin.viewitem.getTextfieldValor().setText("");
				}
			}
		}
		//remover
		if(e.getSource() == controllerlogin.viewitem.getButtomRemover()) {
			controllerlogin.viewremoveritensItens.setVisible(true);
		}
		
		//alterar
		if(e.getSource() == controllerlogin.viewitem.getButtomAlterar()) {
			controllerlogin.viewalteraritens.setVisible(true);
		}
		
		//sair
		if(e.getSource() == controllerlogin.viewitem.getButtomSair()) {
			if(JOptionPane.showConfirmDialog(null, "Deseja sair do cadastro?","Alerta",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			controllerlogin.viewitem.dispose();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==controllerlogin.viewitem.getTextfieldItem()) {
			controllerlogin.viewitem.getTextfieldItem().setBackground(Color.WHITE);
		}
		if(e.getSource()==controllerlogin.viewitem.getTextfieldValor()) {
			controllerlogin.viewitem.getTextfieldValor().setBackground(Color.WHITE);
		}
		if(e.getSource()==controllerlogin.viewitem.getComboboxDia()) {
			controllerlogin.viewitem.getComboboxDia().setBackground(Color.WHITE);
		}
		if(e.getSource()==controllerlogin.viewitem.getComboboxMes()) {
			controllerlogin.viewitem.getComboboxMes().setBackground(Color.WHITE);
		}
		if(e.getSource()==controllerlogin.viewitem.getComboboxParcelamento()) {
			controllerlogin.viewitem.getComboboxParcelamento().setBackground(Color.WHITE);
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
			if(controllerlogin.viewitem.getTextfieldItem().hasFocus()) {
				controllerlogin.viewitem.getButtomAdicionar().doClick();
			}
			if(controllerlogin.viewitem.getTextfieldValor().hasFocus()) {
				controllerlogin.viewitem.getButtomAdicionar().doClick();
			}
			if(controllerlogin.viewitem.getComboboxDia().hasFocus()) {
				controllerlogin.viewitem.getButtomAdicionar().doClick();
			}
			if(controllerlogin.viewitem.getComboboxMes().hasFocus()) {
				controllerlogin.viewitem.getButtomAdicionar().doClick();
			}
			if(controllerlogin.viewitem.getComboboxParcelamento().hasFocus()) {
				controllerlogin.viewitem.getButtomAdicionar().doClick();
			}
			
			if(controllerlogin.viewitem.getButtomAdicionar().hasFocus()) {
				controllerlogin.viewitem.getButtomAdicionar().doClick();
			}
			if(controllerlogin.viewitem.getButtomAlterar().hasFocus()) {
				controllerlogin.viewitem.getButtomAlterar().doClick();
			}
			if(controllerlogin.viewitem.getButtomRemover().hasFocus()) {
				controllerlogin.viewitem.getButtomRemover().doClick();
			}
			if(controllerlogin.viewitem.getButtomSair().hasFocus()) {
				controllerlogin.viewitem.getButtomSair().doClick();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			controllerlogin.viewitem.getButtomSair().doClick();
			
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
