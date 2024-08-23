//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        int notafinal;
        aluno.nome = "ze";
        aluno.np1 = 40;
        aluno.np2 = 40;
        aluno.matricula = 292;
        aluno.periodo = 6;
        //mostrando as informaçoes do aluno
        System.out.println(aluno.toString());

        int var = aluno.calculaMedia();

        if(var >= 60)
        {
            System.out.println("parabens, sua nota foi =" + var);
        }
        else if (var < 30)
        {
            System.out.println("Reprovado. Nota final foi: " + var);
        }
        else
        {
            System.out.println("nota final: " + var);
        }
    }
}