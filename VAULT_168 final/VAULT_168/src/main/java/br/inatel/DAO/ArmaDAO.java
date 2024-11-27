package br.inatel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArmaDAO extends ConnetionDAO {

    public void inserirArma(int sobreviventeId, String nome, String tipo, int poder, String descricao, String estilo, String calibre) {
        connectToDb(); // Conecta ao banco
        String sql = "INSERT INTO armas (sobrevivente_id, nome, tipo, poder, descricao, estilo, calibre) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sobreviventeId);
            pst.setString(2, nome);
            pst.setString(3, tipo);
            pst.setInt(4, poder);
            pst.setString(5, descricao);

            if ("branca".equals(tipo)) {
                pst.setString(6, estilo);
                pst.setNull(7, Types.VARCHAR);
            } else if ("fogo".equals(tipo)) {
                pst.setNull(6, Types.VARCHAR);
                pst.setString(7, calibre);
            }

            pst.execute();
            System.out.println("Arma inserida com sucesso!");
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir arma: " + exc.getMessage());
        } finally {
            closeConnection();
        }
    }

    public List<String> listarArmasPorSobrevivente(int sobreviventeId) {
        connectToDb();
        String sql = "SELECT * FROM armas WHERE sobrevivente_id = ?";
        List<String> armas = new ArrayList<>();

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sobreviventeId);
            rs = pst.executeQuery();

            while (rs.next()) {
                String arma = "ID: " + rs.getInt("id") +
                        ", Nome: " + rs.getString("nome") +
                        ", Tipo: " + rs.getString("tipo") +
                        ", Poder: " + rs.getInt("poder") +
                        ", Descrição: " + rs.getString("descricao");

                if ("branca".equals(rs.getString("tipo"))) {
                    arma += ", Estilo: " + rs.getString("estilo");
                } else if ("fogo".equals(rs.getString("tipo"))) {
                    arma += ", Calibre: " + rs.getString("calibre");
                }

                armas.add(arma);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao listar armas: " + exc.getMessage());
        } finally {
            closeConnection();
        }
        return armas;
    }

    public void deletarArma(int armaId) {
        connectToDb();
        String sql = "DELETE FROM armas WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, armaId);
            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Arma deletada com sucesso!");
            } else {
                System.out.println("Nenhuma arma encontrada com o ID fornecido.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao deletar arma: " + exc.getMessage());
        } finally {
            closeConnection();
        }
    }

    public void atualizarArma(int armaId, String nome, String tipo, int poder, String descricao, String estilo, String calibre) {
        connectToDb();
        String sql = "UPDATE armas SET nome = ?, tipo = ?, poder = ?, descricao = ?, estilo = ?, calibre = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, tipo);
            pst.setInt(3, poder);
            pst.setString(4, descricao);

            if ("branca".equals(tipo)) {
                pst.setString(5, estilo);
                pst.setNull(6, Types.VARCHAR);
            } else if ("fogo".equals(tipo)) {
                pst.setNull(5, Types.VARCHAR);
                pst.setString(6, calibre);
            }

            pst.setInt(7, armaId);

            int linhasAfetadas = pst.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Arma atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma arma encontrada com o ID fornecido.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao atualizar arma: " + exc.getMessage());
        } finally {
            closeConnection();
        }
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