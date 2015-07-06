package modelo;

public class Usuario {
	
	
	public Usuario(int id, String nombre, String password, String tipo,
			int telefono, String email) {
		super();
		Id = id;
		Nombre = nombre;
		Password = password;
		Tipo = tipo;
		Telefono = telefono;
		Email = email;
	}
	
	protected int Id;
	protected String Nombre;
	protected String Password;	
	protected String Tipo;
	protected int Telefono;
	protected String Email;
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
