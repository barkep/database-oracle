package com.kepka.databaseoracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String selectTableSQL = " SELECT * FROM EMPLOYEES";

        Statement statement = null;

        try {
            Connection connection = OracleConnection.getOracleConnection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String field = rs.getString("EMAIL");

                System.out.println("pole : " + rs.getString("EMPLOYEE_ID") + " " + field);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
