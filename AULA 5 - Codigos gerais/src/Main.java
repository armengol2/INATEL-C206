public class Main {
    public static void main(String[] args) {
     Zumbi z1 = new Zumbi();
     z1.nome = "carlinhos";
     z1.vida = 2050;

     Zumbi z2 = new Zumbi();
     z2.nome = "cleide";
     z2.vida = 1500;

        System.out.println(z1.mostraVida());
        System.out.println(z2.mostraVida());
    }
}
