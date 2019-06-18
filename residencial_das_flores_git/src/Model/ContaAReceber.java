/**
 * 
 */
package Model;

/**
 * Representa uma conta gerada por um condomínio.
 * @author cristovao.lima
 *
 */
public class ContaAReceber extends Financa {
	

	/**
	 * 
	 * @param descricao
	 * @param dataLancamento
	 * @param dataPagamento
	 * @param valor
	 * @param conjunta
	 * @param recorrente
	 * @param apto
	 */
	public ContaAReceber(String descricao, String dataLancamento, String dataPagamento, Double valor, boolean conjunta,
			boolean recorrente, Apartamento apto) {
		super(descricao, dataLancamento, dataPagamento, valor, conjunta, recorrente);
		
		super.setCalcularFinancaBehavior(criarCalculoDeConta(conjunta));
		
	}

	private CalcularFinancaBehavior criarCalculoDeConta(boolean conjunta) {
		CalcularFinancaBehavior c;
		if (conjunta) {
			c = new CalculoFinancaConjunta(BaseDados.apartamentos, this);
			return c;
		}
		c = new CalculoFinancaIndividual(super.getAptoPagante(), this);
		return c;
	}	
	
}
