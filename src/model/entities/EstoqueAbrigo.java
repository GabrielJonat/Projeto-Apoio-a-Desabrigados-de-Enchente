package model.entities;


public class EstoqueAbrigo {
	
	private Integer id = null;
	private Integer idAbrigo;
	private Integer id_item;
	private Integer quantidade;
	
	public EstoqueAbrigo() {}

	public EstoqueAbrigo( Integer idAbrigo, Integer id_item, Integer quantidade) {
	
		this.id = null;
		this.idAbrigo = idAbrigo;
		this.id_item = id_item;
		this.quantidade = quantidade;
		
	}

	public int getIdAbrigo() {
		return idAbrigo;
	}

	public void setIdAbrigo(Integer idAbrigo) {
		
		this.idAbrigo = idAbrigo;
	
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
	
		return "EstoqueCentro [id=" + id + ", idAbrigo=" + idAbrigo +  ", id_item=" + id_item
				+ ", quantidade=" + quantidade + "]";
	
	}

}