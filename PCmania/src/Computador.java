public class Computador {
    public String marca;
    public float preco;
    public HardwareBasico[] hard = new HardwareBasico[3];
    public SistemaOperacional sist = new SistemaOperacional();  // sistema Operacional
    public MemoriaUSB musb;

    // função para mostrar as configurações do PC
    public void MostraPCConfigs() {
        System.out.println("Marca = " + this.marca);
        System.out.println("Preço = R$ " + this.preco);
        for (int i = 0; i < hard.length; i++) {
            System.out.println(hard[i].nome + " - " + hard[i].capacidade);
        }
        System.out.println("Sistema Operacional = " + sist.nome + " (" + sist.tipo + "-bits)");

        if (musb != null) {
            if (musb.capacidade > 1000) {
                System.out.println("Memória Externa = " + musb.nome + " - " + (musb.capacidade / 1000.0) + " TB");
            } else {
                System.out.println("Memória Externa = " + musb.nome + " - " + musb.capacidade + " GB");
            }
        } else {
            System.out.println("Nenhuma Memória Externa conectada.");
        }
    }
    public void addMemoria(MemoriaUSB musb) {
        this.musb = musb;
    }
}