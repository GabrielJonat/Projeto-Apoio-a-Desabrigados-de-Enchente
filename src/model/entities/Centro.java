package model.entities;
public class Centro {

    private Integer id;
    private String nome;
    private String logradouro;
    private Integer numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String limite;

    public Centro() {}


    public Centro(Integer id, String nome, String logradouro, Integer numero, String cep, String bairro, String cidade, String estado, String limite) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.limite = limite;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setLimite(String limite) {
        this.limite = limite;
    }
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public Integer getNumero() {
        return numero;
    }
    public String getCep() {
        return cep;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getLimite() {
        return limite;
    }


    @Override
    public String toString() {
        return "Centro " + id + " - " + nome + " | " + logradouro + ", " + numero + " - CEP: "
                + cep + " - " + bairro + ", " + cidade + "-" + estado + " [limite=" + limite + "]";
    }
}