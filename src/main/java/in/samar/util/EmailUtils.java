package in.samar.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mail;
	
	public String sendmail(String to,String subject , String body,File f) {
		
		String send="not Sent";
		
		try {

			MimeMessage mmsg = mail.createMimeMessage();
			MimeMessageHelper helper =new MimeMessageHelper(mmsg,true);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);
			helper.addAttachment("Reports-Info", f);
			
			mail.send(mmsg);
			
			send="mail sent";
			
		} catch (Exception e) {
			send="Not Sent";
			e.printStackTrace();
		}
		
		
		
		return send;
	}

}
