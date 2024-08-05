import java.util.Scanner;

public class main {
    //equivalente ao main de c++
    public static void main(String[] args) {
        //entrada de dados
        Scanner entrada = new Scanner(System.in);
        int lanche1, lanche2, lanche3; //declarando as variaveis dos lanches
        System.out.println("Entre com o numero de lanches 1 =");
        lanche1 = entrada.nextInt();
        System.out.println("Entre com o numero de lanches 2 =");
        lanche2 = entrada.nextInt();
        System.out.println("Entre com o numero de lanches 3 =");
        lanche3 = entrada.nextInt();

        //contando lanches e media
        int total = lanche1 + lanche2 + lanche3;
        int media = total/3;

        //saida de dados
        System.out.println("Total de lanches = "+total);
        System.out.println("Media de lanches = "+media);
    }
}