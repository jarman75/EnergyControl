package modelo;

public class UsuarioSuceso {
	
		
	public UsuarioSuceso(int idSuceso, String nombreUsuario,
			String medioNoticar, String email, int telefono) {
		super();
		IdSuceso = idSuceso;
		NombreUsuario = nombreUsuario;
		MedioNoticar = medioNoticar;
		Email = email;
		Telefono = telefono;
	}
	private int IdSuceso;
	private String NombreUsuario;
	private String MedioNoticar;
	private String Email;
	
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
	private int Telefono;
}
