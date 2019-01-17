package com.kepka.databaseoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnection {

    public static Connection getOracleConnection() throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("Błąd! Brak dostępu");
        } catch (InstantiationException e) {
            System.out.println("Błąd! Problem podczas wczytywania");
        } catch (ClassNotFoundException e) {
            System.out.println("Błąd! Nie można załadować sterowników klasy");
            System.exit(3);
        }

        String URL = "jdbc:oracle:thin:@//155.158.112.45:1521/oltpstud";
        Properties info = new Properties();
        info.put("user", "ziibd21");
        info.put("password", "haslo2018");

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(URL,info);
        } catch (SQLException e) {
            System.out.println("Nie można połączyć się z bazą");
        }
        return connection;
    }
}
