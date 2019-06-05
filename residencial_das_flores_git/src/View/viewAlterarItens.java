package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class viewAlterarItens extends JFrame{

	JPanel contentPane,panel,panel_1,panel_2;
	JLabel labelBeta,labelCampos,labelTitulo;
	
	JButton buttonCancelar,buttonConfirmar;
	
	JLabel labelParcelamento, labelValor, labelItem, labelMes, labelDia, labelnovoItem;
	
	JTextField textfieldItem, textfieldValor, textfieldnovoItem;
	
	JComboBox<String> comboboxDia;
	JComboBox<String> comboboxMes;
	JComboBox<String> comboboxParcelamento;
	
	public viewAlterarItens() {
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 291, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(0, 0, 287, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Editar Dados do Item");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		labelTitulo.setBounds(10, 0, 267, 41);
		panel.add(labelTitulo);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 41, 287, 4);
		contentPane.add(panel_1);
		
		labelItem = new JLabel("Nome do Item: ");
		labelItem.setBounds(20, 56, 175, 14);
		contentPane.add(labelItem);
		
		textfieldItem = new JTextField();
		textfieldItem.setBounds(105, 53, 155, 20);
		contentPane.add(textfieldItem);
		textfieldItem.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 79, 287, 4);
		contentPane.add(panel_2);
		
		labelnovoItem = new JLabel("Novo Item:");
		labelnovoItem.setBounds(10, 141, 116, 14);
		contentPane.add(labelnovoItem);
		
		labelDia = new JLabel("Novo Dia:");
		labelDia.setBounds(10, 166, 116, 14);
		contentPane.add(labelDia);
		
		labelMes = new JLabel("Novo Mês:");
		labelMes.setBounds(10, 191, 116, 14);
		contentPane.add(labelMes);
		
		labelParcelamento = new JLabel("Nova Parcela:");
		labelParcelamento.setBounds(10, 216, 116, 14);
		contentPane.add(labelParcelamento);
		
		labelValor = new JLabel("Novo valor:");
		labelValor.setBounds(10, 241, 116, 14);
		contentPane.add(labelValor);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(30, 262, 96, 23);
		contentPane.add(buttonCancelar);
		
		buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.setBounds(164, 262, 96, 23);
		contentPane.add(buttonConfirmar);
		
		labelBeta = new JLabel("Vers\u00E3o Beta");
		labelBeta.setFont(new Font("Tahoma", Font.PLAIN, 7));
		labelBeta.setBounds(123, 301, 39, 14);
		contentPane.add(labelBeta);
		
		labelCampos = new JLabel("Preencha todos os campos!");
		labelCampos.setForeground(new Color(255, 0, 0));
		labelCampos.setBounds(57, 99, 170, 14);
		contentPane.add(labelCampos);
		
		textfieldnovoItem = new JTextField();
		textfieldnovoItem.setBounds(86, 138, 160, 20);
		contentPane.add(textfieldnovoItem);
		textfieldnovoItem.setColumns(10);
		
		comboboxDia = new JComboBox<String>();
		comboboxDia.addItem("");
		for(int i = 1; i <= 31; i++) {
			comboboxDia.addItem("" + i);
		}
		comboboxDia.setBounds(76, 163, 116, 20);
		contentPane.add(comboboxDia);
		
		comboboxMes = new JComboBox<String>();
		comboboxMes.addItem("");
		comboboxMes.addItem("Janeiro");
		comboboxMes.addItem("Fevereiro");
		comboboxMes.addItem("Março");
		comboboxMes.addItem("Abril");
		comboboxMes.addItem("Maio");
		comboboxMes.addItem("Junho");
		comboboxMes.addItem("Julho");
		comboboxMes.addItem("Agosto");
		comboboxMes.addItem("Setembro");
		comboboxMes.addItem("Outubro");
		comboboxMes.addItem("Novembro");
		comboboxMes.addItem("Dezembro");
		comboboxMes.setBounds(76, 188, 119, 20);
		contentPane.add(comboboxMes);
		
		comboboxParcelamento = new JComboBox<String>();
		comboboxParcelamento.addItem("");
		for(int i = 1; i <= 12; i++) {
			comboboxParcelamento.addItem(i + "X");
		}
		comboboxParcelamento.setBounds(105, 213, 131, 20);
		contentPane.add(comboboxParcelamento);
		
		textfieldValor = new JTextField();
		textfieldValor.setBounds(105, 238, 131, 20);
		contentPane.add(textfieldValor);
		textfieldValor.setColumns(10);
		
		setLocationRelativeTo(null);
	}

	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(JLabel labelTitulo) {
		this.labelTitulo = labelTitulo;
	}

	public JButton getButtonCancelar() {
		return buttonCancelar;
	}

	public void setButtonCancelar(JButton buttonCancelar) {
		this.buttonCancelar = buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		return buttonConfirmar;
	}

	public void setButtonConfirmar(JButton buttonConfirmar) {
		this.buttonConfirmar = buttonConfirmar;
	}

	public JLabel getLabelParcelamento() {
		return labelParcelamento;
	}

	public void setLabelParcelamento(JLabel labelParcelamento) {
		this.labelParcelamento = labelParcelamento;
	}

	public JLabel getLabelValor() {
		return labelValor;
	}

	public void setLabelValor(JLabel labelValor) {
		this.labelValor = labelValor;
	}

	public JLabel getLabelItem() {
		return labelItem;
	}

	public void setLabelItem(JLabel labelItem) {
		this.labelItem = labelItem;
	}

	public JLabel getLabelMes() {
		return labelMes;
	}

	public void setLabelMes(JLabel labelMes) {
		this.labelMes = labelMes;
	}

	public JLabel getLabelDia() {
		return labelDia;
	}

	public void setLabelDia(JLabel labelDia) {
		this.labelDia = labelDia;
	}

	public JLabel getLabelnovoItem() {
		return labelnovoItem;
	}

	public void setLabelnovoItem(JLabel labelnovoItem) {
		this.labelnovoItem = labelnovoItem;
	}

	public JTextField getTextfieldItem() {
		return textfieldItem;
	}

	public void setTextfieldItem(JTextField textfieldItem) {
		this.textfieldItem = textfieldItem;
	}

	public JTextField getTextfieldValor() {
		return textfieldValor;
	}

	public void setTextfieldValor(JTextField textfieldValor) {
		this.textfieldValor = textfieldValor;
	}

	public JTextField getTextfieldnovoItem() {
		return textfieldnovoItem;
	}

	public void setTextfieldnovoItem(JTextField textfieldnovoItem) {
		this.textfieldnovoItem = textfieldnovoItem;
	}

	public JComboBox<String> getComboboxDia() {
		return comboboxDia;
	}

	public void setComboboxDia(JComboBox<String> comboboxDia) {
		this.comboboxDia = comboboxDia;
	}

	public JComboBox<String> getComboboxMes() {
		return comboboxMes;
	}

	public void setComboboxMes(JComboBox<String> comboboxMes) {
		this.comboboxMes = comboboxMes;
	}

	public JComboBox<String> getComboboxParcelamento() {
		return comboboxParcelamento;
	}

	public void setComboboxParcelamento(JComboBox<String> comboboxParcelamento) {
		this.comboboxParcelamento = comboboxParcelamento;
	}
	
}
