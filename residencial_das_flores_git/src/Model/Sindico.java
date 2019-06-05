package Model;

public class Sindico {
	public static String login = "admin";
	public static String senha = "123";
	public static String cpf = "12345678900";
	
	
	public static void sindicoAdicionarMorador(String nome, String rg, String cpf, String telefone,String data,String numeroapartamento){
		BaseDados.adicionarMorador(new Morador(nome,rg,cpf,telefone,data,numeroapartamento));	
	}
	
	public static void setSenha(String senha) {
		Sindico.senha = senha;
	}

	public void sindicoBuscarMorador(String nome){
		BaseDados.buscarMorador(nome);
	}
	
	public void sindicoRemoverMorador() {
		
	}
	public void sindicoAlterarMorador() {
		
	}
	
}
