public class Cliente {
    public String nome; // Nome do cliente
    public long cpf;    // CPF do cliente
    private Computador[] compras = new Computador[3];
    private int contador = 0;

    // metodo para adicionar um computador e calcular o total da compra
    public float CalculaTotalCompra(Computador computador) {
        if (contador < compras.length) {
            compras[contador] = computador;
            contador++;
        }
        float total = 0;
        for (int i = 0; i < contador; i++) {
            if (compras[i] != null) {
                total += compras[i].preco;
            }
        }
        return total;
    }
}