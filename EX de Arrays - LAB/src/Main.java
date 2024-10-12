import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Criando o estoque
        Estoque estoque = new Estoque();

        estoque.adicionar(new Item(1, "Batom Garoto"));
        estoque.adicionar(new Item(99, "Caviar"));
        estoque.adicionar(new Item(26, "Milka ao leite"));
        estoque.adicionar(new Item(460, "Wagyu A5 1Kg"));

        System.out.println("Itens no estoque pré viscalização:");
        exibirItensOrdenados(estoque);

        estoque.modificar(new Item(150, "Caviar"), 1);

        estoque.deletar(2);

        System.out.println("\nItens no estoque pós viscalização:");
        exibirItensOrdenados(estoque);
    }

    public static void exibirItensOrdenados(Estoque estoque) {
        ArrayList<Item> itens = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Item item = estoque.buscar(i);
            if (item != null) {
                itens.add(item);
            }
        }

        Collections.sort(itens, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Integer.compare(item2.getValor(), item1.getValor());
            }
        });

        for (Item item : itens) {
            System.out.println("Nome: " + item.getNome() + ", Valor: " + item.getValor());
        }
    }
}