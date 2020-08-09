package com.evgueny.webshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String toAdres, String fromAdres, String subject, String content,String pathToAttachment) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(toAdres);
        mimeMessageHelper.setFrom(fromAdres);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content);
        FileSystemResource fileSystemResource=new FileSystemResource(new File(pathToAttachment));
        mimeMessageHelper.addAttachment("sendAdmi.txt",fileSystemResource);
        javaMailSender.send(mimeMessage);
    }
    public void send1(String toAdres, String fromAdres, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(toAdres);
        mimeMessageHelper.setFrom(fromAdres);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content);
        javaMailSender.send(mimeMessage);
    }
}
