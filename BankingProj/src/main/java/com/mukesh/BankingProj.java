package com.mukesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mukesh
 *
 */
@SpringBootApplication


//@EnableJpaRepositories(basePackages = "com.mukesh.repository")
public class BankingProj {

    public static void main(String[] args) {
        SpringApplication.run(BankingProj.class, args);
    }
}
