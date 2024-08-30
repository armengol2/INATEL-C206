public class Saga {
    Livro[] livros = new Livro[100];
    int nota;

    //função de listar livros
    void listarLivros() {
        for (int i = 0; i <= livros.length; i++)
            if (livros[i] != null) {
                Livro livro = livros[i];
                System.out.println("Título: " + livro.titulo + ", Páginas: " + livro.pagina);
                return;
            }

    }

    //função para adcionar livros
    void adicionarLivro(Livro livro) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                livros[i] = livro;
            }
        }
    }
}