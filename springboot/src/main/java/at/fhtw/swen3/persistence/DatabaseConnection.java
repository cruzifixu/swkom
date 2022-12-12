package at.fhtw.swen3.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection conn;
    private final String dbUrl;
    private final String dbUsername;
    private final String dbPassword;


    public DatabaseConnection() {
        dbUrl = ConfigurationManager.getConfigProperty("spring.datasource.url");
        dbUsername = ConfigurationManager.getConfigProperty("spring.datasource.username");
        dbPassword = ConfigurationManager.getConfigProperty("spring.datasource.password");
    }


    public Connection createConnection() throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        return conn;
    }
}
