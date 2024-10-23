import java.util.ArrayList;

public class Inventario {
    private ArrayList<Livro> livros;

    public Inventario() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) throws ExcecaoLivroInvalido {
        if (livro.getTitulo().isEmpty()) {
            throw new ExcecaoLivroInvalido("Error 404#: O título não foi incluído.");
        }
        if (livro.getPreco() < 0) {
            throw new ExcecaoLivroInvalido("Error 404#: O preço do livro é invalido.");
        }

        livros.add(livro);
    }

    public void exibirLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro no inventário.");
        } else {
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo() + " / Autor: " + livro.getAutor() + " / Preço: " + livro.getPreco());
            }
        }
    }
}