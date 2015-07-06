package funcionesMail;

import javax.mail.PasswordAuthentication;

public class SMTPAuthentication extends javax.mail.Authenticator {

	public PasswordAuthentication getPasswordAuthentication()
		{

		String username = "soporte@energymarket.es";

		String password = "Dho29v2";

		return new PasswordAuthentication(username, password);

	}
}
