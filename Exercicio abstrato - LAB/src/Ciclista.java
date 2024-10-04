public class Ciclista extends Atleta implements Equipamento {
    @Override
    public void treinar() {
        System.out.println("Subindo na biclicleta.");
    }

    @Override
    public void colocarEquipamento() {
        System.out.println("Equipamento necessario = capacete.");
    }
}
