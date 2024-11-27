package br.inatel.Classes;

import java.time.LocalDate;

public class Registro {
    private Sobrevivente sobrevivente;
    private Localizacao localizacao;
    private LocalDate dataChegada;

    public Registro(Sobrevivente sobrevivente, Localizacao localizacao, LocalDate dataChegada) {
        this.sobrevivente = sobrevivente;
        this.localizacao = localizacao;
        this.dataChegada = dataChegada;
    }

    public void mostraInfo() {
        System.out.println("Sobrevivente: " + sobrevivente.getNome());
        System.out.println("Localização: " + localizacao);
        System.out.println("Data de chegada: " + dataChegada);
    }

    @Override
    public String toString() {
        return "Localização: " + localizacao +
                ", Data de chegada: " + dataChegada;
    }
}