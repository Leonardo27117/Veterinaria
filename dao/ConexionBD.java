package veterinaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
    protected Connection conn;

    protected void cerrar(PreparedStatement stm) throws Exception {
        if (stm != null) {
            stm.close();
        }
    }

    protected void cerrar(ResultSet rst) throws Exception {
        if (rst != null) {
            rst.close();
        }
    }

    public ConexionBD() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "vet_user";
        String pass = "v3Ter1n4#$*";
        String basedatos = "VETERINARIA";
        String server = "jdbc:mysql://localhost/" + basedatos;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(server, user, pass);
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        }
    }
}