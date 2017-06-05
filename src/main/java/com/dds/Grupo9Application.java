package com.dds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dds"})
public class Grupo9Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo9Application.class, args);
	}
}
