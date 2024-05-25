package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Checkout{

    private Integer id;
    private Integer idpedido;
    private Integer numPedido;
    private String centro;
    private String abrigo;
    private String item;
    private String tipo;
    private Character genero;
    private Integer tamanho;
    private Integer quantidade;
    private Boolean status;
    private String motivo;


    public Checkout() {
        super();
    }

    public Checkout(Integer id, Integer idpedido, Integer numPedido, String centro, String abrigo, String item, String tipo, Character genero, Integer tamanho, Integer quantidade, Boolean status, String motivo) {
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

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
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

}