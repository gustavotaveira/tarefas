package br.com.home.dao;

import br.com.home.domain.Tarefa;
import br.com.home.domain.builder.TarefaBuilder;
import br.com.home.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class TarefaDao {

    private Connection connection;

    @Autowired
    public TarefaDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            return Collections.max(ids) + 1;
        } else {
            return 1;
        }
    }

    public List<Tarefa> obtenhaTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM TAREFAS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tarefas.add(
                        TarefaBuilder.novaTarefa()
                                .comId(resultSet.getInt("id"))
                                .comDescricao(resultSet.getString("descricao"))
                                .estaFinalizada(resultSet.getBoolean("finalizado"))
                                .comDataFinalizacao(ApplicationUtil.toDate(resultSet.getDate("datafinalizacao")))
                                .construir()
                );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.sort(tarefas);
        return tarefas;
    }

    public void remove(Integer id) {
        String sql = "DELETE FROM TAREFAS WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Tarefa recupere(Integer id) {
        String sql = "SELECT * FROM TAREFAS WHERE id = ?";
        Tarefa tarefa = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tarefa = TarefaBuilder.novaTarefa()
                        .comId(resultSet.getInt("id"))
                        .comDescricao(resultSet.getString("descricao"))
                        .estaFinalizada(resultSet.getBoolean("finalizado"))
                        .comDataFinalizacao(ApplicationUtil.toDate(resultSet.getDate("datafinalizacao")))
                        .construir();
            } else {
                tarefa = new Tarefa();
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefa;
    }

    public void altere(Tarefa tarefa) {
        String sql = "UPDATE TAREFAS SET descricao = ?, finalizado = ?, datafinalizacao = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tarefa.getDescricao());
            preparedStatement.setBoolean(2, tarefa.isFinalizado());
            preparedStatement.setDate(3, ApplicationUtil.toSqlDate(tarefa.getDatafinalizacao()));
            preparedStatement.setInt(4, tarefa.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void finalize(Integer id) {
        String sql = "UPDATE TAREFAS SET finalizado = ?, datafinalizacao = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setDate(2, ApplicationUtil.toSqlDate(new java.util.Date()));
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
