package Model;

import java.util.ArrayList;

import Controller.controllerMorador;
import View.TelaMensagem;
import Model.Item;

public class BaseDados {
	public static ArrayList<Morador> moradores = new ArrayList<Morador>();
	public static ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
	public static ArrayList<Item> itens = new ArrayList<Item>();
	
	//Item
	public static boolean adicionarItem(Item item) {
		if(item != null) {
			return itens.add(item);
		}
		return false;
	}
	
	public static boolean existeItem(String nome) {
		for(Item obj : itens) {
			if(obj.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public static Item buscarItem(String nome) {
		for(Item obj : itens) {
			if(obj.getNome().equals(nome)) {
				return obj;
			}
		}
		return null;
	}
	
	public static void alterarItem(String nome, String novoNome, String dia, String mes, String parcelamento, String valor) {
		Item objItem = buscarItem(nome);
		if(objItem != null) {
			objItem.setNome(novoNome);
			objItem.setDia(dia);
			objItem.setMes(mes);
			objItem.setParcelamento(parcelamento);
			objItem.setValor(valor);
		}
	}
	
	public static boolean remover(String nome) {
		Item item = buscarItem(nome);
		if(item != null) {
			return itens.remove(item);
		}
		return false;
	}
	
	//Moradores
	public static boolean adicionarMorador(Morador morador) {
		if(morador != null) {
			moradores.add(morador);
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean existeMorador(String cpf) {
		for(Morador morador: moradores) {
			if(morador.getCpf().equalsIgnoreCase(cpf)) {
				return true;
			}
		}
		return false;
	}
	
	public static Morador buscarMorador(String cpf) {
		for(Morador morador: moradores) {
			if(morador.getCpf().equalsIgnoreCase(cpf)) {
				return morador;
			}
		}	
		return null;		
	}
	
	public static void removerMorador(String cpf) {
		Morador morador = buscarMorador(cpf);
		moradores.remove(morador);
		
	}
	
	public static void alterarMorador(String cpf, String novoNome, String novoCPF, String novoRG, String novoTelefone) {
		Morador morador = buscarMorador(cpf);
		morador.setNome(novoNome);
		morador.setCpf(novoCPF);
		morador.setRg(novoRG);
		morador.setTelefone(novoTelefone);
	}
	
	//Apartamentos
	public static ArrayList<Apartamento> getApartamentos() {
		return apartamentos;
	}
	
	public static String exibirApartamentos() {
		String formato ="";
		for(Apartamento p:apartamentos) {
			formato+="Nº de portas: "+p.getNumeroPorta()+", quantidade de quartos: "+p.getQuantidadeQuartos()+", tipo de ocupação: "+p.getTipoOcupacao()+"\n";
		}
		return formato;
	}
	
	public static String SubString(String numero) {
		String formato="";
		for(Apartamento a:BaseDados.getApartamentos()) {
			if(a.getNumeroPorta().contains(numero)) {
				formato+="Nº: "+a.getNumeroPorta()+", quantidade de quartos: "+a.getQuantidadeQuartos()+", tipo de ocupação: "+a.getTipoOcupacao()+"\n";
			}
		}
		if(formato.equals("")) {
			return "Apartamento não encontrado!";
		}else
			return formato;
	}
	public static boolean ExisteApartamento(String numero) {
		for(Apartamento a:BaseDados.getApartamentos()) {
			if(a.getNumeroPorta().equals(numero)) {
				return false;
			}
		}
		return true;
	}
	public static Apartamento Buscar(String numero) {
		for(Apartamento a:apartamentos) {
			if(a.getNumeroPorta().equals(numero)) {
				return a;
			}
		}
		return null;
	}
	
	public static boolean ExcluirApartamento(String numero) {
		if(!ExisteApartamento(numero)) {
			apartamentos.remove(Buscar(numero));
			return true;
		}else
			return false;
	}
	public static boolean EditarApartamento(Apartamento removivel,Apartamento novo) {
		
		if(BaseDados.ExcluirApartamento(removivel.getNumeroPorta())) {
			if(BaseDados.ExisteApartamento(removivel.getNumeroPorta())) {
				BaseDados.getApartamentos().add(novo);
				TelaMensagem.Exibir("Alteração feito com sucesso!");
				return true;
			}else {
				TelaMensagem.Exibir("Erro: esse apartamento já esta cadastrado!");
				return true;
			}
		}else {
			TelaMensagem.Exibir("Erro: esse apartamento não existe!");
			return false;
		}
		
		
	}
	
	public static ArrayList<Apartamento> ApartamentosDisponiveis() {
		ArrayList<Apartamento> disponiveis = new ArrayList<>();
		for(Apartamento a:getApartamentos()) {
			if(a.getTipoOcupacao().equals("Vazio")) {
				disponiveis.add(a);
			}
		}
		return disponiveis;
	}
	
}
