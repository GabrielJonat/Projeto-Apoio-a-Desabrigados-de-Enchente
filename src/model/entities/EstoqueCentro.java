package model.entities;


public class EstoqueCentro {
	
	private Integer id = null;
	private Integer idCentro;
	private Integer id_item;
	private Integer quantidade;
	
	public EstoqueCentro() {}

	public EstoqueCentro( Integer idCentro, Integer id_item, Integer quantidade) {
	
		this.id = null;
		this.idCentro = idCentro;
		this.id_item = id_item;
		this.quantidade = quantidade;
		
	}

	public int getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(Integer idCentro) {
		this.idCentro = idCentro;
	}


	public int getIdtem() {
		
		return id_item;
	
	}

	public void setIdItem(int id_item) {
		this.id_item = id_item;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "EstoqueCentro [id=" + id + ", idCentro=" + idCentro +  ", id_item=" + id_item
				+ ", quantidade=" + quantidade + "]";
	}

	

}