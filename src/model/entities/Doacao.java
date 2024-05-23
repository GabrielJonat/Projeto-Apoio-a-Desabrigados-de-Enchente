package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Doacao {
	
	private Integer id;
	
	private Integer idCentro;
	
	private List<Item> itens = new ArrayList<>();

	public Doacao() {}
	
	public Doacao(Integer id, Integer idCentro, List<Item> itens) {
		super();
		this.id = id;
		this.idCentro = idCentro;
		this.itens = itens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(Integer idCentro) {
		this.idCentro = idCentro;
	}

	public List<Item> getItens() {
		return itens;
	}

	

}
