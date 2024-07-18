package com.magalu.notificaion_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotificaionMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificaionMsApplication.class, args);
	}

}
