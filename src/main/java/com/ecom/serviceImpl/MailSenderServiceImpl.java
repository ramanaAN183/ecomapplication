/**
 * 
 */
package com.ecom.serviceImpl;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.ecom.model.SendTextMailVm;
import com.ecom.service.MailSenderService;


/**
 * @author Rama Subbarao
 *
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {
	@Autowired
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	// for sending mails
	public void sendSimpleMail(SendTextMailVm mail) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("noreply@alpha-numero.com");
			message.setTo(mail.getTo());
			message.setSubject(mail.getSubject());
			message.setText(mail.getMessage());
			mailSender.send(message);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	@Override
	
		 public SendTextMailVm prepareMailObject(String message,String subject,String toMailId){
			 SendTextMailVm mailObj =new SendTextMailVm();
			 mailObj.setSubject(subject);
			 mailObj.setTo(toMailId);
			 mailObj.setMessage(message);
			 return mailObj;
		 }
	
	public void sendSimplemultipleMails(SendTextMailVm mail) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("noreply@alpha-numero.com");
			message.setTo(new String[] {
			mail.getTo(),"rambabu.g@alpha-numero.com"});
			message.setSubject(mail.getSubject());
			message.setText(mail.getMessage());
			mailSender.send(message);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void sendMailWithAttachment(File file ) {
		MimeMessage message = mailSender.createMimeMessage();
		 try{
			
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("noreply@alpha-numero.com");
		helper.setTo("rambabu.g@alpha-numero.com");
		
				helper.setSubject("Seller Product File");

		FileSystemResource filerecource = new FileSystemResource(file);
		helper.addAttachment(filerecource.getFilename(), filerecource);
		 helper.setText("", true);
		mailSender.send(message);
		  }catch (MessagingException e)
		 {
			 System.out.println(e.getMessage());
		 }
			     
		}

	
}
