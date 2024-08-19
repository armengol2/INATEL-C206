public class Main {
    public static void main(String[] args) {
        Zumbi z1 = new Zumbi();
        Zumbi z2 = new Zumbi();

        z1.vida = 100;
        z2.vida = 200;
        z1.nome = "laura";
        z2.nome = "dumbass";

        z1.mostraVida();
        z2.mostraVida();

        System.out.println(z1.vida);
        System.out.println(z2.vida);

        boolean transfere = z1.transfereVida(z2,100);
        System.out.println(z1.vida);
        System.out.println(z2.vida);


    }
}