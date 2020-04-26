package com.czetsuya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class JpaTransactionTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTransactionTestApplication.class, args);
	}

}
