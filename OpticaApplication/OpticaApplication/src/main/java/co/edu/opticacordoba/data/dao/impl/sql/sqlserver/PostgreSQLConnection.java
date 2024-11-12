package co.edu.opticacordoba.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {

	private static final String url = "jdbc:postgresql://localhost:5432/OpticaDOO";
    private static final String user = "postgres";
    private static final String password = "musical2";
    
    // Variable estática para la única instancia
    private static Connection connection = null;

    // Constructor privado para evitar instanciación
    private PostgreSQLConnection() {}

    // Método para obtener la única instancia de la conexión
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
        }
        return connection;
    }
    
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Conexión cerrada.");
        }
    }

}
