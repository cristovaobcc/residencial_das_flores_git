/**
 * 
 */
package Model;

/**
 * Classe que representa financas de despesas ou de receitas
 * @author cristovao.lima
 *
 */
public class Financa {
	private int id; // TODO: ver como o n�mero de ID deve ser gerado.
	private String descricao;
	private String dataLancamento;
	private Double valor;
	private Apartamento aptoPagante;
	
	/**
	 * @param descricao
	 * @param dataLancamento
	 * @param valor
	 * @param aptoPagante
	 */
	public Financa(String descricao, String dataLancamento, Double valor, Apartamento aptoPagante) {
		super();
		this.descricao = descricao;
		this.dataLancamento = dataLancamento;
		this.valor = valor;
		this.aptoPagante = aptoPagante;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the dataLancamento
	 */
	public String getDataLancamento() {
		return dataLancamento;
	}

	/**
	 * @param dataLancamento the dataLancamento to set
	 */
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the aptoPagante
	 */
	public Apartamento getAptoPagante() {
		return aptoPagante;
	}

	/**
	 * @param aptoPagante the aptoPagante to set
	 */
	public void setAptoPagante(Apartamento aptoPagante) {
		this.aptoPagante = aptoPagante;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	

}
