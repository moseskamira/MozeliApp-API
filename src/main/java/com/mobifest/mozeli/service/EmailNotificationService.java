package com.mobifest.mozeli.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.mobifest.mozeli.models.Message;

@Service
public class EmailNotificationService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public SimpleMailMessage sendEmailMessage(Message emailMessage) {
		SimpleMailMessage myMessage = new SimpleMailMessage();
        myMessage.setTo(emailMessage.getTo());
        myMessage.setSubject(emailMessage.getSubject());
        myMessage.setText(emailMessage.getText());
        javaMailSender.send(myMessage);
        return myMessage;
	}

}
