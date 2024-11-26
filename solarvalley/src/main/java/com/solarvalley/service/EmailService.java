package com.solarvalley.service;


import com.solarvalley.entities.Mail;
import org.springframework.mail.javamail.JavaMailSender;

public interface EmailService {

    void sendEmail(Mail mail, JavaMailSender mailSender);
}
