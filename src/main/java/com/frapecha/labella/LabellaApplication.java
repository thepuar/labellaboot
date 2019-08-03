package com.frapecha.labella;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages="com.frapecha.labella")
@EntityScan("com.frapecha.labella.model")
@ComponentScan(basePackages="com.frapecha.labella")
@EnableAutoConfiguration
public class LabellaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabellaApplication.class, args);
	}

	
}
