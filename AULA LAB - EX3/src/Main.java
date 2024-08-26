public class Main {
    public static void main(String[] args) {
       Jogador jogador1 = new Jogador();
       Jogador jogador2 = new Jogador();
       Arma adaga = new Arma();
       adaga.dano = 8;
       adaga.custoDeEnergia = 4;
       Arma claymore = new Arma();
       claymore.dano = 20;
       claymore.custoDeEnergia = 10;

       //estabalecendo dados do jogador 2
        jogador1.arma = adaga;
        jogador1.vida=50;
        jogador1.energia=50;

       //estabalecendo dados do jogador 2
        jogador2.arma = claymore;
        jogador2.vida=100;
        jogador2.energia=20;

        //saída no inicio da luta
        System.out.println("Começo do ataque:");
        System.out.println(jogador1);  // Mostra o jogador1 com a espada
        System.out.println(jogador2);  // Mostra o jogador2 com o arco

        //função de combate
        jogador1.atacar(jogador2);

        //saída no fim da luta
        System.out.println("Fim do ataque:");
        System.out.println(jogador1);  // Mostra o jogador1 com a espada
        System.out.println(jogador2);  // Mostra o jogador2 com o arco


    }
}