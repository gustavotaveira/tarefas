package br.com.home.dao;

import br.com.home.domain.Usuario;
import br.com.home.infra.ConnectionDataBaseFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
    private Connection connection;

    public UsuarioDao() {
        this.connection = ConnectionDataBaseFactory.getPostgreSQLConnection();
    }

    public UsuarioDao(Connection connection) {
        this.connection = connection;
    }

    public void cadastreNovo(Usuario usuario) {
        String sql = "INSERT INTO USUARIOS(id, login, senha) VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tableMaxId() + 1);
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int tableMaxId() {
        int id = 1;
        String sql = "SELECT MAX(id) as id FROM USUARIOS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    public Boolean existeUsuario(Usuario usuario) {
        boolean existe = false;
        String sql = "SELECT * FROM USUARIOS WHERE login = ? AND senha = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                existe = true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }
}
