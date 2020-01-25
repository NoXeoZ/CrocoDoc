package com.crocodoc.crocodocartifact.ressource;

import com.crocodoc.crocodocartifact.service.AuthentificationService;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.UUID;

public class Authentification {
    @Autowired
    private AuthentificationService authentificationService;

    private Map<String,Profile> connexions=new HashMap<String,Profile>();

    Profile getProfile(String key) {
        return connexions.get(key);
    }

    @RequestMapping(path = "/mno/objectKey/{login}/{password}", method = RequestMethod.GET)
    public String connect(@PathVariable String login, @PathVariable String password){
        try{
            UUID uuid = UUID.randomUUID();
            connexions.put(uuid.toString(),authentificationService.getProfile(login, password).get());
            return uuid.toString();
        }catch(NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"wrong login and password");
        }
    }

    public boolean disconnect(String key){
        if(connexions.contains(key)){
            connexions.remove(key);
        }
        return true;
    }

    public boolean forgotPassword(String mail){
        try{
            UUID uuid = UUID.randomUUID();
            if(authentificationService.getProfileFromMail(mail).isPresent()){
                try {
                    String host = "localhost";
                    Properties properties = System.getProperties();
                    properties.setProperty("mail.smtp.host", host);
                    Session session = Session.getDefaultInstance(properties);
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("test@test.com"));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
                    message.setSubject("Crocodoc: Retrieve your password");
                    message.setText("Click this link to retrieve your password");
                    Transport.send(message);
                    System.out.println("Sent message successfully....");

                    return true;
                } catch (MessagingException exception) {
                    return false;
                }
            } else{
                return false;
            }
        }catch(NotFoundException e){
            return false;
        }
    }
}
