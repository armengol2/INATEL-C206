package br.inatel.Classes;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu de opções
        int opcao = 0;

        System.out.println("!BEM VINDO AO REFUGIO 168!");
        System.out.println("UM OFERECIMENTO VAULT-TEC® inc...");
        while (opcao != 6) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Sobrevivente");
            System.out.println("2 - Buscar Sobreviventes");
            System.out.println("3 - Atualizar arma/atibutos de um Sobrevivente");
            System.out.println("4 - Sobreviventes no Vault");
            System.out.println("5 - Expulsão/falecimento de Sobrevivente");
            System.out.println("6 - Fechar o arquivo");
            System.out.print("------>");
            opcao = scanner.nextInt();
            scanner.nextLine();
            //menu de escolhas
            switch (opcao) {
                case 1:
                    Sobrevivente.inserirSobrevivente();
                    break;
                case 2:
                    System.out.println("Procurando sobreviventes...");
                    Sobrevivente.procurarSobrevivente();
                    break;
                case 3:
                    System.out.println("Atualizar dados de um sobrevivente...");
                    Sobrevivente.atualizarSobrevivente();
                    break;
                case 4:
                    System.out.println("Pesquisando no banco todos os sobreviventes. favor, aguarde...");
                    Sobrevivente.mostrarTodosSobreviventes();
                    break;
                case 5:
                    System.out.println("Carregando processo de exclusão...");
                    Sobrevivente.excluirSobrevivente();
                    break;
                case 6:
                    System.out.println("Obrigado por escolher a Vault-Tec!");
                    System.out.println("Tenha um excelente dia...");
                    break;
                default:
                    System.out.println("Opção errada Inserida;-; tente novamente...");
            }
        }
        scanner.close();
    }
}