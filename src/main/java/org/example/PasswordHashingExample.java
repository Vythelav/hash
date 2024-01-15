package org.example;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHashingExample {
    Login login = new Login();

    MessageDigest md;

    {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    byte[] hash = md.digest(login.password.getBytes());
    String encodedHash = Base64.getEncoder().encodeToString(hash);
}
