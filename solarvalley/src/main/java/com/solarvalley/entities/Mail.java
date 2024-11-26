package com.solarvalley.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Mail {

    private String mailFrom;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String messageBody;
    private String replyTo;

    public Mail(){
        //username will be set
    }

    public Mail(String fromMail, String toMail, String subject, String body) {
        this.mailFrom = fromMail;
        this.to = toMail;
        this.subject = subject;
        this.messageBody = body;
    }
}
