package com.conurets.hcm.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CommonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonsApplication.class, args);
	}

}
