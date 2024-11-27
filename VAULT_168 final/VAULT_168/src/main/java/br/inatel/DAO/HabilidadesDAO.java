package br.inatel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabilidadesDAO extends ConnetionDAO {

    public void inserirHabilidade(int sobreviventeId, int forca, int percepcao, int resistencia, int carisma, int inteligencia, int agilidade, int sorte) {
        connectToDb(); // Conecta ao banco
        String sql = "INSERT INTO habilidades (sobrevivente_id, forca, percepcao, resistencia, carisma, inteligencia, agilidade, sorte) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sobreviventeId);
            pst.setInt(2, forca);
            pst.setInt(3, percepcao);
            pst.setInt(4, resistencia);
            pst.setInt(5, carisma);
            pst.setInt(6, inteligencia);
            pst.setInt(7, agilidade);
            pst.setInt(8, sorte);
            pst.execute();
            System.out.println("Habilidades inseridas com sucesso!");
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir habilidades: " + exc.getMessage());
        } finally {
            closeConnection();
        }
    }

    public List<String> listarHabilidadesPorSobrevivente(int sobreviventeId) {
        connectToDb();
        String sql = "SELECT * FROM habilidades WHERE sobrevivente_id = ?";
        List<String> habilidades = new ArrayList<>();

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sobreviventeId);
            rs = pst.executeQuery();

            while (rs.next()) {
                String habilidade = "ID: " + rs.getInt("id") +
                        ", Força: " + rs.getInt("forca") +
                        ", Percepção: " + rs.getInt("percepcao") +
                        ", Resistência: " + rs.getInt("resistencia") +
                        ", Carisma: " + rs.getInt("carisma") +
                        ", Inteligência: " + rs.getInt("inteligencia") +
                        ", Agilidade: " + rs.getInt("agilidade") +
                        ", Sorte: " + rs.getInt("sorte");
                habilidades.add(habilidade);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao listar habilidades: " + exc.getMessage());
        } finally {
            closeConnection();
        }
        return habilidades;
    }

    public void deletarHabilidade(int habilidadeId) {
        connectToDb();
        String sql = "DELETE FROM habilidades WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, habilidadeId);
            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Habilidade deletada com sucesso!");
            } else {
                System.out.println("Nenhuma habilidade encontrada com o ID fornecido.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao deletar habilidade: " + exc.getMessage());
        } finally {
            closeConnection();
        }
    }

    public void atualizarHabilidade(int habilidadeId, int forca, int percepcao, int resistencia, int carisma, int inteligencia, int agilidade, int sorte) {
        connectToDb();
        String sql = "UPDATE habilidades SET forca = ?, percepcao = ?, resistencia = ?, carisma = ?, inteligencia = ?, agilidade = ?, sorte = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, forca);
            pst.setInt(2, percepcao);
            pst.setInt(3, resistencia);
            pst.setInt(4, carisma);
            pst.setInt(5, inteligencia);
            pst.setInt(6, agilidade);
            pst.setInt(7, sorte);
            pst.setInt(8, habilidadeId);

            int linhasAfetadas = pst.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Habilidade atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma habilidade encontrada com o ID fornecido.");
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao atualizar habilidade: " + exc.getMessage());
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