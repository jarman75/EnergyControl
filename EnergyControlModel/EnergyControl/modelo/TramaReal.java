package modelo;

import java.util.Date;

public class TramaReal {

	
	private Date Fecha;
	private String Dispositivo;
	private String CUPS;
	private int VolumenMedido;
	private int VolumenNormalizado;
	private float Presion;
	private float Temperatura;
	private float CaudalVolMedido;
	private float CaudalVolNormalizado;
	private String Alarma;
	
	
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public int getVolumenMedido() {
		return VolumenMedido;
	}
	public void setVolumenMedido(int volumenMedido) {
		VolumenMedido = volumenMedido;
	}
	public int getVolumenNormalizado() {
		return VolumenNormalizado;
	}
	public void setVolumenNormalizado(int volumenNormalizado) {
		VolumenNormalizado = volumenNormalizado;
	}
	public float getPresion() {
		return Presion;
	}
	public void setPresion(float presion) {
		Presion = presion;
	}
	public float getTemperatura() {
		return Temperatura;
	}
	public void setTemperatura(float temperatura) {
		Temperatura = temperatura;
	}
	public float getCaudalVolMedido() {
		return CaudalVolMedido;
	}
	public void setCaudalVolMedido(float caudalVolMedido) {
		CaudalVolMedido = caudalVolMedido;
	}
	public float getCaudalVolNormalizado() {
		return CaudalVolNormalizado;
	}
	public void setCaudalVolNormalizado(float caudalVolNormalizado) {
		CaudalVolNormalizado = caudalVolNormalizado;
	}
	public String getAlarma() {
		return Alarma;
	}
	public void setAlarma(String alarma) {
		Alarma = alarma;
	}
	public String getDispositivo() {
		return Dispositivo;
	}
	public void setDispositivo(String dispositivo) {
		Dispositivo = dispositivo;
	}
	public String getCUPS() {
		return CUPS;
	}
	public void setCUPS(String cUPS) {
		CUPS = cUPS;
	}
	 
	
	
}
