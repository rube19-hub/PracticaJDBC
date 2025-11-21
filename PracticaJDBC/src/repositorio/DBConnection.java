package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //nombre de la bd: practicajdbc
    private static final String URL = "jdbc:mysql://localhost:3306/practicajdbc?useSSl=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    private static Connection connection = null;

    private DBConnection(){

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Esta conectado");
            }catch (SQLException e){
                System.out.println("Error al conectar");
            }
        }
        return connection;
    }
    
    public static void closeConnection(){

        try {
            connection.close();
            System.out.println("Conexion cerrada");
        }catch (SQLException e){
            System.out.println("Error al cerrar la conexion");
        }
    }
}