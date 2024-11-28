package com.ericklemos.tetoverde.Services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
    private static final String HOST = "smtp.gmail.com"; // Servidor SMTP
    private static final String PORT = "587"; // Porta SMTP
    private static final String USERNAME = "vonphyther@gmail.com";
    private static final String PASSWORD = "qyyn btai aldh iciz";

    public static void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        // Configurar propriedades do servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(USERNAME));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);
        message.setText(body);

        // Enviar e-mail
        Transport.send(message);
    }
}
