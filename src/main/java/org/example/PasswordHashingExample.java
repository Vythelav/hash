package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHashingExample {


public static void Vhod(){
    

    MessageDigest md;

    {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    byte[] hash = md.digest(Login.password.getBytes());
    String encodedHash = Base64.getEncoder().encodeToString(hash);
    System.out.println("Хэш-значение пароля: " + encodedHash);
}
}
