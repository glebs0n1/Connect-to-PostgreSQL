package com.company;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, URISyntaxException, IOException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Shop";
        String username = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            System.out.println("Connecting to PostgreSQL server");
            String sql = "SELECT * FROM contacts";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");

                System.out.printf("%d - %s - %s -%s\n", id, firstName, lastName, email);
            }
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }
    }
}
