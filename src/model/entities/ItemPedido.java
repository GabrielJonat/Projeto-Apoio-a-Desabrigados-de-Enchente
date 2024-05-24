package model.entities;

public class ItemPedido {

	private Integer id = null;
	private Integer id_pedido;
	private Integer id_item;
	private Integer quantidade;
	
	public ItemPedido() {}
	
	public ItemPedido(Integer id, Integer id_pedido, Integer id_item, Integer quantidade) {
		
		this.id = null;
		this.id_pedido = id_pedido;
		this.id_item = id_item;
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Integer getId_item() {
		return id_item;
	}

	public void setId_item(Integer id_item) {
		this.id_item = id_item;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", id_pedido=" + id_pedido + ", id_item=" + id_item + ", quantidade="
				+ quantidade + "]";
	}
	
	
}
