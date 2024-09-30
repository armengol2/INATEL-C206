package br.inatel.Model;

public class Arma {
    private int idArma;
    private String nome;
    private String estilo;
    private String descricao;
    private int ataque;

    public Arma(int idArma, String nome, String estilo, String descricao, int ataque) {
        this.idArma = idArma;
        this.nome = nome;
        this.estilo = estilo;
        this.descricao = descricao;
        this.ataque = ataque;
    }

    // Getters
    public int getIdArma() {
        return idArma;
    }

    public String getNome() {
        return nome;
    }

    public String getEstilo() {
        return estilo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAtaque() {
        return ataque;
    }

    // Setters
    public void setIdArma(int idArma) {
        this.idArma = idArma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}