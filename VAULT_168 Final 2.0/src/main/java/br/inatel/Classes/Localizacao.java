package br.inatel.Classes;

public class Localizacao {
    private String nome;
    private String referencia;
    private int seguranca;

    public Localizacao(String nome, String referencia, int seguranca) {
        this.nome = nome;
        this.referencia = referencia;
        this.seguranca = seguranca;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Referência: " + referencia +
                ", Nível de segurança: " + seguranca;
    }
}