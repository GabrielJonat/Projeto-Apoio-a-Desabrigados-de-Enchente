package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Checkout{

    private Integer id = null;
    private Integer idpedido;
    private Integer numPedido;
    private String centro;
    private String abrigo;
    private Integer id_abrigo;
    private String item;
    private Integer id_item;
    private Integer id_centro;
    
    private String tipo;
    private String genero;
    private Integer tamanho;
    private Integer quantidade;
    private String status;
    private String motivo;


    public Checkout() {
        super();
    }

    public Checkout(Integer id, Integer idpedido, Integer numPedido, String centro, String abrigo, String item, String tipo, String genero, Integer tamanho, Integer quantidade, String status, String motivo) {
        this.id = id;
        this.idpedido = idpedido;
        this.numPedido = numPedido;
        this.centro = centro;
        this.abrigo = abrigo;
        this.item = item;
        this.tipo = tipo;
        this.genero = genero;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.status = status;
        this.motivo = motivo;
    }
    
    public Checkout(Integer id, Integer idpedido, String status, String motivo) {
        
    	this.id = null;
        this.idpedido = idpedido;
        this.numPedido = numPedido;
        this.centro = centro;
        this.abrigo = null;
        this.item = item;
        this.tipo = tipo;
        this.genero = genero;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.status = status;
        this.motivo = motivo;
    }
    
    
    
    
    public Integer getId_centro() {
		return id_centro;
	}

	public void setId_centro(Integer id_centro) {
		this.id_centro = id_centro;
	}

	public Integer getId_abrigo() {
		return id_abrigo;
	}

	public void setId_abrigo(Integer id_abrigo) {
		this.id_abrigo = id_abrigo;
	}

	public Integer getId_item() {
		return id_item;
	}

	public void setId_item(Integer id_item) {
		this.id_item = id_item;
	}

	public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(String abrigo) {
        this.abrigo = abrigo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String character) {
        this.genero = character;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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