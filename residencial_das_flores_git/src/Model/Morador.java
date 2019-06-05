package Model;

public class Morador {
	public String nome,rg,cpf,telefone,dataentrada,numeroapartamento;
	
	public Morador(String nome, String rg, String cpf, String telefone,String dataentrada,String numeroapartamento) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataentrada = dataentrada;
		this.numeroapartamento = numeroapartamento;
	}
	
	public String getDataentrada() {
		return dataentrada;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNumeroapartamento() {
		return numeroapartamento;
	}
	
}
