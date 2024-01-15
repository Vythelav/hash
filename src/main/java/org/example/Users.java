package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Users {
    int id;
    String surname;
    String login;
    String password;
    public static void insert(Connection con, int id ,String surname, String login, String password) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO users (id, surname, login, password) VALUES (?, ?, ?, ?)");
        stmt.setInt(1, id);
        stmt.setString(2, surname);
        stmt.setString(3, login);
        stmt.setString(4, password);
        stmt.executeUpdate();
        stmt.close();
    }
}
