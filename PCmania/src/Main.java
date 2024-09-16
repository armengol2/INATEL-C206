import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Computador pc1 = new Computador();
        pc1.marca = "Dell";
        pc1.preco = 294;
        pc1.hard[0] = new HardwareBasico();
        pc1.hard[0].nome = "Processador ruim";
        pc1.hard[0].capacidade = 0.5f;
        pc1.hard[1] = new HardwareBasico();
        pc1.hard[1].nome = "RAM";
        pc1.hard[1].capacidade = 2;
        pc1.hard[2] = new HardwareBasico();
        pc1.hard[2].nome = "HD";
        pc1.hard[2].capacidade = 1;
        pc1.sist.nome = "Windows 10";
        pc1.sist.tipo = 64;

        MemoriaUSB memoriaUSB1 = new MemoriaUSB();
        memoriaUSB1.nome = "Kingston";
        memoriaUSB1.capacidade = 500;
        pc1.addMemoria(memoriaUSB1);

        Computador pc2 = new Computador();
        pc2.marca = "HP";
        pc2.preco = 3500.0f;
        pc2.hard[0] = new HardwareBasico();
        pc2.hard[0].nome = "Processador AMD Ryzen 5";
        pc2.hard[0].capacidade = 3.0f;
        pc2.hard[1] = new HardwareBasico();
        pc2.hard[1].nome = "RAM";
        pc2.hard[1].capacidade = 8;
        pc2.hard[2] = new HardwareBasico();
        pc2.hard[2].nome = "HD";
        pc2.hard[2].capacidade = 512;
        pc2.sist.nome = "Ubuntu";
        pc2.sist.tipo = 64;

        Computador pc3 = new Computador();
        pc3.marca = "Acer";
        pc3.preco = 3000.0f;
        pc3.hard[0] = new HardwareBasico();
        pc3.hard[0].nome = "Processador Intel i5";
        pc3.hard[0].capacidade = 2.5f;
        pc3.hard[1] = new HardwareBasico();
        pc3.hard[1].nome = "RAM";
        pc3.hard[1].capacidade = 8;
        pc3.hard[2] = new HardwareBasico();
        pc3.hard[2].nome = "HD";
        pc3.hard[2].capacidade = 1;
        pc3.sist.nome = "Windows 11";
        pc3.sist.tipo = 64;

        MemoriaUSB memoriaUSB3 = new MemoriaUSB();
        memoriaUSB3.nome = "SanDisk";
        memoriaUSB3.capacidade = 1500; // GB
        pc3.addMemoria(memoriaUSB3);

        Cliente cliente = new Cliente();
        // Entrando com dados do cliente
        System.out.println("Bem-vindo à PCmania!");
        System.out.println("A sua loja de computadores");
        System.out.print("Digite seu nome: ");
        cliente.nome = entrada.nextLine();

        System.out.print("Digite seu CPF: ");
        cliente.cpf = entrada.nextLong();

        // Lista para armazenar PCs comprados
        List<Computador> pcsComprados = new ArrayList<>();

        // Variável de opção
        int opcao;

        // Loop de compras
        do {
            System.out.println("Menu:");
            System.out.println("1. Comprar PC 1");
            System.out.println("2. Comprar PC 2");
            System.out.println("3. Comprar PC 3");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cliente.CalculaTotalCompra(pc1);
                    pcsComprados.add(pc1);
                    System.out.println("PC 1 adicionado ao seu carrinho.");
                    break;
                case 2:
                    cliente.CalculaTotalCompra(pc2);
                    pcsComprados.add(pc2);
                    System.out.println("PC 2 adicionado ao seu carrinho.");
                    break;
                case 3:
                    cliente.CalculaTotalCompra(pc3);
                    pcsComprados.add(pc3);
                    System.out.println("PC 3 adicionado ao seu carrinho.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ops, parece que sua opção não existe.");
                    System.out.println("Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        System.out.println("Obrigado por comprar com a PCmania, " + cliente.nome + "!");
        System.out.println("Seus PCs comprados foram:");
        for (Computador pc : pcsComprados) {
            pc.MostraPCConfigs();
            System.out.println("------------");
        }
        System.out.println("Total da compra: R$ " + cliente.CalculaTotalCompra(null));
        System.out.println("CPF na nota: " + cliente.cpf);
        System.out.println("VOLTE SEMPRE!");
    }
}
