public class Jogador {
    Arma arma;
    int vida;
    int energia;

    @Override
    public String toString() {
        return "status da arma->" + arma +
                "|| Status do jogador-> vida=" + vida +
                ", energia=" + energia +
                '}';
    }

    void atacar(Jogador alvo) {
        if (this.energia >= this.arma.custoDeEnergia) {
            alvo.vida -= this.arma.dano;
            this.energia -= this.arma.custoDeEnergia;
            System.out.println("Ataque bem-sucedido: Vida do alvo: " + alvo.vida + ". Energia restante: " + this.energia);
        } else {
            System.out.println("Energia insuficiente!");
        }
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
}