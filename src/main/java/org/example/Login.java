package org.example;

import java.util.Scanner;

public class Login {
    static String password;
    Scanner cr = new Scanner(System.in);
    public void Menu(){
        System.out.println("Введите пароль: ");
         password = cr.next();

//        String salt = BCrypt.gensalt();
        //String hashedPassword = BCrypt.hashpw(, salt);

        DBconector.connect();

    }

}
