package com.evgueny.webshop.service;

import com.evgueny.webshop.model.Administrator;
import com.evgueny.webshop.model.User;
import com.evgueny.webshop.repository.AdministratorRepository;
import com.evgueny.webshop.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduledService {

    @Autowired
    private MailService mailService;
    @Autowired
    private UserRepositiry userRepositiry;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private InputOutputService inputOutputService;

    @Scheduled(cron = "0 0 20 * * SAN")
    public void ScheduledMailToAdmin() throws MessagingException, IOException {
        LocalDateTime dateTime = LocalDateTime.now().minusWeeks(1);
        ArrayList<User> allByDateTimeIsAfter = (ArrayList<User>) userRepositiry.findAllByDateTimeAfter(dateTime);
        List<Administrator> adminMail= (List<Administrator>) administratorRepository.findAll();
        String s = inputOutputService.writeToFileExel(allByDateTimeIsAfter);
        mailService.send(adminMail.get(0).getEmail(),"sizovzhenya1964@gmail.com","Новые клиенты","",s);
        String s1 = inputOutputService.writeToFileJson(allByDateTimeIsAfter);
        mailService.send(adminMail.get(0).getEmail(),"sizovzhenya1964@gmail.com","Новые клиенты","",s1);
    }

    @Scheduled(cron = "* * */50 * * *")
    public void ScheduledMailToClient() throws MessagingException {
        String s="Всем привет";
        ArrayList<User> userArrayList = (ArrayList<User>) userRepositiry.findAll();
        List<Administrator> adminMail= (List<Administrator>) administratorRepository.findAll();
        mailService.send1(adminMail.get(0).getEmail(),"sizovzhenya1964@gmail.com","srgaergreg",s);
    }
}
