package com.jp.services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.jp.exceptions.OnlineBankingException;

@Service("email_service")
public class EmailServiceImpl implements IOnlineBankingEmailService{
	
	public boolean sendCustomerRegistrationEmail(String customerEmailId, Integer loginId, String password) throws OnlineBankingException {
	
	boolean emailSentFlag=false;
	final String username="onbprojectgroup2@gmail.com";
	final String passowrd="Jpmc123*";
	
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	
	Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, passowrd);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("onbprojectgroup2@gmail.com")); // same email id
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(customerEmailId));// whome u have to send mails that person id
				
				message.setSubject("OnlineBank - Customer Welcome Kit");
				message.setText("Dear Customer,"
					+ "\n\n Welcome to Online Bank, Thank You for chosing our bank!"
					+ "\n\n Below mentioned is your Login Id and Password to access your Online NetBanking"
					+ "\n\n Login ID: "+loginId
					+ "\n\n Password: "+password
					+ "\n\n"
					+ "\n\n"
					+ "\n\n Please do not share these details with anyone."
					+ "\n\n"
					+ "\n\n"
					+ "\n\n"
					+ "\n\n Regards,"
					+ "\n\n OnlineBank Support Team"										
					);

				Transport.send(message);
				
				emailSentFlag=true;
				
			} catch (MessagingException e) {
				
				throw new OnlineBankingException("Sending Email to Customer Failed");
				
			}finally {
				
				return emailSentFlag;
				
			}
			
			
	}
	

}
