package com.company;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/shops";
        String username = "root";
        String password = "root!";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL server");
            String sql = "INSERT INTO contacts (first_name,last_name,email)"
                    +"VALUES('G' , 'S' , 'glsn_s30234562@mailggg.com')";

            Statement statement = connection.createStatement();
            int rows =  statement.executeUpdate(sql);
            if(rows > 0){
                System.out.println("New contact has been inserted");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }
}
