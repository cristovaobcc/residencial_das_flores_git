package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class viewMorador extends JFrame {
	JPanel allPanel,panel,panel2;
	JLabel labelTitulo,labelImageCadastro,labelSelecioneApt,labelNome,labelCpf,labelRg,labelTelefone,labelData,labelLista;
	JFormattedTextField fieldNome,fieldCpf,fieldRg,fieldTelefone,fieldData;
	JButton novoButton,alterarButton,removerButton,sairButton;
	ImageIcon cadastroImage;
	TextArea areaText;
	JComboBox<String> combobox;

	public viewMorador() {
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
		
		labelTitulo = new JLabel("Gerenciamento de Moradores");
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
		
		fieldNome = new JFormattedTextField();
		fieldNome.setBounds(98, 87, 152, 20);
		allPanel.add(fieldNome);
		fieldNome.setColumns(10);
		
		fieldCpf = new JFormattedTextField();
		fieldCpf.setBounds(98, 118, 152, 20);
		allPanel.add(fieldCpf);
		fieldCpf.setColumns(10);
		
		fieldRg = new JFormattedTextField();
		fieldRg.setBounds(98, 149, 152, 20);
		allPanel.add(fieldRg);
		fieldRg.setColumns(10);
		
		fieldTelefone = new JFormattedTextField();
		fieldTelefone.setBounds(98, 180, 152, 20);
		allPanel.add(fieldTelefone);
		fieldTelefone.setColumns(10);
		
		labelNome = new JLabel("Nome :");
		labelNome.setBounds(20, 90, 46, 14);
		allPanel.add(labelNome);
		
		labelCpf = new JLabel("CPF :");
		labelCpf.setBounds(20, 121, 46, 14);
		allPanel.add(labelCpf);
		
		labelRg = new JLabel("RG :");
		labelRg.setBounds(20, 152, 46, 14);
		allPanel.add(labelRg);
		
		labelTelefone = new JLabel("Telefone :");
		labelTelefone.setBounds(19, 183, 57, 14);
		allPanel.add(labelTelefone);
		
		labelSelecioneApt = new JLabel("Selecione o Apartamento");
		labelSelecioneApt.setBounds(69, 245, 152, 14);
		allPanel.add(labelSelecioneApt);
		
		combobox = new JComboBox<String>();
		combobox.setBounds(79, 270, 122, 20);
		
		allPanel.add(combobox);
		
		labelData = new JLabel("Data :");
		labelData.setBounds(20, 214, 46, 14);
		allPanel.add(labelData);
		
		fieldData = new JFormattedTextField();
		fieldData.setBounds(98, 211, 152, 20);
		allPanel.add(fieldData);
		fieldData.setColumns(10);
		
		novoButton = new JButton("Novo");
		novoButton.setBounds(17, 301, 90, 29);
		novoButton.setBackground(Color.white);
		allPanel.add(novoButton);
		
		sairButton = new JButton("Sair");
		sairButton.setBounds(125, 336, 57, 29);
		sairButton.setBackground(Color.white);
		allPanel.add(sairButton);
		
		removerButton = new JButton("Remover");
		removerButton.setBounds(204, 301, 94, 29);
		removerButton.setBackground(Color.white);
		allPanel.add(removerButton);
		
		labelLista = new JLabel("Moradores Cadastrados");
		labelLista.setBounds(315, 67, 228, 14);
		allPanel.add(labelLista);
		
		alterarButton = new JButton("Alterar");
		alterarButton.setBounds(111, 301, 90, 29);
		alterarButton.setBackground(Color.white);
		allPanel.add(alterarButton);
		
		formatarCampo();
		
		setLocationRelativeTo(null);
}

	private void formatarCampo() {
		try {
			MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
			maskCpf.install(fieldCpf);
			MaskFormatter maskData = new MaskFormatter("##/##/####");
			maskData.install(fieldData);
			MaskFormatter maskTelefone = new MaskFormatter("(##)#####-####");
			maskTelefone.install(fieldTelefone);
					
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro no formato do campo de Texto!","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldCpf() {
		return fieldCpf;
	}

	public JTextField getFieldRg() {
		return fieldRg;
	}

	public JTextField getFieldTelefone() {
		return fieldTelefone;
	}

	public JTextField getFieldData() {
		return fieldData;
	}

	public JButton getNovoButton() {
		return novoButton;
	}

	public JButton getAlterarButton() {
		return alterarButton;
	}

	public JButton getRemoverButton() {
		return removerButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	public TextArea getAreaText() {
		return areaText;
	}

	public JComboBox getCombobox() {
		return combobox;
	}
}