package happyToken;
 
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailTLS {
	//found on the internet, modified to throw specific exception.
 
	public static void mail() throws MessagingException {
 
		final String username = "AKIAJPUONETKTELBXHDA";
		final String password = "AmnfeoX7p4oiURAQVJ4sRH78smHue1ClxqLYIyjGFGOY";
 
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
 
		// try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("asshole@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("ryan.figg@gmail.com"));
			message.setSubject("Email test");
			message.setText("Yay! My tokens are happy!!");
 
			Transport.send(message);
 
			System.out.println("Email sent!");
 
		// } catch (MessagingException e) {
		// 	throw new RuntimeException(e);
		// }
	}
}