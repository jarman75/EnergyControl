package funcionesHTTP;

import modelo.TipoMedida;

public class HTTPGasKroms extends HTTPGasEstandar {

	public HTTPGasKroms(String ipRemota, int puerto, TipoMedida tLectura,
			int idRemota) {		
		super(ipRemota, puerto, getDefaultPath()+getStringAccion(tLectura,idRemota));		
		this.setAccion(getStringAccion(tLectura,idRemota));
		this.setIdRemota(idRemota);							
		
	}
	
	protected static String getDefaultPath(){
		return "";
	}
	
	protected static String getStringAccion(TipoMedida lectura, int idRemota){
		String strAccion="";
		switch(lectura){		
		case ultDia:
			strAccion="xml_pending_dat.htc";
			break;
		case ultHora:
			strAccion="xml_pending_dat.htc";
			break;
		case ultTrama:
			strAccion="actual.xml";
			break;
		case historico:
			strAccion="xml_dat.htc";
		default:
			break;
		
		}
		return strAccion;
		
	}
	
	

	

	

	
	

	
	

}
