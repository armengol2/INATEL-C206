import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarando entrada
        Scanner entrada = new Scanner(System.in);

        //declarando variaveis
        int n, x;

        //comando de randomizer
        Random rand = new Random();

        do
        {
            //criando um numero aleatorio
            x = rand.nextInt(10)+1;

            //entrada de dados
            System.out.println("digite um numero ai:");
            n = entrada.nextInt();

            if (n > x) {
                System.out.println("seu numero escolido foi maior:");
            }
            else{
                System.out.println("seu numero escolido foi menor:");
            }

        }while(n != x);
        System.out.println("AEEEE CARAI, O NUMERO SORTEADO FOI:"+n);
    }
}