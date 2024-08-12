import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int aberracao;
        Scanner enter = new Scanner(System.in);
        Zumbi z = new Zumbi();

        System.out.println("força do zumbi(0-10):");
        z.forca = enter.nextInt();
        System.out.println("velocidade do zumbi(0-10):");
        z.velocidade = enter.nextInt();
        System.out.println("resistencia do zumbi(0-10):");
        z.resistencia = enter.nextInt();
        System.out.println("raiva do zumbi(0-10):");
        z.raiva = enter.nextInt();
        System.out.println("nivel de mutacao do zumbi(0-10):");
        z.mutacao = enter.nextInt();

        aberracao = z.forca + z.velocidade + z.resistencia + z.raiva + z.mutacao;

        System.out.println("nivel de aberracao:"+aberracao);

        }
}
