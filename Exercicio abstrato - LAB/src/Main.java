public class Main {
    public static void main(String[] args) {

        Atleta ciclista = new Ciclista();
        ciclista.treinar();
        ((Equipamento) ciclista).colocarEquipamento();

        Atleta corredor = new Corredor();
        corredor.treinar();
        ((Equipamento) corredor).colocarEquipamento();

        Atleta nadador = new Nadador();
        nadador.treinar();
    }
}