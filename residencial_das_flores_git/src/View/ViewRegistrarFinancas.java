/**
 * 
 */
package View;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Tela que representa o registro de despesas.
 * @author cristovao.lima
 *
 */
public class ViewRegistrarFinancas extends JFrame {
	// Outra forma de fazer isso pode ser com array, testar em outra oportunidade.
	private JLabel instrucaoLabel,
	dataLancamentoLabel,
	dataPagamentoLabel,
	descricaoLabel,
	valorLabel,
	selecioneAptoLabel;
	private JTextArea  descricaoTextArea;
	private JTextField 
	dataLancamentoTextField,
	dataPagamentoTextField,
	valorTextField;
	private JCheckBox despesaRecorrenteCheckBox;
	private JRadioButton financaIndividualRadioButton,
	financaConjuntaRadioButton, despesaRadioButton, contaRadioButton;
	private JButton registrarButton,
	cancelarButton;
	private JComboBox<String> aptosComboBox;
	private ButtonGroup individualOuConjuntaButtonGroup, tipoFinancaButtonGroup;
	
	/**
	 *
	 */
	public ViewRegistrarFinancas() {
		super("Registar Finança");
		instrucaoLabel = new JLabel("Selecione o tipo de financa:");
		dataLancamentoLabel = new JLabel("Data Lancamento");
		dataPagamentoLabel = new JLabel("Data pagamento");
		descricaoLabel = new JLabel("Descricao");
		valorLabel = new JLabel("Valor R$");
		selecioneAptoLabel = new JLabel("Selecione o apartamento");
		descricaoTextArea = new JTextArea(2, 15); // TODO: Ver o quanto precisa ajustar.
		dataLancamentoTextField = new JTextField(10);
		dataPagamentoTextField = new JTextField(10);
		valorTextField = new JTextField(10);
		despesaRecorrenteCheckBox = new JCheckBox("Despesa recorrente");
		financaIndividualRadioButton = new JRadioButton("Individual");
		financaConjuntaRadioButton = new JRadioButton("Conjunta");
		despesaRadioButton = new JRadioButton("Registar despesa");
		contaRadioButton = new JRadioButton("Registrar conta a receber");
		registrarButton = new JButton("Registrar");
		cancelarButton = new JButton("Cancelar");
		aptosComboBox = new JComboBox<String>();// TODO: criar um método lá no Controller para carregar com os numeros dos aptos.
		individualOuConjuntaButtonGroup = new ButtonGroup();
		tipoFinancaButtonGroup = new ButtonGroup();
		
		tipoFinancaButtonGroup.add(contaRadioButton);
		tipoFinancaButtonGroup.add(despesaRadioButton);
		individualOuConjuntaButtonGroup.add(financaConjuntaRadioButton);
		individualOuConjuntaButtonGroup.add(financaIndividualRadioButton);
		
		
		addComponent(instrucaoLabel, 150, 15, 190, 15, false);
		addComponent(contaRadioButton, 85, 45, 200, 15, false);
		addComponent(despesaRadioButton, 290, 45, 200, 15, false);
		addComponent(dataLancamentoLabel, 16, 87, 125, 15, false);
		addComponent(dataLancamentoTextField, 150, 87, 100, 15, true);
		addComponent(dataPagamentoLabel, 275, 87, 125, 15, false);
		addComponent(dataPagamentoTextField, 395, 87, 100, 15, true);
		addComponent(descricaoLabel, 16, 130, 125, 15, false);
		addComponent(descricaoTextArea, 85, 130, 409, 80, true);
		addComponent(valorLabel, 25, 235, 60, 15, false);
		addComponent(valorTextField, 85, 235, 60, 15, true);
		addComponent(despesaRecorrenteCheckBox, 150, 235, 170, 15, true);
		addComponent(financaIndividualRadioButton, 85, 270, 170, 15, true);
		addComponent(selecioneAptoLabel, 255, 270, 175, 15, false);
		addComponent(aptosComboBox, 430, 270, 65, 15, true);
		addComponent(financaConjuntaRadioButton, 85, 290, 170, 15, true);
		addComponent(financaConjuntaRadioButton, 85, 290, 170, 15, true);
		addComponent(registrarButton, 85, 320, 130, 20, false);
		addComponent(cancelarButton, 250, 320, 130, 20, false);
		
		setLayout(null);
		setSize(510, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(false);

	}
	
	private void addComponent(JComponent c, int x, int y, int width, int height, boolean isBorded) {
		c.setBounds(x, y, width, height);
		if (isBorded) {
			c.setBorder(BorderFactory.createLineBorder(Color.black));
		}
		this.add(c);
	}
	
	public static void main(String[] args) {
		(new ViewRegistrarFinancas()).setVisible(true);
	}
	/**
	 * @return the aptosComboBox
	 */
	public JComboBox<String> getAptosComboBox() {
		return aptosComboBox;
	}
	/**
	 * @param aptosComboBox the aptosComboBox to set
	 */
	public void setAptosComboBox(JComboBox<String> aptosComboBox) {
		this.aptosComboBox = aptosComboBox;
	}
	/**
	 * @return the descricaoLabel
	 */
	public JLabel getDescricaoLabel() {
		return descricaoLabel;
	}
	/**
	 * @return the descricaoTextArea
	 */
	public JTextArea getDescricaoTextArea() {
		return descricaoTextArea;
	}
	/**
	 * @return the dataLancamentoTextField
	 */
	public JTextField getDataLancamentoTextField() {
		return dataLancamentoTextField;
	}
	/**
	 * @return the dataPagamentoTextField
	 */
	public JTextField getDataPagamentoTextField() {
		return dataPagamentoTextField;
	}
	/**
	 * @return the despesaRecorrenteCheckBox
	 */
	public JCheckBox getDespesaRecorrenteCheckBox() {
		return despesaRecorrenteCheckBox;
	}
	
	/**
	 * @return the cancelarButton
	 */
	public JButton getCancelarButton() {
		return cancelarButton;
	}
	/**
	 * @return the selecioneAptoLabel
	 */
	public JLabel getSelecioneAptoLabel() {
		return selecioneAptoLabel;
	}
	/**
	 * @return the valorTextField
	 */
	public JTextField getValorTextField() {
		return valorTextField;
	}

	/**
	 * @return the financaIndividualRadioButton
	 */
	public JRadioButton getFinancaIndividualRadioButton() {
		return financaIndividualRadioButton;
	}

	/**
	 * @return the financaConjuntaRadioButton
	 */
	public JRadioButton getFinancaConjuntaRadioButton() {
		return financaConjuntaRadioButton;
	}

	/**
	 * @return the despesaRadioButton
	 */
	public JRadioButton getDespesaRadioButton() {
		return despesaRadioButton;
	}

	/**
	 * @return the contaRadioButton
	 */
	public JRadioButton getContaRadioButton() {
		return contaRadioButton;
	}
	
	


}
