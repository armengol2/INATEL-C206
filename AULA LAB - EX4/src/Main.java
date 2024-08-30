public class Main {
    public static void main(String[] args) {
        // Criando livros
        Livro livro1 = new Livro();
        livro1.titulo = "Senhor dos aneis";
        livro1.pagina = 1200;

        Livro livro2 = new Livro();
        livro2.titulo = "Harry Potter e a Pedra Filosofal";
        livro2.pagina = 350;

        // Criando sagas
        Saga saga1 = new Saga();
        saga1.adicionarLivro(livro1);
        saga1.nota = 5;

        Saga saga2 = new Saga();
        saga2.adicionarLivro(livro2);
        saga2.nota = 4;

        // Criando autor
        Autor autor = new Autor();
        autor.nome = "J.K. Rowling";

        // Adicionando sagas
        autor.adicionarSaga(saga1);
        autor.adicionarSaga(saga2);

        //listando livros
        saga1.listarLivros();

        // Listando sagas
        autor.listarSagas();
    }
}