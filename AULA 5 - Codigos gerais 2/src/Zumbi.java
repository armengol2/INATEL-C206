public class Zumbi {
    String nome;
    double vida;

    double mostraVida(){
        return vida;
    }
    boolean transfereVida(Zumbi zumbiAlvo, double quantia){
        if(this.vida <= quantia){
            return false;
        }
        else{
            this.vida -= quantia;
            zumbiAlvo.vida += quantia;
            return true;
        }
    }
}

