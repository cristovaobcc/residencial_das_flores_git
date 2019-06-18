/**
 * 
 */
package Model;

/**
 * @author cristovao.lima
 *
 */
public class CalculoFinancaIndividual implements CalcularFinancaBehavior{
	
	public CalculoFinancaIndividual(Apartamento apto, ContaAReceber contaAReceber) {
		apto.getFinancas().add(contaAReceber);
	}

	@Override
	public double calcularDespesa(Financa despesa) {
		return despesa.getValor();
	}
	
	
}
