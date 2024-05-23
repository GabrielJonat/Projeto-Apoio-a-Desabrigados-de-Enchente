package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    //Inicialização das variaveis
    private Integer id;
    private String nome;
    private String tipo;
    private String genero;
    private String tamanho;

    //Construtor sem passagem de parâmetro
    public Item() {
        super();
    }

    // Construtor com passagem de parâmetro

    public Item(Integer id, String nome, String tipo, String genero, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.genero = genero;
        this.tamanho = tamanho;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    //método toString
    @java.lang.Override
    public java.lang.String toString() {
        return "Item" +
                " Id: " + id +
                ", Nome: " + nome +
                ", Tipo: " + tipo +
                ", Genero: " + genero +
                ", Tamanho: " + tamanho;
    }

    //Criação do Equals and HashCode
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Item)) return false;
        if (!super.equals(object)) return false;
        Item doacao = (Item) object;
        return java.util.Objects.equals(id, doacao.id);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}