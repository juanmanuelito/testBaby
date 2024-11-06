package com.example.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListenerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.amqp.deserialization.trust.all", "true");
		SpringApplication.run(ListenerApplication.class, args);
	}

}
