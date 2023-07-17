package com.ald.anime3000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Anime3000Application {

    public static void main(String[] args) {
        SpringApplication.run(Anime3000Application.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("senha123"));
    }

}
