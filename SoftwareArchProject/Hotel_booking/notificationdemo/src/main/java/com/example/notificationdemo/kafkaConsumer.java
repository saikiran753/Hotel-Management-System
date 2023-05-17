package com.example.notificationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Component
public class kafkaConsumer {

    @Autowired
    private EmailSenderService senderService;

    String email;

    @KafkaListener(topics = "test-topic4", groupId = "consumer-notification-group")
    public void consume(String message){
        System.out.println(message);
        this.email = message;
        senderService.sendMail(this.email,"test","Your Hotel Is booked Successfully");
    }





}
