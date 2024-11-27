package br.inatel.Classes;

public abstract class Arma {
    protected int idarma;
    protected String nome;
    protected int poder;
    protected String descricao;

    public Arma(int idarma, String nome, int poder, String descricao) {
        this.idarma = idarma;
        this.nome = nome;
        this.poder = poder;
        this.descricao = descricao;
    }

    public abstract void mostraInfo();
}