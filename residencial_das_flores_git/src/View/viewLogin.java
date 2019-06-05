package View;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class viewLogin extends JFrame{
	JPanel loginPanel,loginsenhaPanel;
	JButton entrarButton,cancelarButton,esqueceusenhaButton;
	JLabel labelLogin,labelSenha,imageLogin;
	JTextField fieldLogin;
	JPasswordField fieldSenha;
	ImageIcon loginImage;
	
	
	public viewLogin() {
		super("Residencial das Flores");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(214, 373);
		setLocationRelativeTo(null);
		
		loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPanel);	
		this.getContentPane().setBackground(Color.white);
		loginPanel.setLayout(null);
		
		loginImage = new ImageIcon(getClass().getResource("loginImage.png"));
			
		loginsenhaPanel = new JPanel();
		loginsenhaPanel.setBounds(23, 149, 159, 70);
		loginsenhaPanel.setBackground(Color.white);
		loginPanel.add(loginsenhaPanel);
		loginsenhaPanel.setLayout(null);
		
		labelLogin = new JLabel("Login :");
		labelLogin.setBounds(10, 14, 46, 14);
		loginsenhaPanel.add(labelLogin);
		
		labelSenha = new JLabel("Senha :");
		labelSenha.setBounds(8, 42, 46, 14);
		loginsenhaPanel.add(labelSenha);
		
		fieldLogin = new JTextField();
		fieldLogin.setBounds(53, 11, 99, 20);
		loginsenhaPanel.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldSenha = new JPasswordField();
		fieldSenha.setBounds(53, 39, 99, 20);
		loginsenhaPanel.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		entrarButton = new JButton("Entrar");
		entrarButton.setBounds(61, 227, 87, 23);
		entrarButton.setBackground(Color.white);
		loginPanel.add(entrarButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.setBounds(61, 256, 87, 23);
		cancelarButton.setBackground(Color.white);
		loginPanel.add(cancelarButton);
		
		esqueceusenhaButton = new JButton("Esqueceu a Senha?");
		esqueceusenhaButton.setBounds(23, 290, 159, 23);
		esqueceusenhaButton.setBackground(Color.white);
		loginPanel.add(esqueceusenhaButton);
		
		imageLogin = new JLabel("");
		imageLogin.setBounds(23, 11, 159, 139);
		imageLogin.setIcon(loginImage);
		loginPanel.add(imageLogin);
		
		setVisible(true);
		setResizable(false);
		
	}


	public JPanel getLoginPanel() {
		return loginPanel;
	}


	public JLabel getLabelLogin() {
		return labelLogin;
	}


	public JLabel getLabelSenha() {
		return labelSenha;
	}


	public JLabel getImageLogin() {
		return imageLogin;
	}


	public ImageIcon getLoginImage() {
		return loginImage;
	}


	public JButton getEntrarButton() {
		return entrarButton;
	}


	public JButton getCancelarButton() {
		return cancelarButton;
	}


	public JButton getEsqueceusenhaButton() {
		return esqueceusenhaButton;
	}


	public JTextField getFieldLogin() {
		return fieldLogin;
	}


	public JPasswordField getFieldSenha() {
		return fieldSenha;
	}


}