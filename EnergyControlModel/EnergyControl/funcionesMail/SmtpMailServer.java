package funcionesMail;

public class SmtpMailServer {

	public SmtpMailServer(String server, String user, String password,
			int puerto) {
		super();
		Server = server;
		User = user;
		Password = password;
		Puerto = puerto;
	}
	private String Server;
	private String User;
	private String Password;
	private int Puerto;
	public String getServer() {
		return Server;
	}
	public void setServer(String server) {
		Server = server;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getPuerto() {
		return Puerto;
	}
	public void setPuerto(int puerto) {
		Puerto = puerto;
	}
	
	
}
