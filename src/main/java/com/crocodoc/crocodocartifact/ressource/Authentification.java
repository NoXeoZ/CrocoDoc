package com.crocodoc.crocodocartifact.ressource;

import com.crocodoc.crocodocartifact.model.Profile;
import com.crocodoc.crocodocartifact.service.AuthentificationService;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/*
TODO : voir l'import -> j'ai package inconnu
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/
import java.util.*;

@RestController
public class Authentification {
    @Autowired
    private AuthentificationService authentificationService;

    private static Map<String,Profile> connexions=new HashMap<String,Profile>();

    public static Profile getProfile(String key) {
        if(connexions.containsKey(key)) {
            return connexions.get(key);
        }
        return null;
    }

    @RequestMapping(path = "/connect/{login}/{password}", method = RequestMethod.GET)
    public List<String> connect(@PathVariable String login, @PathVariable String password){
        try{
            UUID uuid = UUID.randomUUID();
            connexions.put(uuid.toString(),authentificationService.getProfile(login, password).get());
            List<String> infos=new ArrayList<String>();
            infos.add(uuid.toString());
            infos.add(getProfile(uuid.toString()).getFirstName());
            infos.add(getProfile(uuid.toString()).getLastName());
            return infos;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"wrong login and password");
        }
    }

    @GetMapping("/disconnect/{key}")
    public boolean disconnect(@PathVariable String key){
        if(connexions.containsKey(key)){
            connexions.remove(key);
        }
        return true;
    }

   // @PostMapping("/forgetpw/{mail}")
   /* public boolean forgotPassword(@PathVariable String mail){
        try{
            if(authentificationService.getProfileFromMail(mail).isPresent()){
                try {
                    String host = "localhost";
                    Properties properties = System.getProperties();
                    properties.setProperty("mail.smtp.host", host);
                    Session session = Session.getDefaultInstance(properties);
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("thomas.levee@gmail.com"));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
                    message.setSubject("Crocodoc: Retrieve your password");
                    message.setText("Click this link to retrieve your password");
                    Transport.send(message);
                    System.out.println("Sent message successfully....");

                    return true;
                } catch (MessagingException exception) {
                    exception.printStackTrace();
                    return true;
                }
            } else{
                return false;
            }
        }catch(NotFoundException e){
            return false;
        }
    }*/
}
