package modelo;

import java.util.Date;



public class TramaHoraria extends Trama{
	
	public TramaHoraria(Date fecha, int volumenMedido, int volumenNormalizado,
			float presion, float temperatura, float caudalVolMedido,
			float caudalVolNormalizado, float incVolMedido,
			float incVolNormalizado, float incVolMedidoError,
			float incVolNormalizadoError, int tramasReales, int tramasConsumo) {
		super();
		Dispositivo="";
		CUPS="";
		Hora=0;
		Fecha = fecha;
		VolumenMedido = volumenMedido;
		VolumenNormalizado = volumenNormalizado;
		Presion = presion;
		Temperatura = temperatura;
		CaudalVolMedido = caudalVolMedido;
		CaudalVolNormalizado = caudalVolNormalizado;
		IncVolMedido = incVolMedido;
		IncVolNormalizado = incVolNormalizado;
		IncVolMedidoError = incVolMedidoError;
		IncVolNormalizadoError = incVolNormalizadoError;
		TramasReales = tramasReales;
		TramasConsumo = tramasConsumo;
	}
	public TramaHoraria() {
		Dispositivo="";
		CUPS="";
		Hora=0;
		Fecha = null;
		VolumenMedido = 0;
		VolumenNormalizado = 0;
		Presion = 0;
		Temperatura = 0;
		CaudalVolMedido = 0;
		CaudalVolNormalizado = 0;
		IncVolMedido = 0;
		IncVolNormalizado = 0;
		IncVolMedidoError = 0;
		IncVolNormalizadoError = 0;
		TramasReales = 0;
		TramasConsumo = 0;
	}
	
	private String Dispositivo;;
	private String CUPS;
	private int Hora;
	private Date Fecha;
	private int VolumenMedido;
	private int VolumenNormalizado;
	private float Presion;
	private float Temperatura;
	private float CaudalVolMedido;
	private float CaudalVolNormalizado;
	private float IncVolMedido;
	private float IncVolNormalizado;
	private float IncVolMedidoError;
	private float IncVolNormalizadoError;
	private int TramasReales;
	private int TramasConsumo;
	
	
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
	public int getHora() {
		return Hora;
	}
	public void setHora(int hora) {
		Hora = hora;
	}
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
	public float getIncVolMedido() {
		return IncVolMedido;
	}
	public void setIncVolMedido(float incVolMedido) {
		IncVolMedido = incVolMedido;
	}
	public float getIncVolNormalizado() {
		return IncVolNormalizado;
	}
	public void setIncVolNormalizado(float incVolNormalizado) {
		IncVolNormalizado = incVolNormalizado;
	}
	public float getIncVolMedidoError() {
		return IncVolMedidoError;
	}
	public void setIncVolMedidoError(float incVolMedidoError) {
		IncVolMedidoError = incVolMedidoError;
	}
	public float getIncVolNormalizadoError() {
		return IncVolNormalizadoError;
	}
	public void setIncVolNormalizadoError(float incVolNormalizadoError) {
		IncVolNormalizadoError = incVolNormalizadoError;
	}
	public int getTramasReales() {
		return TramasReales;
	}
	public void setTramasReales(int tramasReales) {
		this.TramasReales = tramasReales;
	}
	public int getTramasConsumo() {
		return TramasConsumo;
	}
	public void setTramasConsumo(int traqmasConsumo) {
		this.TramasConsumo = traqmasConsumo;
	}	
	
	public void setTagXml(String tag, String value){
		switch(tag){
		case "fe": 
			this.setFecha(modelo.Fechas.parseDate(value, modelo.Fechas.sdfBD));
			break;
		case "vb":
			this.setVolumenMedido(Integer.parseInt(value));
			break;
		case "vn":
			this.setVolumenNormalizado(Integer.parseInt(value));
			break;
		case "db":
			this.setIncVolMedido(Float.parseFloat(value));
			break;
		case "dn":
			this.setIncVolNormalizado(Float.parseFloat(value));
			break;
		case "qb":
			this.setCaudalVolMedido(Float.parseFloat(value));
			break;
		case "qn":
			this.setCaudalVolNormalizado(Float.parseFloat(value));
			break;
		case "eb":
			this.setIncVolMedidoError(Float.parseFloat(value));
			break;
		case "en":
			this.setIncVolNormalizadoError(Float.parseFloat(value));
			break;
		case "pm":
			this.setPresion(Float.parseFloat(value));
			break;
		case "tm":
			this.setTemperatura(Float.parseFloat(value));
			break;
		case "nt":
			this.setTramasConsumo(Integer.parseInt(value));
			break;		
		default:
			break;			
		}
		
	}
	
	public String Fields(){
		String campos="";
		
		
		campos+="Dispositivo, ";				
		campos+="CUPS, ";
		campos+="Hora, ";
		campos+="Fecha, ";
		campos+="VolumenMedido, ";
		campos+="VolumenNormalizado, ";
		campos+="CaudalVolMedido, ";
		campos+="CaudalVolNormalizado, ";
		campos+="Temperatura, ";
		campos+="Presion, ";
		campos+="IncVolMedido, ";
		campos+="IncVolNormalizado, ";
		campos+="IncVolMedidoError, ";
		campos+="IncVolNormalizadoError, ";
		campos+="TramasReales, ";
		campos+="TramasConsumo";
		
		return campos;
	}
	public String Values(){
		try {

			
						
			String Hora=modelo.Fechas.sdfHora.format(Fecha);			
			this.setHora(Integer.parseInt(Hora));
			
			String valores="";
						
			
			valores+="'" + Dispositivo + "', '";				
			valores+=CUPS + "', ";
			valores+=Hora+", ";
			valores+="'" + modelo.Fechas.sdfBD.format(Fecha) + "', ";
			valores+= VolumenMedido + ", ";
			valores+= VolumenNormalizado + ", ";
			valores+= CaudalVolMedido + ", ";
			valores+= CaudalVolNormalizado + ", ";
			valores+= Temperatura + ", ";
			valores+= Presion + ", ";
			valores+= IncVolMedido + ", ";
			valores+= IncVolNormalizado + ", ";
			valores+= IncVolMedidoError + ", ";
			valores+= IncVolNormalizadoError + ", ";
			valores+= TramasReales + ", ";
			valores+= TramasConsumo;
			
			return valores;
			
		} catch (Exception e) {			
			
			e.printStackTrace();
			return null;
			
		}
	}
}
