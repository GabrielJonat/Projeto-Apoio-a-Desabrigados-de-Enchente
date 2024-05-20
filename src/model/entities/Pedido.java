package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer quantidade;
	private Boolean status;
	private String motivo;
	private LocalDate dataPedido;
	private LocalDate dataEntrega;
	
	public Pedido() {
	}

	public Pedido(Integer id, Integer quantidade, Boolean status, String motivo, LocalDate dataPedido,
			LocalDate dataEntrega) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.status = status;
		this.motivo = motivo;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
