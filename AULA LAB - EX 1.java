import java.util.Scanner;

public class Main {
    
    // funcao para calcular o fatorial
    public static int calcularFatorial(int n) {
        int fat = 1;
        for (int i = 1; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }
    
    // funcao void para retornar pares
    public static void mostraPares(int n) {
        for (int i = 0; i <= n; i++) {
            if(i % 2 == 0){
            System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        //entrada de dados
        System.out.print("digite um numero: ");
        int numero = entrada.nextInt();
        
        // chamando a funcao de fatorial
        System.out.println("seu numero fatorial eh: "+calcularFatorial(numero));
        
        // chamando a funcao de mostrar os pares
        System.out.print("numeros pares:");
        mostraPares(numero);
        
        //fechando o scanner apos o uso
        entrada.close();
    }
}