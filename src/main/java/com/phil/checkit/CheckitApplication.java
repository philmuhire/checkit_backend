package com.phil.checkit;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class CheckitApplication {


    public static void main(String[] args) {
        SpringApplication.run(CheckitApplication.class, args);
    }

    @Bean
    CommandLineRunner run(){
        return args -> {

        }
    }

}
