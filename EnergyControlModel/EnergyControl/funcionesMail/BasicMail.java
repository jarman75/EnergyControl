package funcionesMail;

public class BasicMail {
	public BasicMail(String mailOrigen, String mailDestino, String asunto,
			String cuerpo) {
		super();
		MailOrigen = mailOrigen;
		MailDestino = mailDestino;
		Asunto = asunto;
		Cuerpo = cuerpo;
	}
	
	private String MailOrigen;	
	private String MailDestino;	
	private String Asunto;
	private String Cuerpo;
	
	public String getMailOrigen() {
		return MailOrigen;
	}
	public void setMailOrigen(String mailOrigen) {
		this.MailOrigen = mailOrigen;
	}
	public String getMailDestino() {
		return MailDestino;
	}
	public void setMailDestino(String mailDestino) {
		this.MailDestino = mailDestino;
	}
	public String getAsunto() {
		return Asunto;
	}
	public void setAsunto(String asunto) {
		Asunto = asunto;
	}
	public String getCuerpo() {
		return Cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		Cuerpo = cuerpo;
	}
	
	
	
}
