package com.william.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator {
    @Autowired
    private PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword1 = "admin123";
        String hashedPassword1 = encoder.encode(rawPassword1);

        String rawPassword2 = "user123";
        String hashedPassword2 = encoder.encode(rawPassword2);


        System.out.println(rawPassword1 + " :"+ hashedPassword1);
        System.out.println(rawPassword2 + " :"+ hashedPassword2);

    }
}
