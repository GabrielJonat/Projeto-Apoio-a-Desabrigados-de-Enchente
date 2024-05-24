package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {

	private Integer id;
	private Integer id_abrigo;
	private Integer id_centro;
	private LocalDate dataPedido;
	private LocalDate dataEntrega;
	
	private List<Item> items = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Integer id, Integer id_abrigo, Integer id_centro, List<Item> items) {
		super();
		this.id = id;
		this.id_abrigo = id_abrigo;
		this.id_centro = id_centro;
		this.items= items;
		
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_abrigo() {
		return id_abrigo;
	}

	public void setId_abrigo(Integer id_abrigo) {
		this.id_abrigo = id_abrigo;
	}

	public Integer getId_centro() {
		return id_centro;
	}

	public void setId_centro(Integer id_centro) {
		this.id_centro = id_centro;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}	
}
