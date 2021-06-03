package com.dbright;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PractiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractiveApplication.class, args);
    }

}
