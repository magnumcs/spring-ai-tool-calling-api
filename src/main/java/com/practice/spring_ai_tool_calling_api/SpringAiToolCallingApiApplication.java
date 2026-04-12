package com.practice.spring_ai_tool_calling_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringAiToolCallingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiToolCallingApiApplication.class, args);
	}

}
