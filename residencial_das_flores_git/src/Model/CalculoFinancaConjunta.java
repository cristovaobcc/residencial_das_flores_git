/**
 * 
 */
package Model;

import java.util.ArrayList;

/**
 * @author cristovao.lima
 *
 */
public class CalculoFinancaConjunta implements CalcularFinancaBehavior {
	private ArrayList<Apartamento> apartamentos;
	private Financa financa;
	
	
	public CalculoFinancaConjunta(ArrayList<Apartamento> apartamentos, Financa financa) {
		super();
		this.apartamentos = apartamentos;
		this.financa = financa;
	}

	@Override
	public double calcularDespesa(Financa financa) {
		
		double valor = financa.getValor() / (apartamentos.size()); // valor por quarto;
		return valor;
	}
		
	
	public void gerarFinancasParaApartamentos() {
		double valorIndividual = calcularDespesa(this.financa);
		Financa financaIndividual;
		for (Apartamento apto : apartamentos) {
			financaIndividual = new ContaAReceber(financa.getDescricao(), financa.getDataLancamento(), 
					financa.getDataPagamento(),	
					valorIndividual * apto.getQuantidadeQuartos() , false, 
					financa.isRecorrente(), apto);
			apto.getFinancas().add(financaIndividual);
			
		}
	}
	
}
