package model.entities;

import java.util.Objects;

public class Abrigo {
	
	private int id;
	private String nome;
	private String endereco;
	private String responsavel;
	private String telefone;
	private String email;
	private int capacidade;
	private double ocupacao;
	
	public Abrigo() {}
	
	public Abrigo(String nome, String endereco, String responsavel, String telefone, String email, int capacidade,
			double ocupacao) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.email = email;
		this.capacidade = capacidade;
		this.ocupacao = ocupacao;
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public double getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(double ocupacao) {
		this.ocupacao = ocupacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abrigo other = (Abrigo) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Abrigo [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", responsavel=" + responsavel
				+ ", telefone=" + telefone + ", email=" + email + ", capacidade=" + capacidade + ", ocupacao="
				+ ocupacao + "]";
	}
	
	
	

}
