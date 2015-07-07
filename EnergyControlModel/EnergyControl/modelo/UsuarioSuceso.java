package modelo;

public class UsuarioSuceso {
	
		
	public UsuarioSuceso(int idSuceso, String nombreUsuario,
			String medioNoticar, String email, int telefono, boolean porEmail, boolean porSMS) {
		super();
		IdSuceso = idSuceso;
		NombreUsuario = nombreUsuario;
		MedioNoticar = medioNoticar;  // no se usa, para nueva versión
		Email = email;
		Telefono = telefono;
		setPorEMail(porEmail);
		setPorSMS(porSMS);
	}
	private int IdSuceso;
	private String NombreUsuario;
	private String MedioNoticar;
	private String Email;
	private boolean PorEMail;
	private boolean PorSMS;
	
	public int getIdSuceso() {
		return IdSuceso;
	}
	public void setIdSuceso(int idSuceso) {
		IdSuceso = idSuceso;
	}
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}
	public String getMedioNoticar() {
		return MedioNoticar;
	}
	public void setMedioNoticar(String medioNoticar) {
		MedioNoticar = medioNoticar;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public boolean isPorEMail() {
		return PorEMail;
	}
	public void setPorEMail(boolean porEMail) {
		PorEMail = porEMail;
	}
	public boolean isPorSMS() {
		return PorSMS;
	}
	public void setPorSMS(boolean porSMS) {
		PorSMS = porSMS;
	}
	private int Telefono;
}
