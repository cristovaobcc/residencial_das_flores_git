package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.BaseDados;
import Model.Item;

public class controllerAlterarItens implements ActionListener{

	controllerLogin controllerlogin;
	
	public controllerAlterarItens(controllerLogin controllerlogin) {
		this.controllerlogin = controllerlogin;
		control();
	}
	
	public void control() {
		controllerlogin.viewalteraritens.getButtonCancelar().addActionListener(this);
		controllerlogin.viewalteraritens.getButtonConfirmar().addActionListener(this);
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
		if(e.getSource() ==  controllerlogin.viewalteraritens.getButtonCancelar()) {
			controllerlogin.viewalteraritens.dispose();
		}
		if(e.getSource() == controllerlogin.viewalteraritens.getButtonConfirmar()) {
			if(controllerlogin.viewalteraritens.getTextfieldnovoItem().getText().isEmpty() == true 
					|| controllerlogin.viewalteraritens.getComboboxDia().getSelectedItem() == "" 
					|| controllerlogin.viewalteraritens.getComboboxMes().getSelectedItem() == "" 
					|| controllerlogin.viewalteraritens.getComboboxParcelamento().getSelectedItem() == ""
						|| controllerlogin.viewalteraritens.getTextfieldValor().getText().isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			}
			else if(BaseDados.existeItem(controllerlogin.viewalteraritens.getTextfieldItem().getText()) == true) {
				BaseDados.alterarItem(controllerlogin.viewalteraritens.getTextfieldItem().getText(), 
						controllerlogin.viewalteraritens.getTextfieldnovoItem().getText(), 
						controllerlogin.viewalteraritens.getComboboxDia().getSelectedItem() + "", 
						controllerlogin.viewalteraritens.getComboboxMes().getSelectedItem() + "", 
						controllerlogin.viewalteraritens.getComboboxParcelamento().getSelectedItem() + "", 
						controllerlogin.viewalteraritens.getTextfieldValor().getText());
				
				JOptionPane.showMessageDialog(null, "Item alterado com sucesso!");
				
				textArea();
				
			}else {
				JOptionPane.showMessageDialog(null, "Item não encontrado!");
			}
		}
		
	}
	
	
	
}
