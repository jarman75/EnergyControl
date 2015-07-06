package funcionesHTTP;
import modelo.TipoMedida;
import java.net.*;

public class HTTPGasEstandar extends HTTPGenerico {		
	
	
	public HTTPGasEstandar(String ipRemota, int puerto, String ruta) {
		super(ipRemota, puerto, ruta);		
	}
	
	public HTTPGasEstandar(String ipRemota, int puerto, TipoMedida tLectura, int idRemota){	
		super(ipRemota, puerto, getDefaultPath()+getStringAccion(tLectura,idRemota));		
		this.setAccion(getStringAccion(tLectura,idRemota));
		this.setIdRemota(idRemota);								
	}	
	
	protected static String getDefaultPath(){
		return "GetGas/servicioLecturas.slrc?ac=";
	}
	protected static String getStringAccion(TipoMedida lectura, int idRemota){
		String strAccion="";
		switch(lectura){
		case diaCurso:
			strAccion="diaria_encurso&um="+idRemota;
			break;
		case horaCurso:
			strAccion="horaria_encurso&um="+idRemota;
			break;
		case ultDia:
			strAccion="ultima_diaria&um="+idRemota;
			break;
		case ultHora:
			strAccion="ultima_horaria&um="+idRemota;
			break;
		case ultTrama:
			strAccion="ultima_trama&um="+idRemota;
			break;
		case historico:
			strAccion="exportacion.xml&um="+idRemota;
			break;
		default:
			break;
		
		}
		return strAccion;
		
	}
	private String accion;
	private int idRemota=0;	
	
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public int getIdRemota() {
		return idRemota;
	}
	public void setIdRemota(int idRemota) {
		this.idRemota = idRemota;
	}
	
	
	
	public java.net.URL getUrl() {		
		
		URI uriPeticion;
		try {
			uriPeticion = new URI("http://" + this.ipRemota + ":" + this.puerto + "/" + this.ruta);
			java.net.URL auxURL = uriPeticion.toURL();
			return auxURL;
		} catch (URISyntaxException e) {			
			e.printStackTrace();
			return null;
		} catch (MalformedURLException e) {			
			e.printStackTrace();
			return null;
		}	
			
	}

	
	
	
	
		
}
