package model.entities;

public class Abrigo {

	private Integer id = null;
	private String nome;
	private String logradouro;
	private Integer numero;
	private String responsavel;
	private String telefone;
	private String email;
	private Integer capacidade = 200;
	private Integer ocupacao = 200;
	private Integer numOcupacao;
	
	public Abrigo() {}
	
	public Abrigo(Integer id, String nome, String responsavel, String logradouro, Integer numero, String telefone, String email, Integer numOcupacao) {
		
		this.id = null;
		this.nome = nome;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.numero = numero;
		this.email = email;
		this.numOcupacao = numOcupacao;
		//this.capacidade = numOcupacao / this.ocupacao * 100;

	}
	
	


	public Abrigo(Integer id2, String nome2, String responsavel2, String logradouro2, Integer numero2, String telefone2,
			String email2, int numOcupacao2) {
		// TODO Auto-generated constructor stub
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

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public double getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Integer ocupacao) {
		this.ocupacao = ocupacao;
	}	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumOcupacao() {
		return numOcupacao;
	}

	public void setNumOcupacao(Integer numOcupacao) {
		this.numOcupacao = numOcupacao;
	}

	
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Abrigo [nome= " + nome + ", responsavel= " + responsavel
				+ ", telefone= " + telefone + ", email= " + email + ", capacidade= " + capacidade + ", ocupacao= "
				+ ocupacao + "]";
	}
	
	
	

}
