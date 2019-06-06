/**
 * 
 */
package Model;

/**
 * @author cristovao.lima
 *
 */
public class Receita extends Financa {
	private String dataRecepcao;
	private boolean recolhida;
	
	/**
	 * @param descricao
	 * @param dataLancamento
	 * @param valor
	 * @param dataRecepcao
	 * @param recolhida
	 * @param aptoPagante 
	 */
	public Receita(String descricao, String dataLancamento, Double valor, String dataRecepcao, boolean recolhida, 
			Apartamento aptoPagante) {
		super(descricao, dataLancamento, valor, aptoPagante);
		this.dataRecepcao = dataRecepcao;
		this.recolhida = recolhida;
	}
	
	
}
