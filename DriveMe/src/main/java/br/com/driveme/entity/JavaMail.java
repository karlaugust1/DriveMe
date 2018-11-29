package br.com.driveme.entity;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	
	private static final String emailRemetente = "";
	private static final String senhaRemetente = "";
		
	public void enviarEmail(String email) {
		Properties props = new Properties();
        /** Par�metros de conex�o com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication(emailRemetente, senhaRemetente);
                         }
                    });

        /** Ativa Debug para sess�o */
        //session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress(emailRemetente)); //Remetente

              Address[] toUser = InternetAddress //Destinat�rio(s)
                         .parse(email);  

              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject("Bem-vindo a ABC Auto Pe�as!");//Assunto
              message.setText("N�s da ABC Auto Pe�as, juntamente com o sistema DriveMe, agradecemos a confian�a e prezamos o seu gosto acima de tudo. Muito obrigado por se registrar!");
              /**M�todo para enviar a mensagem criada*/
              Transport.send(message);

              System.out.println("E-mail enviado para " + email);

         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
	}

}
