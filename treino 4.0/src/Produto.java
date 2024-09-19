public class Produto {
        private String nome; //nome do produto
        private double preco; //preço do produto

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String etiquetaPreco() {
            return nome + " R$ " + String.format("%.2f", preco);
        }
    }
