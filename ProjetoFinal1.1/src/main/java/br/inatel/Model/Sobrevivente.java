package br.inatel.Model;

public class Sobrevivente {
    private int idSobrevivente;
    private String nome;
    private String descricao;
    private int idade;
    private int forca;
    private int resistencia;
    private int agilidade;
    private int inteligencia;
    private int nivelDeHabilidade;

    public Sobrevivente(int idSobrevivente, String nome, String descricao, int idade,
                        int forca, int resistencia, int agilidade, int inteligencia, int nivelDeHabilidade) {
        this.idSobrevivente = idSobrevivente;
        this.nome = nome;
        this.descricao = descricao;
        this.idade = idade;
        this.forca = forca;
        this.resistencia = resistencia;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.nivelDeHabilidade = nivelDeHabilidade;
    }

    // Getters
    public int getIdSobrevivente() {
        return idSobrevivente;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdade() {
        return idade;
    }

    public int getForca() {
        return forca;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getNivelDeHabilidade() {
        return nivelDeHabilidade;
    }

    // Setters
    public void setIdSobrevivente(int idSobrevivente) {
        this.idSobrevivente = idSobrevivente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setNivelDeHabilidade(int nivelDeHabilidade) {
        this.nivelDeHabilidade = nivelDeHabilidade;
    }
}