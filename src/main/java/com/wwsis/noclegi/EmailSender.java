package com.wwsis.noclegi;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(String to, String title, String contents) throws MessagingException {

        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper mailsend = new MimeMessageHelper(mail, true);
        mailsend.setTo(to);
        mailsend.setReplyTo(to);
        mailsend.setFrom("pai.wyklad.lab@gmail.com");
        mailsend.setSubject(title);
        mailsend.setText(contents);

        javaMailSender.send(mail);
    }
}
