package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection() {
    	final String jdbcUrl = "jdbc:mysql://localhost:3306/CSE284?useSSL=false&serverTimezone=UTC";
        final String username = "root"; 
        final String password = "quang@12345"; 
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
