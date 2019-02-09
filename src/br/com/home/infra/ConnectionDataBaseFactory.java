package br.com.home.infra;

import java.sql.Connection;
import java.sql.DriverManager;

import static br.com.home.infra.enums.Databases.POSTGRESQL;

public class ConnectionDataBaseFactory {

    public static Connection getPostgreSQLConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(POSTGRESQL.getUri(), POSTGRESQL.getUsername(), POSTGRESQL.getPassword());
        } catch (Exception e) {
            String mensagem = String.format("%s%s\n%s", "ConnectionDatabaseFactory:getPostgreSQLConnection(): ",
                    e.getMessage(), "Um erro ocorreu na tentativa de obter uma conexao com o banco de dados.");
            throw new RuntimeException(mensagem);
        }
    }
}
