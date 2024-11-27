package br.inatel.Classes;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Sobrevivente {
    private int idsobre;
    private String nome;
    private int idade;
    private String descricao;
    private Arma arma;
    private Habilidades habilidades;
    private Registro registro;

    private static ArrayList<Sobrevivente> listaSobreviventes = new ArrayList<>();

    // Construtor
    public Sobrevivente(int idsobre, String nome, int idade, String descricao, Arma arma, Habilidades habilidades, Registro registro) {
        this.idsobre = idsobre;
        this.nome = nome;
        this.idade = idade;
        this.descricao = descricao;
        this.arma = arma;
        this.habilidades = habilidades;
        this.registro = registro;
    }

    public static void inserirSobrevivente() {
        Scanner scanner = new Scanner(System.in);

        int idsobre;
        while (true) {
            System.out.print("ID do sobrevivente: ");
            idsobre = scanner.nextInt();
            scanner.nextLine();

            boolean idExistente = false;
            for (Sobrevivente sobrevivente : listaSobreviventes) {
                if (sobrevivente.getIdsobre() == idsobre) {
                    idExistente = true;
                    break;
                }
            }

            if (idExistente) {
                System.out.println("!!!Error!!!");
                System.out.println("ID digitado em uso atualmente");
            } else {
                break;
            }
        }

        System.out.print("nome: ");
        String nome = scanner.nextLine();

        System.out.print("idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("descrição do sobrevivente: ");
        String descricao = scanner.nextLine();

        System.out.println("Oque faz de você S.P.E.C.I.A.L?: ");
        System.out.print("força: ");
        int forca = scanner.nextInt();

        System.out.print("percepção: ");
        int percepcao = scanner.nextInt();

        System.out.print("resistência: ");
        int resistencia = scanner.nextInt();

        System.out.print("carisma: ");
        int carisma = scanner.nextInt();

        System.out.print("inteligência: ");
        int inteligencia = scanner.nextInt();

        System.out.print("agilidade: ");
        int agilidade = scanner.nextInt();

        System.out.print("sorte: ");
        int sorte = scanner.nextInt();
        scanner.nextLine();

        Habilidades habilidades = new Habilidades(forca, percepcao, resistencia, carisma, inteligencia, agilidade, sorte);

        System.out.println("Objeto detectado!");
        System.out.println("1 -> Arma Branca");
        System.out.println("2 -> Arma de Fogo");
        System.out.print("-->");
        int tipoArma = scanner.nextInt();
        scanner.nextLine();

        Arma arma = null;

        if (tipoArma == 1) {
            System.out.print("ID da arma Branca: ");
            int idArma = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nome da arma Branca: ");
            String nomeArma = scanner.nextLine();

            System.out.print("Poder da arma Branca: ");
            int poderArma = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Descrição da Arma Branca: ");
            String descricaoArma = scanner.nextLine();

            System.out.print("Estilo da Arma Branca: ");
            String estiloArma = scanner.nextLine();

            arma = new ArmaBranca(idArma, nomeArma, poderArma, descricaoArma, estiloArma);

        } else if (tipoArma == 2) {
            System.out.print("ID da arma de Fogo: ");
            int idArma = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nome da arma de Fogo: ");
            String nomeArma = scanner.nextLine();

            System.out.print("Poder da arma de Fogo: ");
            int poderArma = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Descrição da arma de Fogo: ");
            String descricaoArma = scanner.nextLine();

            System.out.print("Calibre da arma de Fogo: ");
            String calibreArma = scanner.nextLine();

            arma = new ArmaFogo(idArma, nomeArma, poderArma, descricaoArma, calibreArma);
        } else {
            System.out.println("Opção inválida! Um erro severo ocorreu no cadastro!.");
            return;
        }

        System.out.println("Bem vindo ao seu novo lar, forasteiro! de onde está vindo? ");
        System.out.print("Nome da localização do vault: ");
        String nomeLocalizacao = scanner.nextLine();

        System.out.print("referência da localização: ");
        String referenciaLocalizacao = scanner.nextLine();

        System.out.print("Nível de segurança da localização(1-5): ");
        int segurancaLocalizacao = scanner.nextInt();
        scanner.nextLine();

        Localizacao localizacao = new Localizacao(nomeLocalizacao, referenciaLocalizacao, segurancaLocalizacao);

        LocalDate dataChegada = LocalDate.now();

        Registro registro = new Registro(new Sobrevivente(idsobre, nome, idade, descricao, arma, habilidades, null), localizacao, dataChegada);

        Sobrevivente sobrevivente = new Sobrevivente(idsobre, nome, idade, descricao, arma, habilidades, registro);

        listaSobreviventes.add(sobrevivente);

        System.out.println("Sobrevivente cadastrado no refugio 168.");
        registro.mostraInfo();
    }
    public static void procurarSobrevivente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do sobrevivente: ");
        int idProcurado = scanner.nextInt();
        scanner.nextLine();

        boolean encontrou = false;
        for (Sobrevivente sobrevivente : listaSobreviventes) {
            if (sobrevivente.getIdsobre() == idProcurado) {
                encontrou = true;

                System.out.println("Nome do Sobrevivente: " + sobrevivente.getNome());
                System.out.println("Idade: " + sobrevivente.getIdade());
                System.out.println("Descrição: " + sobrevivente.getDescricao());

                Habilidades habilidades = sobrevivente.getHabilidades();
                System.out.println("S: " + habilidades.getForca());
                System.out.println("P: " + habilidades.getPercepcao());
                System.out.println("E: " + habilidades.getResistencia());
                System.out.println("C: " + habilidades.getCarisma());
                System.out.println("I: " + habilidades.getInteligencia());
                System.out.println("A: " + habilidades.getAgilidade());
                System.out.println("L: " + habilidades.getSorte());

                Arma arma = sobrevivente.arma;
                if (arma != null) {
                    System.out.println("Arma Atual:");
                    arma.mostraInfo();
                }
                break;
            }
        }
        if (!encontrou) {
            System.out.println("OPS! Não há sobreviventes com o ID " + idProcurado);
        }
    }

    public static ArrayList<Sobrevivente> getListaSobreviventes() {
        return listaSobreviventes;
    }

    public int getIdsobre() {
        return idsobre;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Habilidades getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidades habilidades) {
        this.habilidades = habilidades;
    }


    public void mostraInfo() {
        System.out.println("ID: " + idsobre);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Descrição: " + descricao);

    }

    public static void mostrarTodosSobreviventes() {
        if (listaSobreviventes.isEmpty()) {
            System.out.println("Nenhum sobrevivente cadastrado.");
        } else {
            System.out.println("Todos os sobreviventes cadastrados:");
            for (Sobrevivente sobrevivente : listaSobreviventes) {
                sobrevivente.mostraInfo();
                System.out.println("-------------------------------------");
            }
        }
    }

    public static void excluirSobrevivente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do sobrevivente a ser excluído: ");
        int idParaExcluir = scanner.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < listaSobreviventes.size(); i++) {
            if (listaSobreviventes.get(i).getIdsobre() == idParaExcluir) {
                listaSobreviventes.remove(i);
                System.out.println("Sobrevivente com o ID " + idParaExcluir + " foi excluído.");
                System.out.println("Um minuto de silencio...");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum sobrevivente encontrado com o ID " + idParaExcluir + ".");
        }
    }

    public static void atualizarSobrevivente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do sobrevivente a ser atualizado: ");
        int idParaAtualizar = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;

        for (Sobrevivente sobrevivente : listaSobreviventes) {
            if (sobrevivente.getIdsobre() == idParaAtualizar) {
                encontrado = true;

                System.out.println("Sobrevivente localizado! atualização pronta...");

                System.out.print("Deseja atualizar a arma? (s/n): ");
                String respostaArma = scanner.nextLine();
                if (respostaArma.equalsIgnoreCase("s")) {
                    System.out.println("Qual tipo de arma você deseja definir?");
                    System.out.println("1 - Arma Branca");
                    System.out.println("2 - Arma de Fogo");
                    System.out.print("-->");
                    int tipoArma = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome da arma: ");
                    String nomeArma = scanner.nextLine();

                    System.out.print("Poder da arma: ");
                    int poderArma = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Descrição da arma: ");
                    String descricaoArma = scanner.nextLine();

                    Arma novaArma = null;
                    if (tipoArma == 1) {
                        System.out.print("Estilo da Arma Branca: ");
                        String estilo = scanner.nextLine();
                        novaArma = new ArmaBranca(0, nomeArma, poderArma, descricaoArma, estilo);
                    } else if (tipoArma == 2) {
                        System.out.print("Calibre da Arma de Fogo: ");
                        String calibre = scanner.nextLine();
                        novaArma = new ArmaFogo(0, nomeArma, poderArma, descricaoArma, calibre);
                    } else {
                        System.out.println("Opção inválida.");
                    }

                    if (novaArma != null) {
                        sobrevivente.setArma(novaArma);
                        System.out.println("Uma nova arma foi identificada, use com moderação!");
                    }
                }
                System.out.println("Digite as novas habilidades do sobrevivente:");
                System.out.print("Força: ");
                int novaForca = scanner.nextInt();
                System.out.print("Percepção: ");
                int novaPercepcao = scanner.nextInt();
                System.out.print("Resistência: ");
                int novaResistencia = scanner.nextInt();
                System.out.print("Carisma: ");
                int novoCarisma = scanner.nextInt();
                System.out.print("Inteligência: ");
                int novaInteligencia = scanner.nextInt();
                System.out.print("Agilidade: ");
                int novaAgilidade = scanner.nextInt();
                System.out.print("Sorte: ");
                int novaSorte = scanner.nextInt();
                scanner.nextLine();

                Habilidades novasHabilidades = new Habilidades(novaForca, novaPercepcao, novaResistencia,
                        novoCarisma, novaInteligencia, novaAgilidade, novaSorte);
                sobrevivente.setHabilidades(novasHabilidades);

                System.out.println("Novos dados disponíveis na opção 4!");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("O ID " + idParaAtualizar + " não está registrado");
        }
    }
}

