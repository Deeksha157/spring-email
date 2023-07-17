package com.makam.springemail.controller;

import com.makam.springemail.model.Mail;
import com.makam.springemail.service.MailService;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MailController {

    private final MailService mailService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MailController.class);

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/sendmail")
    public Map<String,String> sendSimpleMail(@RequestBody Mail mail) {

        Map<String,String> response = new HashMap<>();

        mailService.sendEmail(mail);
        LOGGER.info("Mail message: " + mail.getString());

        response.put("message", "Email successfully sent");
        return response;
    }

    @PostMapping("/mime-mail")
    public Map<String,String> sendMimeMail(@RequestBody Mail mail) {

        Map<String,String> response = new HashMap<>();

        try {
            mailService.sendMimeEmail(mail);
            LOGGER.info("MIME Email message: " + mail.getString());
            response.put("message", "Email successfully sent");
            return response;
        }
        catch(MessagingException e) {
            LOGGER.error(e.getMessage());
            e.getStackTrace();
            response.put("message", "Email could not be sent");
            return response;
        }
    }
}

