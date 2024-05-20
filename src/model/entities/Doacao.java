package model.entities;

public class Doacao {

    private int id;
    private String nome;
    private String tipo;
    private char genero;
    private char tamanho;

    // Construtor sem passagem de parâmetros
    public Doacao() {

    }

    // Construtor com passagem de parâmetros


    public Doacao(int id, String nome, String tipo, char genero, char tamanho) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.genero = genero;
        this.tamanho = tamanho;
    }

    // Criação dos Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Itens: " +
                "Nome: " + nome +
                "Tipo: " + tipo +
                "Genero: " + genero +
                "Tamanho: " + tamanho;
    }

    // Criação toHashCode
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Doacao doacao = (Doacao) object;
        return id == doacao.id;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
