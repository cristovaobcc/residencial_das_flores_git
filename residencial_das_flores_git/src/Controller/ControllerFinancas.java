package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import Model.Apartamento;
import Model.ContaAReceber;


public class ControllerFinancas extends Observable{
	controllerLogin cl;
	TratamentoTelaRegistrarFinancas tratamentoTelaRegistrarFinancas;
	
	public ControllerFinancas(controllerLogin cLogin) {
		this.cl = cLogin;
		tratamentoTelaRegistrarFinancas = new TratamentoTelaRegistrarFinancas();
		control();
	}
	
	public void control() {
		cl.viewRegistrarFinancas.getRegistrarButton().addMouseListener(tratamentoTelaRegistrarFinancas);
	}
	
	private class TratamentoTelaRegistrarFinancas extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == cl.viewRegistrarFinancas.getRegistrarButton()) {
				verificaCampos();
				if(cl.viewRegistrarFinancas.getFinancaIndividualRadioButton().isSelected()) {
					new ContaAReceber(cl.viewRegistrarFinancas.getDescricaoTextArea().getText(),
							cl.viewRegistrarFinancas.getDataLancamentoTextField().getText(), 
							cl.viewRegistrarFinancas.getDataPagamentoTextField().getText(), 
							Double.parseDouble(cl.viewRegistrarFinancas.getValorTextField().getText()), true, 
							cl.viewRegistrarFinancas.getDespesaRecorrenteCheckBox().isSelected(), 
							(Apartamento) cl.viewRegistrarFinancas.getAptosComboBox().getSelectedItem());
				}
			}
		}
		
		
	}
	
	private void verificaCampos() {
		//TODO: implementar verificação de campos.
	}
}
