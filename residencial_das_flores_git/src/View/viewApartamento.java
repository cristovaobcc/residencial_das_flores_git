package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

import Controller.ControllerApartamento;
public class viewApartamento extends JFrame {
	private JPanel cadastro;
	private JPanel consulta;
	private JPanel subPanel;
	private JPanel titulo;
	
	
	private JLabel napto;
	private JLabel quantidade;
	private JLabel tipoOcupacao;
	private JTextField naptoField;
	private JTextField quantidadeField;
	private JComboBox<String> tipo;
	private JButton cadastrar;
	private JButton limpar;
	private JButton cancelar;
	
	private JTextField buscaField;
	private JButton busca;
	private JTextArea buscaArea;
	
	private JPopupMenu menuPop;
	private JMenuItem  buscar;
	private JMenuItem  excluir;
	private JMenuItem  editar;
	private JMenuItem  sair;
	
	private JLabel lblTitulo;
	
	public JLabel getNapto() {
		return napto;
	}



	public void setNapto(JLabel napto) {
		this.napto = napto;
	}



	public JLabel getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(JLabel quantidade) {
		this.quantidade = quantidade;
	}



	public JLabel getTipoOcupacao() {
		return tipoOcupacao;
	}



	public void setTipoOcupacao(JLabel tipoOcupacao) {
		this.tipoOcupacao = tipoOcupacao;
	}



	public JTextField getNaptoField() {
		return naptoField;
	}



	public void setNaptoField(JTextField naptoField) {
		this.naptoField = naptoField;
	}



	public JTextField getQuantidadeField() {
		return quantidadeField;
	}



	public void setQuantidadeField(JTextField quantidadeField) {
		this.quantidadeField = quantidadeField;
	}



	public JComboBox<String> getTipo() {
		return tipo;
	}



	public void setTipo(JComboBox<String> tipo) {
		this.tipo = tipo;
	}



	public JButton getCadastrar() {
		return cadastrar;
	}



	public void setCadastrar(JButton cadastrar) {
		this.cadastrar = cadastrar;
	}



	public JButton getLimpar() {
		return limpar;
	}



	public void setLimpar(JButton limpar) {
		this.limpar = limpar;
	}



	public JButton getCancelar() {
		return cancelar;
	}



	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}
	


	public JTextField getBuscaField() {
		return buscaField;
	}



	public JButton getBusca() {
		return busca;
	}



	public JTextArea getBuscaArea() {
		return buscaArea;
	}



	public JPopupMenu getMenuPop() {
		return menuPop;
	}



	public JMenuItem getBuscar() {
		return buscar;
	}



	public JMenuItem getExcluir() {
		return excluir;
	}



	public JMenuItem getEditar() {
		return editar;
	}



	public JMenuItem getSair() {
		return sair;
	}

	
	
	public viewApartamento(){
		
		setTitle("Cadastro");
		setSize(495, 315);
		setUndecorated(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		//setLayout(new GridLayout(2, 0));
		setLayout(new BorderLayout());
		//setResizable(false);
		cadastro = new JPanel(new FlowLayout());
		consulta = new JPanel(new FlowLayout());
		titulo = new JPanel(new FlowLayout());
		subPanel = new JPanel(new GridLayout(1, 2));
		titulo.setBackground(new Color(152, 251, 152));
		titulo.setSize(50,100);
		titulo.setBorder(javax.swing.BorderFactory.createBevelBorder(1));
		
		lblTitulo = new JLabel("Apartamentos");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.add(lblTitulo);
				
		//Parte do cadastro
		napto = new JLabel("Nº da porta: ");
		naptoField = new JTextField(15);
			
		quantidade = new JLabel("Quantidade de quartos: ");
		quantidadeField = new JTextField(15);
		
		tipoOcupacao = new JLabel("Tipo de ocupação: ");
		tipo = new JComboBox<>();
		tipo.addItem("Proprietário");
		tipo.addItem("Inquilino");
		tipo.addItem("Vazio");
		
		
		cadastrar = new JButton("Cadastrar");
		limpar = new JButton("Limpar");
		cancelar = new JButton("Cancelar");
		
		
		cadastro.add(napto);
		cadastro.add(naptoField);
		cadastro.add(quantidade);
		cadastro.add(quantidadeField);
		cadastro.add(tipoOcupacao);
		cadastro.add(tipo);
		cadastro.add(cadastrar);
		cadastro.add(limpar);
		cadastro.add(cancelar);
		
		//Parte da consulta
		
		buscaField = new JTextField(15);
		busca = new JButton("Buscar");
		buscaArea = new JTextArea("Dados:", 10, 20);
		JScrollPane scroll = new JScrollPane(buscaArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		buscaArea.setEditable(false);
		
	
		menuPop = new JPopupMenu();
		buscar = new JMenuItem("Buscar");
		excluir = new JMenuItem("Excluir");
		editar = new JMenuItem("Editar");
		sair = new JMenuItem("Sair");
		
		menuPop.add(buscar);
		menuPop.add(excluir);
		menuPop.add(editar);
		menuPop.add(sair);
		
		consulta.add(buscaField);
		consulta.add(busca);
		consulta.add(scroll,BorderLayout.CENTER);
		
		subPanel.add(cadastro,0,0);
		subPanel.add(consulta,0,1);
		//add(subPanel,0,0);
		//add(titulo,1,0);
		//add(consulta,0,1);
		add(titulo,BorderLayout.NORTH);
		add(subPanel,BorderLayout.CENTER);
		
		cadastrar.setBackground(Color.white);
		limpar.setBackground(Color.white);
		cancelar.setBackground(Color.white);
		busca.setBackground(Color.white);
			
	}
	
}
