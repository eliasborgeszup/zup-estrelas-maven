package br.com.zup.estrelas.maven.pojo;

public class CarroPojo {
	private String nome;
	private String marca;
	private int anoFabricacao;
	
	public CarroPojo() {
		
	}

	public CarroPojo(String nome, String marca, int anoFabricacao) {
		this.nome = nome;
		this.marca = marca;
		this.anoFabricacao = anoFabricacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
}
