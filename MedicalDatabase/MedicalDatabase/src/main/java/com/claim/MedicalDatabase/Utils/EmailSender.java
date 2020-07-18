package com.claim.MedicalDatabase.Utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.claim.MedicalDatabase.model.Users;
import com.claim.MedicalDatabase.repository.PatientRepository;


@Component
public class EmailSender {

	private PatientRepository patientRepository;
	
	public void sendMail(String to, String msg, String subject) {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("mail.host.com");
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setTo(to);
			helper.setText(msg);
			helper.setSubject(subject);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@ModelAttribute("user")
	Users user() {
		return new Users();
	}
}
