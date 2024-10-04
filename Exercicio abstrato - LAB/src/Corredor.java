// Classe Corredor que implementa Equipamento
public class Corredor extends Atleta implements Equipamento {
    @Override
    public void treinar() {
        System.out.println("Correndo na pista.");
    }

    @Override
    public void colocarEquipamento() {
        System.out.println("Equipamento necessario = tenis.");
    }
}

