package modelo;

public abstract class Trama {
	
	protected String CUPS;
	protected String Dispositivo;
	
	public Trama() {
		CUPS="";
		Dispositivo="";
	}
	
	public String getCUPS() {
		return CUPS;
	}
	public void setCUPS(String cUPS) {
		CUPS = cUPS;
	}
	public String getDispositivo() {
		return Dispositivo;
	}
	public void setDispositivo(String dispositivo) {
		Dispositivo = dispositivo;
	}
	
	public abstract String Fields();
	public abstract String Values();
	public abstract void setTagXml(String Tag,String Valor);
	
}
