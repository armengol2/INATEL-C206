public abstract class Item implements AplicarDesconto{
    private String nome;
    private double preco;
    private int estoque;

    public Item(String nome, double preco, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public boolean verificarEstoque(int quantidade){
        if(quantidade <= this.estoque){
            return true;
        }
        else{
            return false;
        }
    }
    public void mostraInfo(){
        System.out.println("Nome do produto: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade em estoque: " + this.preco);
    }
}