public class Banda {
    private Musica[] musicas = new Musica[10];
    private String nome;
    private int integrantes;

    public Banda(String nome, int integrantes) {
        this.nome = nome;
        this.integrantes = integrantes;
    }

    // Função de tocar uma música específica
    public void tocarMusica(int posicao) {
        if (posicao >= 0 && posicao < musicas.length && musicas[posicao] != null) {
            Musica musica = musicas[posicao];
            System.out.println("tocando: " + musica.getNome() + " do album " + musica.getAlbum());
        } else {
            System.out.println("musica não encontrada na posição " + posicao);
        }
    }

    // Função de tocar todas as músicas (show), exibindo todas as informações
    public void tocarShow() {
        System.out.println("iniciando show da banda " + nome);
        for (Musica musica : musicas) {
            if (musica != null) {
                System.out.println("musica: " + musica.getNome());
                System.out.println("album: " + musica.getAlbum());
                System.out.println("--------------");
            }
        }
    }

    // Função de adicionar uma música
    public boolean adicionarMusica(Musica musica) {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] == null) {
                musicas[i] = musica;
                return true;
            }
        }
        return false;
    }

    // Função de deletar uma música pelo nome
    public boolean deletarMusica(String nome) {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null && musicas[i].getNome().equals(nome)) {
                System.out.println("musica '" + nome + "' foi deletada.");
                musicas[i] = null;
                return true;
            }
        }
        System.out.println(nome + "' não foi encontrada.");
        return false;
    }
}