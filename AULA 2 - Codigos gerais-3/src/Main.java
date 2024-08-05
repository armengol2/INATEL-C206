import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //entrada de dados
        Scanner entrada = new Scanner(System.in);

        //declaracao de variaveis
        int prova1, prova2, np3;
        int npa;
        int nfa;

        //entrando com prova1 e prova2
        System.out.println("Entre com a nota da prova 1 =");
        prova1 = entrada.nextInt();
        System.out.println("Entre com a nota da prova 2 =");
        prova2 = entrada.nextInt();

        //calculando media
        npa = (prova1 + prova2)/2;

        //opcao 1 - sem np3
        if(npa >= 60){
            System.out.println("meteu a braba slk kk, sua nota foi ="+npa);
        }

        //opcao 2 - com np3
        else{
            System.out.println("Entre com a nota da np3 =");
            np3 = entrada.nextInt();

            //calculando nfa
            nfa = (np3 + npa)/2;

            //opcao 2/1 - passou
            if(nfa >= 50){
                System.out.println("boa fella, sua nota foi ="+nfa);
            }

            //opcao 2/2 - nao passou
            else{
                System.out.println("mais sorte da proxima vez, nota miseravi de ="+nfa);
            }
        }
    }
}