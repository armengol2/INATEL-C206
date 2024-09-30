package br.inatel.DAO;

import br.inatel.Model.Sobrevivente;
import java.sql.SQLException;
import java.util.ArrayList;

public class SobreviventeDAO extends ConnectionDAO {

    public boolean insertSobrevivente(Sobrevivente sobrevivente) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO sobrevivente (nome, descricao, idade, forca, resistencia, agilidade, inteligencia, nivelDeHabilidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sobrevivente.getNome());
            pst.setString(2, sobrevivente.getDescricao());
            pst.setInt(3, sobrevivente.getIdade());
            pst.setInt(4, sobrevivente.getForca());
            pst.setInt(5, sobrevivente.getResistencia());
            pst.setInt(6, sobrevivente.getAgilidade());
            pst.setInt(7, sobrevivente.getInteligencia());
            pst.setInt(8, sobrevivente.getNivelDeHabilidade());
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

    public boolean updateSobrevivente(int id, Sobrevivente sobrevivente) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE sobrevivente SET nome = ?, descricao = ?, idade = ?, forca = ?, resistencia = ?, agilidade = ?, inteligencia = ?, nivelDeHabilidade = ? WHERE idSobrevivente = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sobrevivente.getNome());
            pst.setString(2, sobrevivente.getDescricao());
            pst.setInt(3, sobrevivente.getIdade());
            pst.setInt(4, sobrevivente.getForca());
            pst.setInt(5, sobrevivente.getResistencia());
            pst.setInt(6, sobrevivente.getAgilidade());
            pst.setInt(7, sobrevivente.getInteligencia());
            pst.setInt(8, sobrevivente.getNivelDeHabilidade());
            pst.setInt(9, id);
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

    public boolean deleteSobrevivente(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM sobrevivente WHERE idSobrevivente = ?";
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

    public ArrayList<Sobrevivente> selectSobrevivente() {
        connectToDb();

        ArrayList<Sobrevivente> sobreviventes = new ArrayList<>();
        String sql = "SELECT * FROM sobrevivente";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de sobreviventes:");
            while (rs.next()) {
                Sobrevivente sobreviventeAux = new Sobrevivente(
                        rs.getInt("idSobrevivente"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("idade"),
                        rs.getInt("forca"),
                        rs.getInt("resistencia"),
                        rs.getInt("agilidade"),
                        rs.getInt("inteligencia"),
                        rs.getInt("nivelDeHabilidade")
                );
                sobreviventes.add(sobreviventeAux);
                System.out.println("Nome: " + sobreviventeAux.getNome() + " Descrição: " + sobreviventeAux.getDescricao());
                System.out.println("--------------------");
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            closeConnection();
        }
        return sobreviventes;
    }
}