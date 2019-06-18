/**
 * 
 */
package Model;

/**
 * Classe que representa financas de despesas ou de receitas
 * @author cristovao.lima
 *
 */
public abstract class Financa {
	private CalcularFinancaBehavior calcularFinancaBehavior;
	private String descricao;
	private String dataLancamento;
	private String dataPagamento;
	private Double valor;
	private Apartamento aptoPagante;
	private int id; // TODO: ver como o n�mero de ID deve ser gerado.
	private boolean conjunta;
	private boolean recorrente;
	private boolean pgtoRealizado;


	public Financa(String descricao, String dataLancamento, String dataPagamento, Double valor, boolean conjunta,
			boolean recorrente) {
		super();
		this.descricao = descricao;
		this.dataLancamento = dataLancamento;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.conjunta = conjunta;
		this.recorrente = recorrente;
	}


	/**
	 * @return the calcularFinancaBehavior
	 */
	public CalcularFinancaBehavior getCalcularFinancaBehavior() {
		return calcularFinancaBehavior;
	}


	/**
	 * @param calcularFinancaBehavior the calcularFinancaBehavior to set
	 */
	public void setCalcularFinancaBehavior(CalcularFinancaBehavior calcularFinancaBehavior) {
		this.calcularFinancaBehavior = calcularFinancaBehavior;
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
	 * @return the dataPagamento
	 */
	public String getDataPagamento() {
		return dataPagamento;
	}


	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
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


	/**
	 * @return the conjunta
	 */
	public boolean isConjunta() {
		return conjunta;
	}


	/**
	 * @param conjunta the conjunta to set
	 */
	public void setConjunta(boolean conjunta) {
		this.conjunta = conjunta;
	}


	/**
	 * @return the recorrente
	 */
	public boolean isRecorrente() {
		return recorrente;
	}


	/**
	 * @param recorrente the recorrente to set
	 */
	public void setRecorrente(boolean recorrente) {
		this.recorrente = recorrente;
	}


	/**
	 * @return the pgtoRealizado
	 */
	public boolean isPgtoRealizado() {
		return pgtoRealizado;
	}


	/**
	 * @param pgtoRealizado the pgtoRealizado to set
	 */
	public void setPgtoRealizado(boolean pgtoRealizado) {
		this.pgtoRealizado = pgtoRealizado;
	}

}
