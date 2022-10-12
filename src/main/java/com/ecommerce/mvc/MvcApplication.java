package com.ecommerce.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MvcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

}
