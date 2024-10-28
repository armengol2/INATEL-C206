import java.io.*;

public class Arquivo {

    public void escrever(Jogo jogo) {
        try (BufferedWriter bufferSaida = new BufferedWriter(new FileWriter("jogos.txt", true))) {
            bufferSaida.write(jogo.getId() + ";" + jogo.getNome() + ";" + jogo.getPreco());
            bufferSaida.newLine();
            System.out.println("Jogo escrito no arquivo.");
        } catch (IOException e) {
            System.err.println("erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public void lerJogos() {
        try (BufferedReader bufferEntrada = new BufferedReader(new FileReader("jogos.txt"))) {
            String linha;
            while ((linha = bufferEntrada.readLine()) != null) {
                String[] dados = linha.split(";");
                Jogo jogo = new Jogo(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]));
                jogo.mostrarInfos();
            }
        } catch (IOException e) {
            System.err.println("Error 404### falha ao tentar ler: " + e.getMessage());
        }
    }

    public void lerJogo(double preco) {
        try (BufferedReader bufferEntrada = new BufferedReader(new FileReader("jogos.txt"))) {
            String linha;
            boolean jogoEncontrado = false;
            while ((linha = bufferEntrada.readLine()) != null) {
                String[] dados = linha.split(";");
                double precoJogo = Double.parseDouble(dados[2]);

                if (precoJogo == preco) {
                    Jogo jogo = new Jogo(Integer.parseInt(dados[0]), dados[1], precoJogo);
                    jogo.mostrarInfos();
                    jogoEncontrado = true;
                    break;
                }
            }

            if (!jogoEncontrado) {
                System.out.println("preço de: " + preco + " não foi encontrado");
            }
        } catch (IOException e) {
            System.err.println("Error 404### falha ao tentar ler: " + e.getMessage());
        }
    }
}