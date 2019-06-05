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

public class viewRemoverMorador extends JFrame{
	JPanel contentPane,panel,panel_1;
	JFormattedTextField fieldCpf;
	JLabel labelOver,labelInfo,labelTitulo,labelCpf;
	JButton buttonConfirmar;

	public viewRemoverMorador() {
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 184, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(0, 0, 293, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Remover Morador");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		labelTitulo.setBounds(28, 11, 127, 14);
		panel.add(labelTitulo);
		
		labelCpf = new JLabel("CPF : ");
		labelCpf.setBounds(10, 102, 46, 14);
		contentPane.add(labelCpf);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 32, 178, 3);
		contentPane.add(panel_1);
		
		buttonConfirmar = new JButton("Remover");
		buttonConfirmar.setBounds(44, 133, 89, 23);
		contentPane.add(buttonConfirmar);
		
		fieldCpf = new JFormattedTextField();
		fieldCpf.setBounds(44, 99, 124, 20);
		contentPane.add(fieldCpf);
		fieldCpf.setColumns(10);
		
		labelOver = new JLabel("@Override");
		labelOver.setForeground(new Color(255, 0, 0));
		labelOver.setBounds(57, 43, 70, 14);
		contentPane.add(labelOver);
		
		labelInfo = new JLabel("A\u00E7\u00E3o n\u00E3o pode ser desfeita!");
		labelInfo.setForeground(new Color(255, 0, 0));
		labelInfo.setBounds(10, 68, 158, 14);
		contentPane.add(labelInfo);
		formatarCampos();
		
		setLocationRelativeTo(null);
	}
	
	public void formatarCampos() {
		try {
			MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
			maskCpf.install(fieldCpf);
		} catch (ParseException e) {
			TelaMensagem.Exibir("Formatação de Cpf Inválida!");
		}
	}

	public JTextField getFieldCpf() {
		return fieldCpf;
	}

	public JButton getButtonConfirmar() {
		return buttonConfirmar;
	}
}
