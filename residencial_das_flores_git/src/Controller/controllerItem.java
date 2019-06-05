package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;

import Model.BaseDados;
import Model.Item;
import View.viewItem;

public class controllerItem extends Observable implements ActionListener{

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
			controllerlogin.viewitem.dispose();
		}
		
	}
	
}
