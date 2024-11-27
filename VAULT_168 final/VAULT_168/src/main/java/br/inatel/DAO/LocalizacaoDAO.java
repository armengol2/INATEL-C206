package br.inatel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocalizacaoDAO extends ConnetionDAO {

    public int inserirLocalizacao(String nome, String referencia, int seguranca) {
        connectToDb(); // Conecta ao banco
        String sql = "INSERT INTO localizacoes (nome, referencia, seguranca) VALUES (?, ?, ?)";
        int idGerado = -1;

        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, nome);
            pst.setString(2, referencia);
            pst.setInt(3, seguranca);
            pst.execute();

            rs = pst.getGeneratedKeys(); // Recupera o ID gerado
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }

            System.out.println("Localização inserida com sucesso!");
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir localização: " + exc.getMessage());
        } finally {
            closeConnection();
        }

        return idGerado; // Retorna o ID gerado
    }

    public List<String> listarLocalizacoes() {
        connectToDb();
        String sql = "SELECT * FROM localizacoes";
        List<String> localizacoes = new ArrayList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String localizacao = "ID: " + rs.getInt("id") +
                        ", Nome: " + rs.getString("nome") +
                        ", Referência: " + rs.getString("referencia") +
                        ", Segurança: " + rs.getInt("seguranca");
                localizacoes.add(localizacao);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao listar localizações: " + exc.getMessage());
        } finally {
            closeConnection();
        }
        return localizacoes;
    }

    public boolean atualizarLocalizacao(int id, String nome, String referencia, int seguranca) {
        connectToDb();
        String sql = "UPDATE localizacoes SET nome = ?, referencia = ?, seguranca = ? WHERE id = ?";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, referencia);
            pst.setInt(3, seguranca);
            pst.setInt(4, id);

            int rowsAffected = pst.executeUpdate();
            sucesso = rowsAffected > 0;

            if (sucesso) {
                System.out.println("Localização atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma localização encontrada para atualizar.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao atualizar localização: " + exc.getMessage());
        } finally {
            closeConnection();
        }

        return sucesso;
    }

    public boolean deletarLocalizacao(int id) {
        connectToDb();
        String sql = "DELETE FROM localizacoes WHERE id = ?";
        boolean sucesso = false;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            sucesso = rowsAffected > 0;

            if (sucesso) {
                System.out.println("Localização deletada com sucesso!");
            } else {
                System.out.println("Nenhuma localização encontrada para deletar.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao deletar localização: " + exc.getMessage());
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