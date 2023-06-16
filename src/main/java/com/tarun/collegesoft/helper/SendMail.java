package com.tarun.collegesoft.helper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tarun.collegesoft.dto.Student;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class SendMail {

    @Autowired
	JavaMailSender mailSender;

	@Autowired
	Configuration configuration;

	public void send(Student student) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setFrom("yarisingutarun@gmail.com");
			helper.setTo(student.getEmail());
			helper.setSubject("Login");
			helper.setText("<h1>Hii yarisingu Tarun</h1>",true);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public String getEmailContent(Student student) {
			StringWriter writer = new StringWriter();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("merchant", student);
			try {
				configuration.getTemplate("Merchant-email-template.ftl").process(model, writer);
			} catch (TemplateException | IOException e) {
				e.printStackTrace();
			}
			return writer.getBuffer().toString();
	}
    
}
