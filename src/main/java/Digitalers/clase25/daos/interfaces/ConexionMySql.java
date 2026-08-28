package Digitalers.clase25.daos.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConexionMySql {

    default Connection getConexion() {
        Connection conn = null;

        try {
            final String DRIVER = "";
            final String URL = "";
            final String USER = "";
            final String PASS = "";


            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
