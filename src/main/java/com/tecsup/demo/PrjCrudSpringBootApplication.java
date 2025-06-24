package com.tecsup.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PrjCrudSpringBootApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(PrjCrudSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String password = "56789";
        for (int i = 0; i < 2; i++) {
            String bcryptPassword = bCryptPasswordEncoder.encode(password);
            System.out.println(bcryptPassword);
        }
    }
}
