package com.blackhole.fooddelivery.demo.services.implementations;

import com.blackhole.fooddelivery.demo.services.IMailService;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class MailServiceImpl implements IMailService {

    public void sendEmail(String toa, String subjecta, String contencta) {
        String to = toa;
        String from = "FoodInNoReply@gmail.com";
        final String username = "FoodInNoReply@gmail.com";
        final String password = "foodin123";
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subjecta);
            message.setContent(
                    contencta,
                    "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
