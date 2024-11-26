package com.solarvalley.service.impl;

import com.solarvalley.entities.Mail;
import com.solarvalley.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    @Async
    public void sendEmail(Mail mail, JavaMailSender mailSender) {

        try {
            //create helper
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            //set values in helper
            helper.setFrom(mail.getMailFrom());
            helper.setTo(mail.getTo());
//        helper.setCc(mail.getCc());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getMessageBody(), true);
            mailSender.send(mimeMessage);
            LOGGER.info(String.format("Successfully email send to the user with email: %s", mail.getTo()));
        } catch (MessagingException e) {
            LOGGER.error("Error occurred while sending email to the user", e);
        }
    }

    private boolean isValid(Mail mail) {
        return mail != null &&
                (mail.getTo() != null || !mail.getTo().isEmpty()) ||
                (mail.getBcc() != null || !mail.getBcc().isEmpty());
    }
}
