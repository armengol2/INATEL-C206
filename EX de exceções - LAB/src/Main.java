public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        try {
            Livro livro1 = new Livro("Livro nada generico", "Rodrigo A", 50.0);
            inventario.adicionarLivro(livro1);
        } catch (ExcecaoLivroInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Livro livro2 = new Livro("", "Desconhecido da silva", 45.0);
            inventario.adicionarLivro(livro2);
        } catch (ExcecaoLivroInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Livro livro3 = new Livro("Varias paginas", "zezinho B", 100.0);
            inventario.adicionarLivro(livro3);
        } catch (ExcecaoLivroInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Livro livro4 = new Livro("Como ganhar dinheiro", "johnny comunista", -10.0);
            inventario.adicionarLivro(livro4);
        } catch (ExcecaoLivroInvalido e) {
            System.out.println(e.getMessage());
        }

        inventario.exibirLivros();
    }
}