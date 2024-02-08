package org.skylab.northwind;

import org.skylab.northwind.entities.concretes.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NorthwindApplication {

    public static void main(String[] args) {
        SpringApplication.run(NorthwindApplication.class, args);
    }
}
