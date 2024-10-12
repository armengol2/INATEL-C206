import java.util.ArrayList;

public class Estoque {
    private ArrayList<Item> itensArray;

    public Estoque() {
        itensArray = new ArrayList<>();
    }

    public void adicionar(Item item) {
        itensArray.add(item);
    }

    public Item buscar(int posicao) {
        if (posicao >= 0 && posicao < itensArray.size()) {
            return itensArray.get(posicao);
        } else {
            return null;
        }
    }

    public void deletar(int posicao) {
        if (posicao >= 0 && posicao < itensArray.size()) {
            itensArray.remove(posicao);
        }
    }

    public void deletar(Item item) {
        itensArray.remove(item);
    }

    public void modificar(Item item, int posicao) {
        if (posicao >= 0 && posicao < itensArray.size()) {
            itensArray.set(posicao, item);
        }
    }
}
