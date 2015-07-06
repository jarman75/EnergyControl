package modelo;

public class SucesoUsuario {
	public SucesoUsuario(int idSuceso, int idUsuario, String medio) {
		super();
		IdSuceso = idSuceso;
		IdUsuario = idUsuario;
		Medio = medio;
	}
	
	protected int IdSuceso;
	protected int IdUsuario;
	protected String Medio;
	
	public int getIdSuceso() {
		return IdSuceso;
	}
	public void setIdSuceso(int idSuceso) {
		IdSuceso = idSuceso;
	}
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getMedio() {
		return Medio;
	}
	public void setMedio(String medio) {
		Medio = medio;
	}
	
	
	
}
