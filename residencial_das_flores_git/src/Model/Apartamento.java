package Model;

public class Apartamento {
	private String numeroPorta;
	private int quantidadeQuartos;
	private String tipoOcupacao;
	public Apartamento(String numeroPorta, int quantidadeQuartos, String tipoOcupacao) {
		super();
		this.numeroPorta = numeroPorta;
		this.quantidadeQuartos = quantidadeQuartos;
		this.tipoOcupacao = tipoOcupacao;
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
	
}
