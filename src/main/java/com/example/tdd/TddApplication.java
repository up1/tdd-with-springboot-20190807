package com.example.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TddApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context 
		=  SpringApplication.run(TddApplication.class, args);
		
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
            System.out.println(bean);
        }
		System.out.println("==>" + context.getBeanDefinitionCount());
		//mvnw spring-boot:run
	}

}
