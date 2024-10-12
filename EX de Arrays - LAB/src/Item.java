public class Item {
    private int valor;
    private String nome;

    // Construtor
    public Item(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    // Getters e setters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
