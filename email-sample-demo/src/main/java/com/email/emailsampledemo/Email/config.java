package com.email.emailsampledemo.Email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class config {

    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("ram.jaiswal@accelya.com");
        message.setFrom("mbs.admin@accelya.com");
        message.setSubject("Test email");
        message.setText("FATAL - Application crash. Save your job !!");
        return message;
    }

}
