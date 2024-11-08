public class Vestuario extends Item{
    private String validade;

    public Vestuario(String nome, double preco, int estoque, String validade){
        super(nome,preco,estoque);
        this.validade = validade;
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("/VAL: " + this.validade);
    }
}
