package Digitalers.clase25.daos.interfaces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConexionMySql {

    default Connection getConexion() {
        Properties prop = new Properties();
        Connection conn = null;

        try {
            prop.load(new FileInputStream("src/main/resources/local-env.properties"));

            final String DRIVER = "";
            final String URL = prop.getProperty("db.url");
            final String USER = prop.getProperty("db.user");
            final String PASS = prop.getProperty("db.pass");

            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException  e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
