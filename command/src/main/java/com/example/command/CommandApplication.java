package com.example.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandApplication.class, args);
	}

}
