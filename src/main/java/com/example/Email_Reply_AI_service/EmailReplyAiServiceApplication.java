package com.example.Email_Reply_AI_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableFeignClients
@CrossOrigin(origins = "http://localhost:5173")
public class EmailReplyAiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailReplyAiServiceApplication.class, args);
	}

}
