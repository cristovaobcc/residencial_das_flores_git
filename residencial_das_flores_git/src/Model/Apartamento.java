package Model;

import java.util.ArrayList;

public class Apartamento {
	private String numeroPorta;
	private int quantidadeQuartos;
	private String tipoOcupacao;
	private ArrayList<Financa> financas;
	public Apartamento(String numeroPorta, int quantidadeQuartos, String tipoOcupacao) {
		super();
		this.numeroPorta = numeroPorta;
		this.quantidadeQuartos = quantidadeQuartos;
		this.tipoOcupacao = tipoOcupacao;
		this.financas = new ArrayList<Financa>();
	}
	public String getNumeroPorta() {
		return numeroPorta;
	}
	public void setNumeroPorta(String numeroPortas) {
		this.numeroPorta = numeroPortas;
	}
	public int getQuantidadeQuartos() {
		return quantidadeQuartos;
	}
	public void setQuantidadeQuartos(int quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}
	public String getTipoOcupacao() {
		return tipoOcupacao;
	}
	public void setTipoOcupacao(String tipoOcupacao) {
		this.tipoOcupacao = tipoOcupacao;
	}
	/**
	 * @return the financas
	 */
	public ArrayList<Financa> getFinancas() {
		return financas;
	}
	/**
	 * @param financas the financas to set
	 */
	public void setFinancas(ArrayList<Financa> financas) {
		this.financas = financas;
	}
	
}
