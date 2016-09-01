package com.kishan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CrudspringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new CrudspringApplication()
				.configure(new SpringApplicationBuilder(CrudspringApplication.class))
				.run(args);
	}
}
