package modelo;

public class Dispositivo {
	private String Nombre;
	private String CUPS;
	private String IP;
	private int Puerto;
	private String TipoSoftware;
	
	public Dispositivo(String nombre,String cups,String ip,int puerto,String tipoSoftware){
		this.setNombre(nombre);
		this.setCUPS(cups);
		this.setIP(ip);
		this.setPuerto(puerto);
		this.setTipoSoftware(tipoSoftware);
	}
	
	

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCUPS() {
		return CUPS;
	}
	public void setCUPS(String cUPS) {
		CUPS = cUPS;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getPuerto() {
		return Puerto;
	}
	public void setPuerto(int puerto) {
		Puerto = puerto;
	}
	public String getTipoSoftware() {
		return TipoSoftware;
	}
	public void setTipoSoftware(String tipoSoftware) {
		TipoSoftware = tipoSoftware;
	}
	
	
}
