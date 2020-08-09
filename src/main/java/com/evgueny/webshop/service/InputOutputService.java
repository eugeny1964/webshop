package com.evgueny.webshop.service;

import com.evgueny.webshop.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class InputOutputService {

    public String writeToFileExel(ArrayList<User> list) throws IOException {
        String ss="/home/gg/IdeaProjects/web-shop/src/main/resources/text/sendAdminExel.txt";
        FileWriter fileWriter=new FileWriter("/home/gg/IdeaProjects/web-shop/src/main/resources/text/sendAdminExel.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        for (int i = 0; i < list.size(); i++) {
            String s=String.valueOf(list.get(i).getId())+":"+String.valueOf(list.get(i).getLogin())+":"+String.valueOf(list.get(i).getDateTime())+":"+String.valueOf(list.get(i).getAddress()+"\n");
            bufferedWriter.write(s);
        }
        bufferedWriter.close();
        return ss;
    }
    public String writeToFileJson(ArrayList<User> list) throws IOException {
        String ss="/home/gg/IdeaProjects/web-shop/src/main/resources/text/sendAdminJson.txt";
        FileWriter fileWriter=new FileWriter("/home/gg/IdeaProjects/web-shop/src/main/resources/text/sendAdminJson.txt");
        ObjectMapper objectMapper=new ObjectMapper();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String s = objectMapper.writeValueAsString(user)+"\n";
            fileWriter.write(s);
        }
        fileWriter.close();
        return ss;
    }
}
