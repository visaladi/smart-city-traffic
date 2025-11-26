package com.example.smart_city_traffic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // enables @Scheduled in the app
public class SmartCityTrafficApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCityTrafficApplication.class, args);
    }
}
