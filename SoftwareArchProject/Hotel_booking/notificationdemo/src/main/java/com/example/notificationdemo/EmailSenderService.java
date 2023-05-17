package com.example.notificationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

  @Autowired
  private JavaMailSender javaMailSender;

  public EmailSenderService(JavaMailSender javaMailSender){
    this.javaMailSender = javaMailSender;
  }

  public void sendMail(String toEmail, String subject, String body){

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("raja.engg444@gmail.com");
    message.setTo(toEmail);
    message.setSubject(subject);
    message.setText(body);

    this.javaMailSender.send(message);

    System.out.println("mail sent succeessfully");

  }
}
