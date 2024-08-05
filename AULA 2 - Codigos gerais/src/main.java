public class main {
    //equivalente ao main de c++
    public static void main(String[] args){
        int lanche1, lanche2, lanche3; //declarando as variaveis dos lanches

        //declarando valor de cada lanche
        lanche1 = 10;
        lanche2 = 4;
        lanche3 = 2;

        //contando lanches e media
        int total = lanche1 + lanche2 + lanche3;
        int media = total/3;

        //saida de dados obs=println é usado para quebra de linha
                             //print é usado sem quebra de linha
                             //printf é usado para quant depois da casa decimal
        System.out.println("Total de lanches = "+total);
        System.out.println("Total de lanches = "+media);
    }
}
