import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Item> carrinhoArray;

    public Carrinho() {
        carrinhoArray = new ArrayList<>();
    }

    public void adcionarItem(Item item, int quantidade)throws EstoqueInsuficienteException{
        if(Item.verificarEstoque()){
            carrinhoArray.add(Item);
        }
        else{
            throw new EstoqueInsuficienteException("Quantidade indisponível no momento...");
        }
    }

    public double calcularValor()throws CarrinhoVazioException{
        int soma = 0
        if (carrinhoArray.isEmpty()){
            throw new CarrinhoVazioException("Nenhum item encontrado");
        }
        else{
            for(Item item : carrinhoArray){
                soma = soma + item;
            }
        }

    }

    public void exibirItens(){
        if (carrinhoArray.isEmpty()){
            System.out.println("Carrinho vazio, favor, comprar algo");
        }
        else{
            for(Item item : carrinhoArray){

            }
        }
    }

}
