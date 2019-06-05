package View;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class viewAlterarMorador extends JFrame {
	JPanel contentPane,panel,panel_1,panel_2;
	JLabel labelCpf,labelNovoCpf,labelNovoNome,labelNovoRg,labelNovoTelefone,labelBeta,labelCampos,labelTitulo;
	JFormattedTextField fieldCPF,fieldNovoNome,fieldNovoCPF,fieldNovoRG,fieldNovoTelefone;
	JButton buttonCancelar,buttonConfirmar;

	public viewAlterarMorador() {
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
		
		labelTitulo = new JLabel("Editar Dados do Morador");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		labelTitulo.setBounds(10, 0, 267, 41);
		panel.add(labelTitulo);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 41, 287, 4);
		contentPane.add(panel_1);
		
		labelCpf = new JLabel("Insira o CPF :");
		labelCpf.setBounds(20, 56, 175, 14);
		contentPane.add(labelCpf);
		
		fieldCPF = new JFormattedTextField();
		fieldCPF.setBounds(105, 53, 155, 20);
		contentPane.add(fieldCPF);
		fieldCPF.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 79, 287, 4);
		contentPane.add(panel_2);
		
		labelNovoNome = new JLabel("Novo nome :");
		labelNovoNome.setBounds(10, 141, 116, 14);
		contentPane.add(labelNovoNome);
		
		labelNovoCpf = new JLabel("Novo CPF :");
		labelNovoCpf.setBounds(10, 166, 116, 14);
		contentPane.add(labelNovoCpf);
		
		labelNovoRg = new JLabel("Novo Rg :");
		labelNovoRg.setBounds(10, 191, 116, 14);
		contentPane.add(labelNovoRg);
		
		labelNovoTelefone = new JLabel("Novo Telefone :");
		labelNovoTelefone.setBounds(10, 216, 116, 14);
		contentPane.add(labelNovoTelefone);
		
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
		
		fieldNovoNome = new JFormattedTextField();
		fieldNovoNome.setBounds(86, 138, 160, 20);
		contentPane.add(fieldNovoNome);
		fieldNovoNome.setColumns(10);
		
		fieldNovoCPF = new JFormattedTextField();
		fieldNovoCPF.setBounds(76, 163, 116, 20);
		contentPane.add(fieldNovoCPF);
		fieldNovoCPF.setColumns(10);
		
		fieldNovoRG = new JFormattedTextField();
		fieldNovoRG.setBounds(76, 188, 119, 20);
		contentPane.add(fieldNovoRG);
		fieldNovoRG.setColumns(10);
		
		fieldNovoTelefone = new JFormattedTextField();
		fieldNovoTelefone.setBounds(105, 213, 131, 20);
		contentPane.add(fieldNovoTelefone);
		fieldNovoTelefone.setColumns(10);
		
		formatarCampos();
		
		setLocationRelativeTo(null);
	}
	
	public void formatarCampos() {
		try {
			MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
			maskCpf.install(fieldCPF);
			
			MaskFormatter maskNovoCpf = new MaskFormatter("###.###.###-##");
			maskNovoCpf.install(fieldNovoCPF);;
			
			MaskFormatter maskTelefone = new MaskFormatter("(##)#####-####");
			maskTelefone.install(fieldNovoTelefone);
		
		} catch (ParseException e) {
			TelaMensagem.Exibir("Formatação de Cpf Inválida!");
		}
	}
	
	public JTextField getFieldCPF() {
		return fieldCPF;
	}

	public JTextField getFieldNovoNome() {
		return fieldNovoNome;
	}

	public JTextField getFieldNovoCPF() {
		return fieldNovoCPF;
	}

	public JTextField getFieldNovoRG() {
		return fieldNovoRG;
	}

	public JTextField getFieldNovoTelefone() {
		return fieldNovoTelefone;
	}

	public JButton getButtonCancelar() {
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		return buttonConfirmar;
	}
	
}
