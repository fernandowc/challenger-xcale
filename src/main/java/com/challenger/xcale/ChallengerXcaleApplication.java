package com.challenger.xcale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ChallengerXcaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengerXcaleApplication.class, args);
    }

}
