package model.entities;

public class Doacao {

    private String nome;
    private String tipo;
    private String genero;
    private String tamanho;

    // Construtor sem passagem de parâmetros
    public Doacao() {

    }

    // Construtor com passagem de parâmetros
    public Doacao(String nome, String tipo, String genero, String tamanho) {
        this.nome = nome;
        this.tipo = tipo;
        this.genero = genero;
        this.tamanho = tamanho;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Itens: " +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", genero='" + genero + '\'' +
                ", tamanho='" + tamanho + '\'' +
                '}';
    }
}
