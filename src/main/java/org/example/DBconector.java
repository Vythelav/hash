package org.example;

import java.sql.*;
public class DBconector {
    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/cars_db","postgres", "admin");
            //connection.close();
            System.out.println("Connection successed!");
            try {
                String request = "SELECT * FROM public.cars";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(request);
                while (resultSet.next()) {
                    String model = resultSet.getString("model");
                    String id = resultSet.getString("id");

                    System.out.println(model + " " + id);

                }
            }
            catch (SQLException exception) {
                System.out.println(exception);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
