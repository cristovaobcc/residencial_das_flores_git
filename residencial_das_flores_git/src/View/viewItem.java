package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class viewItem extends JFrame{

JPanel allPanel,panel,panel2;
	
	JLabel labelTitulo, labelImageCadastro, labelLista;
	
	JLabel labelParcelamento, labelValor, labelItem, labelMes, labelDia;
	
	JTextField textfieldItem, textfieldValor;
	
	JComboBox<String> comboboxDia;
	JComboBox<String> comboboxMes;
	JComboBox<String> comboboxParcelamento;
	
	JButton buttomAdicionar;
	JButton buttomRemover;
	JButton buttomSair;
	JButton buttomAlterar;
	
	ImageIcon cadastroImage;
	TextArea areaText;
	
	public viewItem() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(570, 414);
		allPanel = new JPanel();
		allPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(allPanel);
		allPanel.setLayout(null);
		setResizable(false);
		
		panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(0, 0, 554, 47);
		allPanel.add(panel);
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Gerenciamento de Itens");
		labelTitulo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		labelTitulo.setForeground(new Color(0, 0, 0));
		labelTitulo.setBounds(10, 18, 333, 13);
		panel.add(labelTitulo);
				
		cadastroImage = new ImageIcon(getClass().getResource("cadastroImage.png")); 
		labelImageCadastro = new JLabel(cadastroImage);
		labelImageCadastro.setBounds(493, 2, 51, 43);
		panel.add(labelImageCadastro);
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(0, 0, 0));
		panel2.setBounds(-10, 46, 564, 4);
		allPanel.add(panel2);
		
		areaText = new TextArea();
		areaText.setEditable(false);
		areaText.setBounds(315, 87, 218, 273);
		allPanel.add(areaText);
		
		textfieldItem = new JTextField();
		textfieldItem.setBounds(98, 87, 152, 20);
		allPanel.add(textfieldItem);
		textfieldItem.setColumns(10);
		
		labelItem = new JLabel("Item :");
		labelItem.setBounds(20, 90, 46, 14);
		allPanel.add(labelItem);
		
		comboboxDia = new JComboBox<String>();
		comboboxDia.addItem("");
		for(int i = 1; i <= 31; i++) {
			comboboxDia.addItem("" + i);
		}
		comboboxDia.setBounds(98, 118, 122, 20);
		comboboxDia.setBackground(Color.white);
		allPanel.add(comboboxDia);
		
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
		comboboxMes.setBounds(98, 149, 122, 20);
		comboboxMes.setBackground(Color.white);
		allPanel.add(comboboxMes);
		
		labelDia = new JLabel("Dia :");
		labelDia.setBounds(20, 121, 46, 14);
		allPanel.add(labelDia);
		
		labelMes = new JLabel("Mês :");
		labelMes.setBounds(20, 152, 46, 14);
		allPanel.add(labelMes);
		
		labelParcelamento = new JLabel("Parcelas: ");
		labelParcelamento.setBounds(19, 183, 57, 14);
		allPanel.add(labelParcelamento);
		
		comboboxParcelamento = new JComboBox<String>();
		comboboxParcelamento.addItem("");
		for(int i = 1; i <= 12; i++) {
			comboboxParcelamento.addItem(i + "X");
		}
		comboboxParcelamento.setBounds(98, 180, 152, 20);
		comboboxParcelamento.setBackground(Color.white);
		allPanel.add(comboboxParcelamento);
		
		labelValor = new JLabel("Valor:");
		labelValor.setBounds(20, 214, 46, 14);
		allPanel.add(labelValor);
		
		textfieldValor = new JTextField();
		textfieldValor.setBounds(98, 211, 152, 20);
		allPanel.add(textfieldValor);
		textfieldValor.setColumns(10);
		
		buttomAdicionar = new JButton("Adicionar");
		buttomAdicionar.setBounds(17, 301, 90, 29);
		buttomAdicionar.setBackground(Color.white);
		allPanel.add(buttomAdicionar);
		
		buttomSair = new JButton("Sair");
		buttomSair.setBounds(125, 336, 57, 29);
		buttomSair.setBackground(Color.white);
		allPanel.add(buttomSair);
		
		buttomRemover = new JButton("Remover");
		buttomRemover.setBounds(204, 301, 94, 29);
		buttomRemover.setBackground(Color.white);
		allPanel.add(buttomRemover);
		
		labelLista = new JLabel("Itens Cadastrados");
		labelLista.setBounds(315, 67, 228, 14);
		allPanel.add(labelLista);
		
		buttomAlterar = new JButton("Alterar");
		buttomAlterar.setBounds(111, 301, 90, 29);
		buttomAlterar.setBackground(Color.white);
		allPanel.add(buttomAlterar);
		
		setLocationRelativeTo(null);
	}

	public JPanel getAllPanel() {
		return allPanel;
	}

	public void setAllPanel(JPanel allPanel) {
		this.allPanel = allPanel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(JLabel labelTitulo) {
		this.labelTitulo = labelTitulo;
	}

	public JLabel getLabelImageCadastro() {
		return labelImageCadastro;
	}

	public void setLabelImageCadastro(JLabel labelImageCadastro) {
		this.labelImageCadastro = labelImageCadastro;
	}

	public JLabel getLabelLista() {
		return labelLista;
	}

	public void setLabelLista(JLabel labelLista) {
		this.labelLista = labelLista;
	}

	public JLabel getLabelItem() {
		return labelItem;
	}

	public void setLabelItem(JLabel labelItem) {
		this.labelItem = labelItem;
	}

	public JTextField getTextfieldItem() {
		return textfieldItem;
	}

	public void setTextfieldItem(JTextField textfieldItem) {
		this.textfieldItem = textfieldItem;
	}

	public JLabel getLabelDia() {
		return labelDia;
	}

	public void setLabelDia(JLabel labelDia) {
		this.labelDia = labelDia;
	}

	public JLabel getLabelMes() {
		return labelMes;
	}

	public void setLabelMes(JLabel labelMes) {
		this.labelMes = labelMes;
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

	public JButton getButtomAdicionar() {
		return buttomAdicionar;
	}

	public void setButtomAdicionar(JButton buttomAdicionar) {
		this.buttomAdicionar = buttomAdicionar;
	}

	public JButton getButtomRemover() {
		return buttomRemover;
	}

	public void setButtomRemover(JButton buttomRemover) {
		this.buttomRemover = buttomRemover;
	}

	public JButton getButtomSair() {
		return buttomSair;
	}

	public void setButtomSair(JButton buttomSair) {
		this.buttomSair = buttomSair;
	}

	public JButton getButtomAlterar() {
		return buttomAlterar;
	}

	public void setButtomAlterar(JButton buttomAlterar) {
		this.buttomAlterar = buttomAlterar;
	}

	public ImageIcon getCadastroImage() {
		return cadastroImage;
	}

	public void setCadastroImage(ImageIcon cadastroImage) {
		this.cadastroImage = cadastroImage;
	}

	public TextArea getAreaText() {
		return areaText;
	}

	public void setAreaText(TextArea areaText) {
		this.areaText = areaText;
	}

	public JLabel getLabelParcelamento() {
		return labelParcelamento;
	}

	public void setLabelParcelamento(JLabel labelParcelamento) {
		this.labelParcelamento = labelParcelamento;
	}

	public JComboBox<String> getComboboxParcelamento() {
		return comboboxParcelamento;
	}

	public void setComboboxParcelamento(JComboBox<String> comboboxParcelamento) {
		this.comboboxParcelamento = comboboxParcelamento;
	}

	public JLabel getLabelValor() {
		return labelValor;
	}

	public void setLabelValor(JLabel labelValor) {
		this.labelValor = labelValor;
	}

	public JTextField getTextfieldValor() {
		return textfieldValor;
	}

	public void setTextfieldValor(JTextField textfieldValor) {
		this.textfieldValor = textfieldValor;
	}
	
}
