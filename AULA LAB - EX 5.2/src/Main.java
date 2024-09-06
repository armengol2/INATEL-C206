public class Main {
    public static void main(String[] args) {
        // Criando uma nova banda
        Banda banda = new Banda("Foster the people", 4);

        Musica musica1 = new Musica();
        musica1.setNome("pumped up kicks");
        musica1.setAlbum("Torches");

        Musica musica2 = new Musica();
        musica2.setNome("Waste");
        musica2.setAlbum("houdini");

        banda.adicionarMusica(musica1);
        banda.adicionarMusica(musica2);

        banda.tocarMusica(0);
        banda.tocarMusica(1);

        banda.tocarShow();

        banda.deletarMusica("the wonder");

        banda.tocarShow();
    }
}