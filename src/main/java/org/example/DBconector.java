package org.example;

import java.sql.*;
public class DBconector {
    public static boolean checkPassword(String dbPassword) {
        if(dbPassword.equals(Login.password)) {
            System.out.println("Верный пароль!");
            PasswordHashingExample.Vhod();
            return true;
        }else {
            System.out.println("Пароль не верный!");
        }
        return false;
    }

    public static void connect() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/my_login_db","postgres", "admin");
            //connection.close();
            System.out.println("Connection successed!");
            try {
                String request = "SELECT password FROM users";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(request);
                String dbPassword;
                while (resultSet.next()) {
                    dbPassword = resultSet.getString("password");
                    checkPassword(dbPassword);

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
