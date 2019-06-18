package App;


import Controller.ControllerApartamento;
import Controller.ControllerFinancas;
import Controller.controllerAlterarItens;
import Controller.controllerAlterarMorador;
import Controller.controllerAlterarSenha;
import Controller.controllerItem;
import Controller.controllerLogin;
import Controller.controllerMorador;
import Controller.controllerPrincipal;
import Controller.controllerRemoverItens;
import Controller.controllerRemoverMorador;
import Model.Apartamento;
import Model.BaseDados;
import View.viewApartamento;
import View.viewEditarApartamento;
import View.viewLogin;


public class App {
	public static void main(String[] args) {
		BaseDados.getApartamentos().add(new Apartamento("1", 2, "Vazio"));
		BaseDados.getApartamentos().add(new Apartamento("2", 2, "Proprietário"));
		BaseDados.getApartamentos().add(new Apartamento("3", 2, "Vazio"));
		
		controllerLogin controller = new controllerLogin(new viewLogin());
		new controllerAlterarSenha(controller);
		new controllerPrincipal(controller);
		controllerMorador cm = new controllerMorador(controller);
		cm.addObserver(controller.viewprincipal);
		new controllerAlterarMorador(controller);
		controllerRemoverMorador rm = new controllerRemoverMorador(controller);
		rm.addObserver(controller.viewprincipal);
		ControllerApartamento controllerApartamento = new ControllerApartamento(new viewApartamento(), new viewEditarApartamento(),controller);
		controllerApartamento.addObserver(controller.viewprincipal);
		
		//mudanï¿½as
		controllerItem ci = new controllerItem(controller);
		ci.addObserver(controller.viewprincipal);
		
		new controllerAlterarItens(controller);
		controllerRemoverItens cri = new controllerRemoverItens(controller);
		cri.addObserver(controller.viewprincipal);
		
		ControllerFinancas cf = new ControllerFinancas(controller);
		cf.addObserver(controller.viewprincipal);
		
	}

}
