package model.entities;

public class Estoque {
	
	private Integer id;
	private Integer idCentro;
	private Integer idAbrigo;
	private Doacao item;
	
	public Estoque() {}

	public Estoque(Integer idCentro, Integer idAbrigo, Doacao item) {
		super();
		this.idCentro = idCentro;
		this.idAbrigo = idAbrigo;
		this.item = item;
	}

	public Integer getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(Integer idCentro) {
		this.idCentro = idCentro;
	}

	public Integer getIdAbrigo() {
		return idAbrigo;
	}

	public void setIdAbrigo(Integer idAbrigo) {
		this.idAbrigo = idAbrigo;
	}

	public Doacao getItem() {
		return item;
	}

	public void setItem(Doacao item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", idCentro=" + idCentro + ", idAbrigo=" + idAbrigo + ", item=" + item + "]";
	}
	
	public void listar() {}

}