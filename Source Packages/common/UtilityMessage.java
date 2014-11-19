/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Properties;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Imran
 */
public class UtilityMessage {
    

    public static void SendEmail(String toEmail,String Name,String pwd)
    { 
        
        
        final String username = "waa.mum@gmail.com";
        final String password = "mumwaa123";
        StringBuilder messageBody  = new StringBuilder(); 
       
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
 
  Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
    });
 
  try {
 
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress("waa.mum@gmail.com"));
   message.setRecipients(Message.RecipientType.TO,
    InternetAddress.parse(toEmail));
   message.setSubject("User Registration Confirmation");
   
 messageBody.append("Dear "+ Name+"\n\n");
 messageBody.append("Welcome to the Hiltion International. Your credential are following\n\n");
 messageBody.append("User Name: "+toEmail+" \n");
 messageBody.append("Password: "+pwd+"\n\n");
 messageBody.append("Please save this email these credintial are important for next login. Thanks for choosing our System\n\n");
 messageBody.append("This is automated email please don't reply it\n\n");
 messageBody.append("Best Regards\n");
 
 
 
   
   message.setText(messageBody.toString());
 
   Transport.send(message);
 
   System.out.println("Done");
 
  } catch (MessagingException e) {
   throw new RuntimeException(e);
  }
 }

    public static String generatePassword()
    {
    return UUID.randomUUID().toString().substring(0,7);
    }


    public static void SendPromotions(String toEmail,String name,String promtionCode,String Description)
    { 
        final String username = "waa.mum@gmail.com";
        final String password = "mumwaa123";
        StringBuilder messageBody  = new StringBuilder(); 
       
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
 
  Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
    });
 
  try {
 
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress("waa.mum@gmail.com"));
   message.setRecipients(Message.RecipientType.TO,
    InternetAddress.parse(toEmail));
   message.setSubject("Pomotional Email From Hiltion International");
   
 messageBody.append("Dear Customers \n\n");
 messageBody.append("This email send by Hiltion International . Good news for that we have some amazing promotion ");
 messageBody.append("Description of deails are as follows\n");
 messageBody.append(Description+"\n");
 messageBody.append("Below is your promotional code you can use this code for discount \n");
 
 messageBody.append("Promotional Code: "+promtionCode+"\n\n");
 messageBody.append("Thanks for selecting Hiltion International Hotel\n\n");
 messageBody.append("This is automated email please don't reply it\n\n");
 messageBody.append("Best Regards\n ");
 messageBody.append("Hilton Internation Hotel");
   
   message.setText(messageBody.toString());
 
   Transport.send(message);
 
   System.out.println("Done");
 
  } catch (MessagingException e) {
   throw new RuntimeException(e);
  }
 }
    
}
    
    

