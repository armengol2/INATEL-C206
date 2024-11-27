package br.inatel.Classes;

public class ArmaFogo extends Arma {
    private String calibre;

    public ArmaFogo(int idarma, String nome, int poder, String descricao, String calibre) {
        super(idarma, nome, poder, descricao);
        this.calibre = calibre;
    }

    @Override
    public void mostraInfo() {
        System.out.println("Arma de Fogo: " + nome);
        System.out.println("Calibre: " + calibre);
        System.out.println("Poder: " + poder);
        System.out.println("Descrição: " + descricao);
    }

}