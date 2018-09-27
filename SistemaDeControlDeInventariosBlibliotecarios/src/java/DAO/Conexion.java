
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    static String database = "sistema_de_control_de_biblioteca";
    static String login = "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost/sistema_de_control_de_biblioteca";
    Connection conn = null;

    public Conexion() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                System.out.println("Connexión a base de datos " + database + " exitosa.");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos " + database + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conn;
    }

    public void desconectar() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al finalizar la operación.");
            }
        }
    }
    
    

    
}
