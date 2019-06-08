/**
 * 
 */
package Model;

/**
 * Representa a despesa gerada por um condomínio.
 * @author cristovao.lima
 *
 */
public class Despesa extends Financa {
	private boolean conjunta;
	private boolean individual;
	private boolean recorrente;
	private boolean pgtoEfetivado;
	// TODO: quando selecionar o tipo de despesa, criar um objeto no controller para passar para o construtor daqui.
	private CalcularDespesasBehavior calcularDespesas; // N�o criar com classe interna an�nima.
	private String dataPagamento;

	/**
	 * 
	 * @param descricao
	 * @param dataLancamento
	 * @param valor
	 * @param conjunta
	 * @param recorrente
	 * @param pgtoEfetivado
	 * @param calcularDespesas 
	 * @param dataPagamento
	 * @param aptoPagante 
	 */
	public Despesa(String descricao, String dataLancamento, Double valor, boolean conjunta,
			boolean recorrente, boolean pgtoEfetivado, CalcularDespesasBehavior calcularDespesas,
			String dataPagamento, Apartamento aptoPagante) {
		super(descricao, dataLancamento, valor, aptoPagante);
		this.conjunta = (conjunta==true?true:false) ;
		this.individual = (conjunta==false?true:false);
		this.recorrente = recorrente;
		this.pgtoEfetivado = pgtoEfetivado;
		this.calcularDespesas = calcularDespesas;
		this.dataPagamento = dataPagamento;
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
	 * @return the individual
	 */
	public boolean isIndividual() {
		return individual;
	}

	/**
	 * @param individual the individual to set
	 */
	public void setIndividual(boolean individual) {
		this.individual = individual;
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
	 * @return the pgtoEfetivado
	 */
	public boolean isPgtoEfetivado() {
		return pgtoEfetivado;
	}

	/**
	 * @param pgtoEfetivado the pgtoEfetivado to set
	 */
	public void setPgtoEfetivado(boolean pgtoEfetivado) {
		this.pgtoEfetivado = pgtoEfetivado;
	}

	/**
	 * @return the calcularDespesas
	 */
	public CalcularDespesasBehavior getCalcularDespesas() {
		return calcularDespesas;
	}

	/**
	 * @param calcularDespesas the calcularDespesas to set
	 */
	public void setCalcularDespesas(CalcularDespesasBehavior calcularDespesas) {
		this.calcularDespesas = calcularDespesas;
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
	
	
	
	
	
}
