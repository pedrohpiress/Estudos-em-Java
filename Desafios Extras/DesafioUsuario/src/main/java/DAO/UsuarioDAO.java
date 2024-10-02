package DAO;

import Connection.Conexao;
import tabelas.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void insertUsuario(Usuario usuario){
        String sql = "INSERT INTO Usuario (idUsuario, nome, cpf, telefone, dtNasc, email, cep) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getCpf());
            ps.setString(4, usuario.getTelefone());
            ps.setDate(5, usuario.getDtNasc());
            ps.setString(6, usuario.getEmail());
            ps.setString(7, usuario.getCep());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectUsuario(Usuario usuario){
        String sql = "SELECT * FROM Usuario";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("--------------------------");
                System.out.println("ID: " + rs.getInt("idUsuario"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("CEP: " + rs.getString("cep"));
                System.out.println("Data de nascimento: " + rs.getDate("dtNasc"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("--------------------------");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
