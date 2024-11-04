package co.edu.opticacordoba.helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://IP_DE_TU_SERVIDOR:1433;databaseName=NombreBaseDatos;";
        String user = "tu_usuario";
        String password = "tu_contraseña";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Realizar operaciones en la base de datos
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}