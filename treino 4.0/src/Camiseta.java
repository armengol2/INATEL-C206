public class Camiseta extends Produto {

    private String cor;
    private String tamanho;

    public Camiseta(String nome, double preco, String cor, String tamanho) {
        super(nome, preco);
        this.cor = cor;
        this.tamanho = tamanho;
    }
    public String etiquetaPreco() {
        return super.etiquetaPreco() + " /cor= " + cor + " /tamanho= " + tamanho;
    }

}