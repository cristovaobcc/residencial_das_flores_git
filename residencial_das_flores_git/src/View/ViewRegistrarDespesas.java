/**
 * 
 */
package View;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Apartamento;

/**
 * Tela que representa o registro de despesas.
 * @author cristovao.lima
 *
 */
public class ViewRegistrarDespesas extends JFrame {
	// Outra forma de fazer isso pode ser com array, testar em outra oportunidade.
	private JLabel idLabel,
	dataLancamentoLabel,
	dataPagamentoLabel,
	descricaoLabel,
	valorLabel,
	selecioneAptoLabel;
	private JTextArea  descricaoTextArea;
	private JTextField idTextField,
	dataLancamentoTextField,
	dataPagamentoTextField,
	valorTextField;
	private JCheckBox despesaRecorrenteCheckBox;
	private JRadioButton despesaIndividualRadioButton,
	despesaConjuntaRadioButton;
	private JButton registrarButton,
	cancelarButton;
	private JComboBox<Apartamento> aptosComboBox;
	private ButtonGroup despesasButtonGroup;
	/**
	 *
	 */
	public ViewRegistrarDespesas() {
		super("Registar despesa");
		idLabel = new JLabel("Id");
		dataLancamentoLabel = new JLabel("Data Lançamento");
		dataPagamentoLabel = new JLabel("Data pagamento");
		descricaoLabel = new JLabel("Descrição");
		valorLabel = new JLabel("Valor R$");
		selecioneAptoLabel = new JLabel("Selecione o apartamento");
		descricaoTextArea = new JTextArea(2, 15); // TODO: Ver o quanto precisa ajustar.
		idTextField = new JTextField(5);
		dataLancamentoTextField = new JTextField(10);
		dataPagamentoTextField = new JTextField(10);
		valorTextField = new JTextField(10);
		despesaRecorrenteCheckBox = new JCheckBox("Despesa recorrente");
		despesaIndividualRadioButton = new JRadioButton("Despesa individual");
		despesaConjuntaRadioButton = new JRadioButton("Despesa conjunta");
		registrarButton = new JButton("Registrar");
		cancelarButton = new JButton("Cancelar");
		aptosComboBox = new JComboBox<Apartamento>();
		despesasButtonGroup = new ButtonGroup();

		despesasButtonGroup.add(despesaConjuntaRadioButton);
		despesasButtonGroup.add(despesaIndividualRadioButton);

		setLayout(new GridBagLayout());
		setSize(535, 430);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(false);

	}
	/**
	 * @return the aptosComboBox
	 */
	public JComboBox<Apartamento> getAptosComboBox() {
		return aptosComboBox;
	}
	/**
	 * @param aptosComboBox the aptosComboBox to set
	 */
	public void setAptosComboBox(JComboBox<Apartamento> aptosComboBox) {
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
	 * @return the idTextField
	 */
	public JTextField getIdTextField() {
		return idTextField;
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
	 * @return the despesaIndividualRadioButton
	 */
	public JRadioButton getDespesaIndividualRadioButton() {
		return despesaIndividualRadioButton;
	}
	/**
	 * @return the despesaConjuntaRadioButton
	 */
	public JRadioButton getDespesaConjuntaRadioButton() {
		return despesaConjuntaRadioButton;
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
	
	

}
