import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("valor do raio:");
        double raio = entrada.nextInt();
        System.out.print("valor da altura:");
        double altura = entrada.nextInt();

        System.out.println("circunferencia:" + Calculadora.circunferencia(raio));
        System.out.println("volume da esfera:" + Calculadora.volumeEsfera(raio));
        System.out.println("volume do cilindro:" + Calculadora.volumeCilindro(raio, altura));

        entrada.close();
    }
}