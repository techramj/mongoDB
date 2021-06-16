package com.email.emailsampledemo;

import com.email.emailsampledemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.internet.*;


import javax.mail.*;


import java.util.Properties;

@SpringBootApplication
public class EmailSampleDemoApplication implements CommandLineRunner {

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(EmailSampleDemoApplication.class, args);
    }

    @Override
    public void run(String... args)
    {
        emailService.sendMail(new String[]{"ram.jaiswal@accelya.com"}, "Test Mail1", "Test message.........");
        //emailService.sendPreConfiguredMail("Ho ho ho");
        try {
           // sendTestMail(null, null, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void sendTestMail(String from, String to, String body) throws MessagingException {
        Properties mailProps = new Properties();

        mailProps.put("mail.smtp.host", "ms1.accelya.com");
        mailProps.put("mail.smtp.port", "25");
        //mailProps.put("mail.smtps.socketFactory.fallback", "false");
        //mailProps.put("mail.smtps.socketFactory.port", "465");
        mailProps.put("mail.transport.protocol", "smtps");
        mailProps.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = getAuthenticator(mailProps);


        Session mailSession = Session.getDefaultInstance(mailProps, authenticator);
        mailSession.setDebug(false);

        Transport trnsPort = mailSession.getTransport();

        // create a message
        Message msg = new MimeMessage(mailSession);

        if(from ==null){
            msg.setFrom(new InternetAddress("mbs.admin@accelya.com"));
        }else{
            msg.setFrom(new InternetAddress(from));
        }

        InternetAddress[] addressTo = null;
        if(to != null){
            addressTo = InternetAddress.parse(to);
        }else {
            addressTo = InternetAddress.parse("ram.jaiswal@accelya.com");
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        msg.setSubject("Test message 2.....");

        MimeBodyPart messagePart = new MimeBodyPart();
        MimeMultipart multipart  = new MimeMultipart();


        // Setting the Email Encoding
        if(body == null){
            messagePart.setText("test message...........", "utf-8");
        }else{
            messagePart.setText(body, "utf-8");
        }

        messagePart.setHeader("Content-Type", "text/html; charset=\"utf-8\"");
        messagePart.setHeader("Content-Transfer-Encoding", "quoted-printable");

        multipart.addBodyPart(messagePart);

        msg.setContent(multipart);
        trnsPort.send(msg);

    }

    private Authenticator getAuthenticator(Properties mailProps) {
        Authenticator authenticator = null;
        // IF mail.smtp.auth is set to TRUE then create authenticator.

            mailProps.put("mail.smtp.auth", "true");
            authenticator = new Authenticator() {
                private PasswordAuthentication authentication;

                {
                    authentication = new PasswordAuthentication("mbs.admin@accelya.com", "accelya@123");
                }

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    if (authentication == null) {
                        return super.getPasswordAuthentication();
                    }
                    return authentication;
                }
            };
        return authenticator;

    }

}
