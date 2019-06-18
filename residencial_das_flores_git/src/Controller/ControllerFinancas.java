package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JOptionPane;

import Model.Apartamento;
import Model.BaseDados;
import Model.ContaAReceber;
import Model.StatusApartamentos;


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
		//cl.viewRegistrarFinancas.getRegistrarButton().addActionListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getCancelarButton().addActionListener(new TratamentoTelaRegistrarFinancas());
		
		cl.viewRegistrarFinancas.getCancelarButton().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getRegistrarButton().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getAptosComboBox().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getDescricaoTextArea().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getDataLancamentoTextField().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getDataPagamentoTextField().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getDespesaRecorrenteCheckBox().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getDescricaoTextArea().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getDespesaRadioButton().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getValorTextField().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getFinancaConjuntaRadioButton().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getFinancaIndividualRadioButton().addKeyListener(new TratamentoTelaRegistrarFinancas());
		cl.viewRegistrarFinancas.getContaRadioButton().addKeyListener(new TratamentoTelaRegistrarFinancas());
	}
	
	private class TratamentoTelaRegistrarFinancas extends MouseAdapter implements ActionListener,KeyListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == cl.viewRegistrarFinancas.getRegistrarButton()) {
				verificaCampos();
				if(cl.viewRegistrarFinancas.getFinancaIndividualRadioButton().isSelected()) {
					String apto = cl.viewRegistrarFinancas.getAptosComboBox().getSelectedItem().toString();
					Apartamento aptoSelecionado = null;
					for (Apartamento ap : BaseDados.apartamentos) {
						if (apto.equalsIgnoreCase(ap.getNumeroPorta())) {
							aptoSelecionado = ap;
						}
					}
					if (aptoSelecionado!= null) {
						new ContaAReceber(cl.viewRegistrarFinancas.getDescricaoTextArea().getText(),
								cl.viewRegistrarFinancas.getDataLancamentoTextField().getText(), 
								cl.viewRegistrarFinancas.getDataPagamentoTextField().getText(), 
								Double.parseDouble(cl.viewRegistrarFinancas.getValorTextField().getText()), 
								cl.viewRegistrarFinancas.getFinancaConjuntaRadioButton().isSelected(), 
								cl.viewRegistrarFinancas.getDespesaRecorrenteCheckBox().isSelected(), 
								aptoSelecionado);
					}
			}}
			
		}

		@Override
		public void actionPerformed(ActionEvent e1) {
			if (e1.getSource() == cl.viewRegistrarFinancas.getRegistrarButton()) {
				verificaCampos();
				if(cl.viewRegistrarFinancas.getFinancaIndividualRadioButton().isSelected()) {
					String apto = cl.viewRegistrarFinancas.getAptosComboBox().getSelectedItem().toString();
					Apartamento aptoSelecionado = null;
					for (Apartamento ap : BaseDados.apartamentos) {
						if (apto.equalsIgnoreCase(ap.getNumeroPorta())) {
							aptoSelecionado = ap;
						}
					}
					if (aptoSelecionado!= null) {
						new ContaAReceber(cl.viewRegistrarFinancas.getDescricaoTextArea().getText(),
								cl.viewRegistrarFinancas.getDataLancamentoTextField().getText(), 
								cl.viewRegistrarFinancas.getDataPagamentoTextField().getText(), 
								Double.parseDouble(cl.viewRegistrarFinancas.getValorTextField().getText()), 
								cl.viewRegistrarFinancas.getFinancaConjuntaRadioButton().isSelected(), 
								cl.viewRegistrarFinancas.getDespesaRecorrenteCheckBox().isSelected(), 
								aptoSelecionado);
					}
							
				}
			}
			if(e1.getSource()==cl.viewRegistrarFinancas.getCancelarButton()) {
				if(JOptionPane.showConfirmDialog(null, "Deseja sair do cadastro?","Alerta",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				cl.viewRegistrarFinancas.setVisible(false);
				}
			}
			
		}

		@Override
		public void keyPressed(KeyEvent e2) {
			if(e2.getKeyCode() == KeyEvent.VK_ESCAPE) {
				if(cl.viewRegistrarFinancas.getCancelarButton().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				
				if(cl.viewRegistrarFinancas.getAptosComboBox().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getDescricaoTextArea().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getDataLancamentoTextField().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getDataPagamentoTextField().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getDespesaRecorrenteCheckBox().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getValorTextField().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getFinancaConjuntaRadioButton().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getFinancaIndividualRadioButton().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getDespesaRadioButton().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getDespesaRecorrenteCheckBox().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getRegistrarButton().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getCancelarButton().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				if(cl.viewRegistrarFinancas.getContaRadioButton().hasFocus()) {
					cl.viewRegistrarFinancas.getCancelarButton().doClick();
				}
				
				
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
	
	private void verificaCampos() {
		//TODO: implementar verificação de campos.
	}
}
