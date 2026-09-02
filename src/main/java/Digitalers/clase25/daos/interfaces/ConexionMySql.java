package Digitalers.clase25.daos.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConexionMySql {

    default Connection getConexion() {
        Connection conn = null;

        try {
            final String DRIVER = "";
            final String URL = "jdbc:mysql://localhost:3306/universidad";
            final String USER = "root";
            final String PASS = "";

            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
