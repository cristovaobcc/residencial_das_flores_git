package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class viewAlterarSenha extends JFrame{
	private JPanel alterarPanel;
	private JTextField fieldLogin,fieldCpf,fieldSenha;
	private JLabel labelRecuperacaoSenha,labelLogin,labelCpf,labelNovaSenha,labelObrigatorio;
	private JButton buttonConfirmar,buttonSair;
	
	public JTextField getFieldLogin() {
		return fieldLogin;
	}

	public JTextField getFieldCpf() {
		return fieldCpf;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}

	public JButton getButtonConfirmar() {
		return buttonConfirmar;
	}

	public JButton getButtonSair() {
		return buttonSair;
	}

	public viewAlterarSenha() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(214, 228);
		setLocationRelativeTo(null);
		setResizable(false);
		
		alterarPanel = new JPanel();
		alterarPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(alterarPanel);
		alterarPanel.setLayout(null);
		
		labelRecuperacaoSenha = new JLabel("Recupera\u00E7\u00E3o de Senha");
		labelRecuperacaoSenha.setBounds(46, 11, 111, 23);
		alterarPanel.add(labelRecuperacaoSenha);
		labelRecuperacaoSenha.setFont(new Font("Verdana",Font.CENTER_BASELINE,9));
		
		labelLogin = new JLabel("Login*  :");
		labelLogin.setBounds(10, 51, 46, 14);
		alterarPanel.add(labelLogin);
		labelLogin.setFont(new Font(null,Font.CENTER_BASELINE,9));
		
		labelCpf = new JLabel("Cpf*  : ");
		labelCpf.setBounds(10, 76, 46, 14);
		alterarPanel.add(labelCpf);
		labelCpf.setFont(new Font(null,Font.CENTER_BASELINE,9));
		
		labelNovaSenha = new JLabel("Nova Senha :");
		labelNovaSenha.setBounds(10, 101, 69, 19);
		alterarPanel.add(labelNovaSenha);
		labelNovaSenha.setFont(new Font(null,Font.CENTER_BASELINE,9));
		
		fieldLogin = new JTextField();
		fieldLogin.setBounds(83, 48, 105, 20);
		alterarPanel.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldCpf = new JTextField();
		fieldCpf.setBounds(83, 73, 105, 20);
		alterarPanel.add(fieldCpf);
		fieldCpf.setColumns(10);
		
		fieldSenha = new JTextField();
		fieldSenha.setBounds(83, 100, 105, 20);
		alterarPanel.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		labelObrigatorio = new JLabel("Login e Cpf s\u00E3o obrigat\u00F3rios!");
		labelObrigatorio.setBounds(30, 131, 147, 14);
		alterarPanel.add(labelObrigatorio);
		labelObrigatorio.setFont(new Font(null,Font.CENTER_BASELINE + Font.ITALIC,10));
		
		buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.setBounds(109, 156, 79, 23);
		alterarPanel.add(buttonConfirmar);
		buttonConfirmar.setFont(new Font(null,Font.CENTER_BASELINE,8));
		buttonConfirmar.setBackground(Color.white);
		
		buttonSair = new JButton("Sair");
		buttonSair.setBounds(10, 156, 79, 23);
		alterarPanel.add(buttonSair);
		buttonSair.setFont(new Font(null,Font.CENTER_BASELINE,8));
		buttonSair.setBackground(Color.white);
}
}
