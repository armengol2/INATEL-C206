package br.inatel.Classes;

public class ArmaBranca extends Arma {
    private String estilo;

    public ArmaBranca(int idarma, String nome, int poder, String descricao, String estilo) {
        super(idarma, nome, poder, descricao);
        this.estilo = estilo;
    }

    @Override
    public void mostraInfo() {
        System.out.println("Arma Branca: " + nome);
        System.out.println("Estilo: " + estilo);
        System.out.println("Poder: " + poder);
        System.out.println("Descrição: " + descricao);
    }
}