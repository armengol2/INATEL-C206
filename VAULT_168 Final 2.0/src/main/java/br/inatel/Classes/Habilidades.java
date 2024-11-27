package br.inatel.Classes;

public class Habilidades {
    private int forca;
    private int percepcao;
    private int resistencia;
    private int carisma;
    private int inteligencia;
    private int agilidade;
    private int sorte;

    public Habilidades(int forca, int percepcao, int resistencia, int carisma, int inteligencia, int agilidade, int sorte) {
        this.forca = forca;
        this.percepcao = percepcao;
        this.resistencia = resistencia;
        this.carisma = carisma;
        this.inteligencia = inteligencia;
        this.agilidade = agilidade;
        this.sorte = sorte;
    }

    @Override
    public String toString() {
        return "S: " + forca +
                ", P: " + percepcao +
                ", E: " + resistencia +
                ", C: " + carisma +
                ", I: " + inteligencia +
                ", A: " + agilidade +
                ", L: " + sorte;
    }

    public int getForca() { return forca; }
    public int getPercepcao() { return percepcao; }
    public int getResistencia() { return resistencia; }
    public int getCarisma() { return carisma; }
    public int getInteligencia() { return inteligencia; }
    public int getAgilidade() { return agilidade; }
    public int getSorte() { return sorte; }
}
