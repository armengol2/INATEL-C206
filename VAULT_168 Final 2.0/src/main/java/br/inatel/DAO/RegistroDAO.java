package br.inatel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO extends ConnetionDAO {

    public void inserirRegistro(int sobreviventeId, int localizacaoId, Date dataChegada) {
        connectToDb();
        String sql = "INSERT INTO registros (sobrevivente_id, localizacao_id, data_chegada) VALUES (?, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sobreviventeId);
            pst.setInt(2, localizacaoId);
            pst.setDate(3, dataChegada);
            pst.execute();
            System.out.println("Registro inserido com sucesso!");
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir registro: " + exc.getMessage());
        } finally {
            closeConnection();
        }
    }

    public List<String> listarRegistros() {
        connectToDb();
        String sql = "SELECT r.id, s.nome AS sobrevivente_nome, l.nome AS localizacao_nome, r.data_chegada " +
                "FROM registros r " +
                "JOIN sobreviventes s ON r.sobrevivente_id = s.id " +
                "JOIN localizacoes l ON r.localizacao_id = l.id";
        List<String> registros = new ArrayList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String registro = "ID: " + rs.getInt("id") +
                        ", Sobrevivente: " + rs.getString("sobrevivente_nome") +
                        ", Localização: " + rs.getString("localizacao_nome") +
                        ", Data de Chegada: " + rs.getDate("data_chegada");
                registros.add(registro);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao listar registros: " + exc.getMessage());
        } finally {
            closeConnection();
        }
        return registros;
    }

    public boolean atualizarRegistro(int id, int sobreviventeId, int localizacaoId, Date novaDataChegada) {
        connectToDb();
        String sql = "UPDATE registros SET sobrevivente_id = ?, localizacao_id = ?, data_chegada = ? WHERE id = ?";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sobreviventeId);
            pst.setInt(2, localizacaoId);
            pst.setDate(3, novaDataChegada);
            pst.setInt(4, id);

            int rowsAffected = pst.executeUpdate();
            sucesso = rowsAffected > 0;

            if (sucesso) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado para atualizar.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao atualizar registro: " + exc.getMessage());
        } finally {
            closeConnection();
        }

        return sucesso;
    }

    public boolean deletarRegistro(int id) {
        connectToDb();
        String sql = "DELETE FROM registros WHERE id = ?";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            sucesso = rowsAffected > 0;

            if (sucesso) {
                System.out.println("Registro deletado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado para deletar.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao deletar registro: " + exc.getMessage());
        } finally {
            closeConnection();
        }

        return sucesso;
    }

    private void closeConnection() {
        try {
            if (pst != null) pst.close();
            if (st != null) st.close();
            if (rs != null) rs.close();
            if (con != null) con.close();
        } catch (SQLException exc) {
            System.out.println("Erro ao fechar conexão: " + exc.getMessage());
        }
    }
}