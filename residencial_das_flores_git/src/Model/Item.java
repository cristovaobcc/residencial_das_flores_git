package Model;

public class Item {

	public String nome, dia, mes, parcelamento, valor;

	public Item(String nome, String dia, String mes, String parcelamento, String valor) {
		super();
		this.nome = nome;
		this.dia = dia;
		this.mes = mes;
		this.parcelamento = parcelamento;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(String parcelamento) {
		this.parcelamento = parcelamento;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
