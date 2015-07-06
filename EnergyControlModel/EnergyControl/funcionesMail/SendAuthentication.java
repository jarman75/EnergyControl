package funcionesMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendAuthentication {
	
	private String From;
	private String To;
	private String Asunto;
	private String Texto;
	
	public SendAuthentication(String from, String to, String asunto,
			String texto) {
		super();
		From = from;
		To = to;
		Asunto = asunto;
		Texto = texto;
	}
	
	
	public boolean Send()
	{
		
		
		String host ="mail.energymarket.es";
			 


		//System.out.println ("Prueba para enviar un mail..." + new java.util.Date());

		Properties prop = new Properties();

		prop.put("mail.smtp.host", host); 
		prop.put("mail.smtp.port", 587);

		/*Esta línea es la que indica al API que debe autenticarse*/
		prop.put("mail.smtp.auth", "true");		


		/*Añadir esta linea si queremos ver una salida detallada del programa*/
		//prop.put("mail.debug", "true");

		try{

			SMTPAuthentication auth = new SMTPAuthentication(); 
			
			
			Session session = Session.getInstance(prop , auth ); 
			Message msg = getMessage(session, From, To, Asunto, Texto);			
			
			
			System.out.println ("Enviando ..." );
									
			Transport.send(msg);		
			
			
			System.out.println ("Mensaje enviado!");
			
			return true;

		}
		catch (Exception e)
		{
			ExceptionManager.ManageException(e);
			return false;
		}

	}

	private MimeMessage getMessage(Session session, String from, String to, String asunto, String texto) 
	{

		try{

			MimeMessage msg = new MimeMessage(session); 
			msg.setSubject(asunto);
			msg.setText(texto);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from,"Energy Control Alertas"));
			return msg;

		}

		catch (java.io.UnsupportedEncodingException ex)
		{

			ExceptionManager.ManageException(ex);
			return null;

		}

		catch (MessagingException ex)
		{

			ExceptionManager.ManageException(ex);
			return null;

		}

	}

}
	
	

