public class Main {
    public static void main(String[] args) {
        Arquivo arquivo = new Arquivo();

        Jogo jogo1 = new Jogo(1, "Red dead redemption 2", 199.99);
        Jogo jogo2 = new Jogo(2, "Grand Theft Auto 6", 349.99);

        System.out.println("armazendando jogos no arquivo...");
        arquivo.escrever(jogo1);
        arquivo.escrever(jogo2);

        System.out.println("Buscando jogos do arquivo(carregando)...:");
        arquivo.lerJogos();

        System.out.println("buscando jogo com preço 199.99...");
        arquivo.lerJogo(199.99);

        System.out.println("buscando jogo com preço 349.99...");
        arquivo.lerJogo(399.99);
    }
}