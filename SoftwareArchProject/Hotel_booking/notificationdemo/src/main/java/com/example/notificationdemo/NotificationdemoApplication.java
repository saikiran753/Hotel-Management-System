package com.example.notificationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class NotificationdemoApplication {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(NotificationdemoApplication.class, args);
	}



//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail(){
//		senderService.sendMail("maharaja.engg444@gmail.com","test","here is my email test");
//	}

}
