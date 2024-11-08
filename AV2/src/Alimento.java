public class Alimento extends Item{
    private int tamanho;

    public Alimento(String nome, double preco, int estoque, int tamanho){
        super(nome,preco,estoque);
        this.tamanho = tamanho;
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("VAL: " + this.tamanho);
    }
}