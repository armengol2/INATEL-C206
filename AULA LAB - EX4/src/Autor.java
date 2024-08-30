public class Autor {
    Saga[] sagas = new Saga[100];
    String nome;

    // Função para listar as sagas
    void listarSagas() {
        for (int i = 0; i < sagas.length; i++) {
            if (sagas[i] != null) {
                Saga saga = sagas[i];
                System.out.println("Nome do autor: " + nome);
                System.out.println("Saga Nota: " + saga.nota);
                return;
            }
        }
    }

    // Função para adicionar uma saga
    void adicionarSaga(Saga saga) {
        for (int i = 0; i < sagas.length; i++) {
            if (sagas[i] == null) {
                sagas[i] = saga;
            }
        }
    }
}