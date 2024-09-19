public class Main {
    public static void main(String[] args) {
        // Criando um array dos produtos
        Produto[] produtos = new Produto[2];

        produtos[0] = new Camiseta("NIKE", 99.90, "Preta", "M");
        produtos[1] = new Notebook("Dell ", 3599.99, 512, "NVIDIA GTX", "Intel i4");

        for (Produto produto : produtos) {
            if (produto instanceof Camiseta) {
                System.out.println("Camiseta escolhida --> " + produto.etiquetaPreco());
            } else if (produto instanceof Notebook) {
                System.out.println("Notebook escolido --> " + produto.etiquetaPreco());
            } else {
                System.out.println("Produto: " + produto.etiquetaPreco());
            }
        }
    }
}