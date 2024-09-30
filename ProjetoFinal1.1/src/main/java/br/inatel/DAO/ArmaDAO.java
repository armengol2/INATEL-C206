package br.inatel.DAO;

import br.inatel.Model.Arma; // Certifique-se de que a classe se chama Arma
import java.sql.SQLException;
import java.util.ArrayList;

public class ArmaDAO extends ConnectionDAO {

    public boolean insertArma(Arma arma) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO arma (nome, estilo, descricao, ataque) VALUES (?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, arma.getNome());
            pst.setString(2, arma.getEstilo());
            pst.setString(3, arma.getDescricao());
            pst.setInt(4, arma.getAtaque());
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            closeConnection();
        }
        return sucesso;
    }

    public boolean updateArma(int id, Arma arma) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE arma SET nome = ?, estilo = ?, descricao = ?, ataque = ? WHERE idArma = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, arma.getNome());
            pst.setString(2, arma.getEstilo());
            pst.setString(3, arma.getDescricao());
            pst.setInt(4, arma.getAtaque());
            pst.setInt(5, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            closeConnection();
        }
        return sucesso;
    }

    public boolean deleteArma(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM arma WHERE idArma = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            closeConnection();
        }
        return sucesso;
    }

    public ArrayList<Arma> selectArma() {
        connectToDb();

        ArrayList<Arma> armas = new ArrayList<>();
        String sql = "SELECT * FROM arma";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de armas:");
            while (rs.next()) {
                Arma armaAux = new Arma(
                        rs.getInt("idArma"),
                        rs.getString("nome"),
                        rs.getString("estilo"),
                        rs.getString("descricao"),
                        rs.getInt("ataque")
                );
                armas.add(armaAux);
                System.out.println("Nome: " + armaAux.getNome() + " Estilo: " + armaAux.getEstilo());
                System.out.println("--------------------");
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            closeConnection();
        }
        return armas;
    }
}