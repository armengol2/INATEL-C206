package br.inatel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SobreviventeDAO extends ConnetionDAO {

    public int inserirSobrevivente(String nome, int idade, String descricao) {
        connectToDb(); // Conecta ao banco
        String sql = "INSERT INTO sobreviventes (nome, idade, descricao) VALUES (?, ?, ?)";
        int idGerado = -1;

        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, nome);
            pst.setInt(2, idade);
            pst.setString(3, descricao);
            pst.execute();

            rs = pst.getGeneratedKeys(); // Recupera o ID gerado
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }

            System.out.println("Sobrevivente inserido com sucesso!");
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir sobrevivente: " + exc.getMessage());
        } finally {
            closeConnection();
        }

        return idGerado; // Retorna o ID gerado
    }

    public List<String> listarSobreviventes() {
        connectToDb(); // Conecta ao banco
        String sql = "SELECT * FROM sobreviventes";
        List<String> sobreviventes = new ArrayList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String sobrevivente = "ID: " + rs.getInt("id") +
                        ", Nome: " + rs.getString("nome") +
                        ", Idade: " + rs.getInt("idade") +
                        ", Descrição: " + rs.getString("descricao");
                sobreviventes.add(sobrevivente);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao listar sobreviventes: " + exc.getMessage());
        } finally {
            closeConnection();
        }
        return sobreviventes;
    }

    public boolean atualizarSobrevivente(int id, String nome, int idade, String descricao) {
        connectToDb(); // Conecta ao banco
        String sql = "UPDATE sobreviventes SET nome = ?, idade = ?, descricao = ? WHERE id = ?";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, idade);
            pst.setString(3, descricao);
            pst.setInt(4, id);

            int rowsAffected = pst.executeUpdate();
            sucesso = rowsAffected > 0;

            if (sucesso) {
                System.out.println("Sobrevivente atualizado com sucesso!");
            } else {
                System.out.println("Nenhum sobrevivente encontrado para atualizar.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao atualizar sobrevivente: " + exc.getMessage());
        } finally {
            closeConnection();
        }

        return sucesso;
    }

    public boolean deletarSobrevivente(int id) {
        connectToDb(); // Conecta ao banco
        String sql = "DELETE FROM sobreviventes WHERE id = ?";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            sucesso = rowsAffected > 0;

            if (sucesso) {
                System.out.println("Sobrevivente deletado com sucesso!");
            } else {
                System.out.println("Nenhum sobrevivente encontrado para deletar.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao deletar sobrevivente: " + exc.getMessage());
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