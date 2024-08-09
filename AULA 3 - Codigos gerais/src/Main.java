import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int numalunos = entrada.nextInt();

        //em caso de duas entradas com a mesma saída, pode se juntar as cases
        switch (numalunos){
            case 10:
            case 20:
                System.out.println("sala I-16");
            break;

            case 30:
                System.out.println("sala I-22");
            break;
        }
    }
}