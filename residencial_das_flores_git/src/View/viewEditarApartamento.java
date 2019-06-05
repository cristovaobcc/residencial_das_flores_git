package View;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.*;
public class viewEditarApartamento extends JFrame {
	private JLabel napto;
	private JLabel quantidade;
	private JLabel tipoOcupacao;
	private JTextField naptoField;
	private JTextField quantidadeField;
	private JComboBox<String> tipo;
	private JButton editar;
	private JButton limpar;
	private JButton cancelar;
	
	
	
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



	public JButton getEditar() {
		return editar;
	}



	public void setEditar(JButton cadastrar) {
		this.editar = cadastrar;
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



	public viewEditarApartamento(){
		
		setTitle("Cadastro");
		setSize(200, 232);
		setUndecorated(false);
		
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		setResizable(false);
		napto = new JLabel("Nº da porta: ");
		naptoField = new JTextField(15);
		
		
		quantidade = new JLabel("Quantidade de quartos: ");
		quantidadeField = new JTextField(15);
		
		tipoOcupacao = new JLabel("Tipo de ocupação: ");
		tipo = new JComboBox<>();
		tipo.addItem("Proprietário");
		tipo.addItem("Inquilino");
		tipo.addItem("Vazio");
		
		
		editar = new JButton("Editar");
		limpar = new JButton("Limpar");
		cancelar = new JButton("Cancelar");
		
		this.add(napto);
		this.add(naptoField);
		this.add(quantidade);
		this.add(quantidadeField);
		this.add(tipoOcupacao);
		this.add(tipo);
		this.add(editar);
		this.add(limpar);
		this.add(cancelar);
		
		editar.setBackground(Color.white);
		limpar.setBackground(Color.white);
		cancelar.setBackground(Color.white);
		
		//setVisible(true);
		
	}
}
