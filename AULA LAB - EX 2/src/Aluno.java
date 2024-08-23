import java.util.Scanner;

public class Aluno {
    int matricula;
    int np1;
    int np2;
    int periodo;
    String nome;

    int calculaMedia() {
        int m = (this.np1 + this.np2) / 2;

        if (m >= 60 || m<30) {
            return m;
        }
        else {
            return calculaNP3(m);
        }
    }

    public int calculaNP3(int media) {


        Scanner sc = new Scanner(System.in);
        int np3 = sc.nextInt();
        int notafinal = (np3+media)/2;
        return notafinal;
    }



    public String toString() {
        return "Nome: " + this.nome +
                "\nMatrícula: " + this.matricula +
                "\nPeríodo: " + this.periodo;
    }
}
