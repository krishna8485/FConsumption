package com.swedBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.swedBank")
public class FuelConsumptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuelConsumptionApplication.class, args);
    }

}