package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    static String password;
    Scanner cr = new Scanner(System.in);
    public void Menu() throws SQLException, ClassNotFoundException {
        System.out.println("1-войти");
        System.out.println("2-Добавить");
        int result = cr.nextInt();
        if (result == 1) {
            System.out.println("Введите пароль: ");
            password = cr.next();
            DBconector.connect();
        }else if (result == 2){
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/my_login_db";
            String login = "postgres";
            String password = "admin";
            Connection connection = DriverManager.getConnection(url, login, password);
            System.out.println("Введите Id: ");
            int id = cr.nextInt();
            System.out.println("Введите Имя: ");
            String surname = cr.next();
            System.out.println("Введите логин: ");
            String log = cr.next();
            System.out.println("Введите пароль: ");
            String pas = cr.next();
            Users.insert(connection,id,surname,log,pas);
            System.out.println("Пользователь успешно добавлен");
        }
    }
}
