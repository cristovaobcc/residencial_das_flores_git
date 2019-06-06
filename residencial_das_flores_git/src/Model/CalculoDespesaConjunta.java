/**
 * 
 */
package Model;

import java.util.ArrayList;

/**
 * @author cristovao.lima
 *
 */
public class CalculoDespesaConjunta implements CalcularDespesasBehavior {
	private ArrayList<Apartamento> apartamentos = new ArrayList<>();

	@Override
	public double calcularDespesa(Despesa despesa) {
		
		int qttvoApto = numeroTotalDeAptos();
		int qttvoQuartos = despesa.getAptoPagante().getQuantidadeQuartos();
		double valor = despesa.getValor() / qttvoApto *  qttvoQuartos;
		return valor;
	}
	
	private int numeroTotalDeAptos() {
		int qttivo = 0;
		for (Apartamento apto : apartamentos) {
			qttivo += apto.getQuantidadeQuartos();
		}
		return qttivo;
	}
	
	public static void gerarDespesasParaApartamentos() {
		
	}
	
}
