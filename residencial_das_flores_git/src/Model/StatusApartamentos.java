package Model;

import java.awt.Dimension;

import Controller.controllerLogin;

public class StatusApartamentos {
	private static int disponiveis=0;
	private static int alugados=0;
	private static int total= BaseDados.getApartamentos().size();
	public static int getDisponiveis() {
		return disponiveis;
	}
	
	public static int getAlugados() {
		return alugados;
	}
	
	public static int getTotal() {
		return total;
	}
	
	public static void CalcularTotal() {
		total = BaseDados.getApartamentos().size();
	}
	public static void CalcularAlugados() {
		int total=0;
		for(Apartamento a:BaseDados.getApartamentos()) {
			if(a.getTipoOcupacao().equals("Proprietário") || a.getTipoOcupacao().equals("Inquilino")) {
				total++;
			}
		}
		alugados=total;
	}
	
	public static void CalcularDisponiveis() {
		int total=0;
		for(Apartamento a:BaseDados.getApartamentos()) {
			if(a.getTipoOcupacao().equals("Vazio")) {
				total++;
			}
		}
		disponiveis=total;
	}
	public static void AtualizarDisponibilidade(controllerLogin controllerlogin) {
		
			controllerlogin.viewmorador.getCombobox().removeAllItems();
			
		for(Apartamento a:BaseDados.ApartamentosDisponiveis()) {
			controllerlogin.viewmorador.getCombobox().addItem(a.getNumeroPorta());
		}
	}
	
}
