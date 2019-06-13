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
	
	public static void calcularTotal() {
		total = BaseDados.getApartamentos().size();
	}
	public static void calcularAlugados() {
		int total=0;
		for(Apartamento a:BaseDados.getApartamentos()) {
			if(a.getTipoOcupacao().equals("Propriet�rio") || a.getTipoOcupacao().equals("Inquilino")) {
				total++;
			}
		}
		alugados=total;
	}
	
	public static void calcularDisponiveis() {
		int total=0;
		for(Apartamento a:BaseDados.getApartamentos()) {
			if(a.getTipoOcupacao().equals("Vazio")) {
				total++;
			}
		}
		disponiveis=total;
	}
	public static void atualizarDisponibilidade(controllerLogin controllerlogin) {
		
			controllerlogin.viewmorador.getCombobox().removeAllItems();
			
		for(Apartamento a:BaseDados.ApartamentosDisponiveis()) {
			controllerlogin.viewmorador.getCombobox().addItem(a.getNumeroPorta());
		}
	}
	
}
