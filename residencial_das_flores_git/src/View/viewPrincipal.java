package View;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Controller.controllerLogin;
import Model.StatusApartamentos;


public class viewPrincipal extends JFrame implements Observer{
	
	JPanel panelPrincipal,panelEsquerda;
	JMenuBar menuBar;
	JMenu menuMoradores,menuApartamentos,menuFinancas,menuItens,menuSair;
	JMenuItem menuItemControleMoradores,menuItemControleApartamentos,menuItemControleFinancas,menuItemControleItens,menuItemSair;
	JLabel labelHora,labelData,labelMenuRapido,labelCadastro,labelGerenciamento,labelCreditos,labelQtdApt,labelQtdAptAlg,
			labelQtdAptDsp,labelNumeroApt,labelNumeroAptAlg,labelNumeroAptDsp,labelVersao,labelImagem;

	JButton buttonCadastroMorador,buttonCadastroApt,buttonCadastroDespesa,buttonCadastroItem,buttonStatusResidencia;
	Date dataSistema;
	Timer timer;
	SimpleDateFormat formatData;
	
	private ImageIcon imageTelaPrincipal;

	public viewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 427);
		setResizable(false);	
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		dataSistema = new Date();
		formatData = new SimpleDateFormat("dd/MM/yyyy");
		timer = new Timer(1000, new Hora());
		timer.start();
		
		menuMoradores = new JMenu("Moradores");
		menuBar.add(menuMoradores);
		menuItemControleMoradores = new JMenuItem("Controle Moradores");
		menuMoradores.add(menuItemControleMoradores);
		
		menuApartamentos = new JMenu("Apartamentos");
		menuBar.add(menuApartamentos);
		menuItemControleApartamentos = new JMenuItem("Controle Apartamentos");
		menuApartamentos.add(menuItemControleApartamentos);
		
		menuFinancas = new JMenu("Finan\u00E7as");
		menuBar.add(menuFinancas);	
		menuItemControleFinancas = new JMenuItem("Controle Finan\u00E7as");
		menuFinancas.add(menuItemControleFinancas);
		
		menuItens = new JMenu("Itens");
		menuBar.add(menuItens);	
		menuItemControleFinancas = new JMenuItem("Controle Itens");
		menuItens.add(menuItemControleFinancas);
		
		menuSair = new JMenu("Sair");
		menuBar.add(menuSair);
		menuItemSair = new JMenuItem("Sair e salvar");
		menuSair.add(menuItemSair);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelEsquerda = new JPanel();
		panelEsquerda.setBackground(Color.WHITE);
		panelEsquerda.setBounds(28, 0, 170, 378);
		panelPrincipal.add(panelEsquerda);
		panelEsquerda.setLayout(null);
		
		labelMenuRapido = new JLabel("Menu R\u00E1pido");
		labelMenuRapido.setVerticalAlignment(SwingConstants.TOP);
		labelMenuRapido.setBounds(50, 23, 107, 14);
		panelEsquerda.add(labelMenuRapido);
		
		labelCadastro = new JLabel("Cadastro");
		labelCadastro.setBounds(60, 60, 81, 22);
		panelEsquerda.add(labelCadastro);
		
		buttonCadastroMorador = new JButton("Morador");
		buttonCadastroMorador.setBounds(28, 87, 117, 36);
		buttonCadastroMorador.setBackground(Color.white);
		panelEsquerda.add(buttonCadastroMorador);
		
		buttonCadastroApt = new JButton("Apartamento");
		buttonCadastroApt.setBounds(28, 134, 117, 36);
		buttonCadastroApt.setBackground(Color.white);
		panelEsquerda.add(buttonCadastroApt);
		
		buttonCadastroItem = new JButton("Item");
		buttonCadastroItem.setBounds(28, 181, 117, 36);
		buttonCadastroItem.setBackground(Color.white);
		panelEsquerda.add(buttonCadastroItem);
		
		buttonCadastroDespesa = new JButton("Despesa");
		buttonCadastroDespesa.setBounds(28, 228, 117, 36);
		buttonCadastroDespesa.setBackground(Color.white);
		panelEsquerda.add(buttonCadastroDespesa);
		
		labelGerenciamento = new JLabel("Gerenciamento");
		labelGerenciamento.setBounds(42, 275, 97, 14);
		panelEsquerda.add(labelGerenciamento);
		
		buttonStatusResidencia = new JButton("Status Residencias");
		buttonStatusResidencia.setBounds(10, 295, 150, 36);
		buttonStatusResidencia.setBackground(Color.white);
		panelEsquerda.add(buttonStatusResidencia);
		
		labelData = new JLabel();
		labelData.setText(formatData.format(dataSistema));
		labelData.setBounds(10, 340, 90, 14);
		panelEsquerda.add(labelData);
		
		labelHora = new JLabel();
		labelHora.setBounds(113,340,90,14);
		panelEsquerda.add(labelHora);
		
		labelVersao = new JLabel("Vers\u00E3o 0.1");
		labelVersao.setBounds(50, 353, 90, 14);
		panelEsquerda.add(labelVersao);
		
		labelQtdApt = new JLabel("Total de Apartamentos :");
		labelQtdApt.setBounds(208, 84, 163, 22);
		panelPrincipal.add(labelQtdApt);
		
		labelQtdAptAlg = new JLabel("Total Apartamentos Alugados : ");
		labelQtdAptAlg.setBounds(208, 118, 188, 14);
		panelPrincipal.add(labelQtdAptAlg);
		
		labelQtdAptDsp = new JLabel("Total Apartamentos Dispon�veis : ");
		labelQtdAptDsp.setBounds(208, 151, 190, 14);
		panelPrincipal.add(labelQtdAptDsp);
		
		labelNumeroApt = new JLabel(StatusApartamentos.getTotal()+"");
		labelNumeroApt.setBounds(348, 89, 46, 14);
		panelPrincipal.add(labelNumeroApt);
		
		labelNumeroAptAlg = new JLabel(StatusApartamentos.getAlugados()+"");
		labelNumeroAptAlg.setBounds(384, 118, 46, 14);
		panelPrincipal.add(labelNumeroAptAlg);
		
		labelNumeroAptDsp = new JLabel(StatusApartamentos.getDisponiveis()+"");
		labelNumeroAptDsp.setBounds(397, 151, 46, 14);
		panelPrincipal.add(labelNumeroAptDsp);
				
		labelCreditos = new JLabel("Cr\u00E9ditos> Jonas,Fl\u00E1vio,Cristov\u00E3o, J\u00FAlio.");
		labelCreditos.setBounds(208, 353, 246, 14);
		panelPrincipal.add(labelCreditos);
			
		imageTelaPrincipal = new ImageIcon(getClass().getResource("loginImage.png"));
		labelImagem = new JLabel(imageTelaPrincipal);
		labelImagem.setBounds(175, 75, 544, 378);
		panelPrincipal.add(labelImagem);
		
		setLocationRelativeTo(null);
	
	}

	public JLabel getLabelHora() {
		return labelHora;
	}
	
	public JMenu getMenuMoradores() {
		return menuMoradores;
	}

	public JMenu getMenuApartamentos() {
		return menuApartamentos;
	}

	public JMenu getMenuFinancas() {
		return menuFinancas;
	}

	public JMenu getMenuItens() {
		return menuItens;
	}

	public JMenu getMenuSair() {
		return menuSair;
	}

	public JMenuItem getMenuItemControleMoradores() {
		return menuItemControleMoradores;
	}

	public JMenuItem getMenuItemControleApartamentos() {
		return menuItemControleApartamentos;
	}

	public JMenuItem getMenuItemControleFinancas() {
		return menuItemControleFinancas;
	}

	public JMenuItem getMenuItemControleItens() {
		return menuItemControleItens;
	}

	public JMenuItem getMenuItemSair() {
		return menuItemSair;
	}

	public JLabel getLabelNumeroApt() {
		return labelNumeroApt;
	}

	public JLabel getLabelNumeroAptAlg() {
		return labelNumeroAptAlg;
	}

	public JLabel getLabelNumeroAptDsp() {
		return labelNumeroAptDsp;
	}

	public JButton getButtonCadastroMorador() {
		return buttonCadastroMorador;
	}

	public JButton getButtonCadastroApt() {
		return buttonCadastroApt;
	}

	public JButton getButtonCadastroDespesa() {
		return buttonCadastroDespesa;
	}

	public JButton getButtonCadastroItem() {
		return buttonCadastroItem;
	}

	public JButton getButtonStatusResidencia() {
		return buttonStatusResidencia;
	}
	
	public class Hora implements ActionListener {
		Calendar agora;
		
		public void actionPerformed(ActionEvent e) {
			agora = Calendar.getInstance();
			labelHora.setText(String.format("%1$tH:%1$tM:%1$tS",agora));
			
		}
	
	}

	@Override
	public void update(Observable o, Object arg) {
		StatusApartamentos.calcularAlugados();
		StatusApartamentos.calcularDisponiveis();
		StatusApartamentos.calcularTotal();
		labelNumeroApt.setText(StatusApartamentos.getTotal()+"");
	
		labelNumeroAptDsp.setText(StatusApartamentos.getDisponiveis()+"");
	
		labelNumeroAptAlg.setText(StatusApartamentos.getAlugados()+"");
		
	}
}

