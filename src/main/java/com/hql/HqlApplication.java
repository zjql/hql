package com.hql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(HqlApplication.class, args);
    }

}
