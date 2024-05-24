package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Checkout{
	
	private Integer id;
	private Integer idpedido;
	private String status;
	private String motivo;
			
	public Checkout() {
		super();
	}
		
	public Checkout(Integer id, Integer idpedido, String status, String motivo) {
		super();
		this.id = id;
		this.idpedido = idpedido;
		this.status = status;
		this.motivo = motivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {

		this.motivo = motivo;
	}


}
