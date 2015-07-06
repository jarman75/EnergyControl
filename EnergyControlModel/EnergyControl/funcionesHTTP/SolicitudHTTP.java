package funcionesHTTP;

import javax.xml.transform.stream.StreamResult;

//interface peticion HTTP
public interface SolicitudHTTP {
	static final String ipRemota="";
	final int puerto=80;
	final String ruta="";	
		
	public StreamResult Execute(String rutaFichero);		
	
	public java.net.URL getUrl();
	public int getPuerto();
	public void setPuerto(int puerto);
	public String getIpRemota();
	public void setIpRemota(String ipRemota);		
	public String getRuta();
	public void setRuta(String ruta);
	
}
