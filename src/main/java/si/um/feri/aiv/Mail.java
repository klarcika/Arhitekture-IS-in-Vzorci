package si.um.feri.aiv;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;
import jakarta.ejb.Stateless;

@Stateless
public class Mail {

        public static void send(String toPerson, String subject, String body){
            try{
                Properties properties = new Properties();
//                properties.put("mail.smpt.auth","true");
//                properties.put("mail.smpt.starttls.enable", "true");
                properties.put("mail.smpt.host", "localhost");
                properties.put("mail.smpt.port", "59131");

                Session session = Session.getDefaultInstance(properties);
               // Session session = (Session) new InitialContext().lookup("java:jboss/mail/HelloKitty");

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("noviMail@hello.kitty"));

                //Address toPersonAdress = new InternetAddress(toPerson);
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(toPerson));
                message.setSubject(subject);
                message.setContent(body, "text/plain");

                Transport.send(message);
                System.out.println("Mail uspesno poslan");
            } catch (Exception e){
                e.printStackTrace();
            }

//                    String from = "klara.kibis@student.um.si";
//                    String to = "klara.kibis@student.um.si";
//                    String  subject = "Test email";
//                    String body = "This is a test email sent from Wildfly.";
//
//                    try {
//                        // Set mail properties
//                        Properties properties = System.getProperties();
//                        properties.setProperty("mail.smtp.host", "localhost");
//                        properties.setProperty("mail.smtp.port", "59131");
//
//                         Get the default Session object
//                        Session session = Session.getDefaultInstance(properties);
//
//                        // Create a new email message
//                        MimeMessage message = new MimeMessage(session);
//                        message.setFrom(new InternetAddress(from));
//                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//                        message.setSubject(subject);
//                        message.setText(body);
//
//                        // Send the email message
//                        Transport.send(message);
//                        System.out.println("Email sent successfully.");
//
//                    } catch (MessagingException mex) {
//                        mex.printStackTrace();
//                    }
                }
            }

