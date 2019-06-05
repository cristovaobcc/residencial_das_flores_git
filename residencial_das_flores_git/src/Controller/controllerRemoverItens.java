package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;

import Model.BaseDados;
import Model.Item;

public class controllerRemoverItens extends Observable implements ActionListener{

	controllerLogin controllerlogin;
	
	public controllerRemoverItens(controllerLogin controllerlogin) {
		this.controllerlogin = controllerlogin;
		control();
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
	
	public void control() {
		controllerlogin.viewremoveritensItens.getButtonConfirmar().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controllerlogin.viewremoveritensItens.getButtonConfirmar()) {
			if(controllerlogin.viewremoveritensItens.getTextFieldNome().getText().isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "Preencha o campo!");
			}
			else if(BaseDados.remover(controllerlogin.viewremoveritensItens.getTextFieldNome().getText())) {
				
				setChanged();
				notifyObservers();
				
				JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
				
				textArea();
				
			}else {
				JOptionPane.showMessageDialog(null, "Item não encontrado!");
			}
		}
		
	}

}
