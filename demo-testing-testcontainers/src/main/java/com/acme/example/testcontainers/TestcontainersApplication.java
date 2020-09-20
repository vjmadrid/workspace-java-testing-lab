package com.acme.example.testcontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TestcontainersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestcontainersApplication.class, args);
	}

}
