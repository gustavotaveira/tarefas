package br.com.home;

import br.com.home.domain.Tarefa;
import br.com.home.infra.ConnectionDataBaseFactory;
import br.com.home.util.ApplicationUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarefaDao {
    private Connection connection;

    public TarefaDao() {
        connection = ConnectionDataBaseFactory.getPostgreSQLConnection();
    }

    public TarefaDao(Connection connection) {
        this.connection = connection;
    }

    public void adicione(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas(id, descricao, finalizado, datafinalizacao) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, recupereMaiorValorId());
            preparedStatement.setString(2, tarefa.getDescricao());
            preparedStatement.setBoolean(3, tarefa.isFinalizado());
            preparedStatement.setDate(4, ApplicationUtil.toSqlDate(tarefa.getDatafinalizacao()));
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int recupereMaiorValorId() throws SQLException {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT id FROM tarefas";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ids.add(resultSet.getInt("id"));
        }
        if (!ids.isEmpty()) {
            return Collections.max(ids);
        } else {
            return 1;
        }
    }
}
