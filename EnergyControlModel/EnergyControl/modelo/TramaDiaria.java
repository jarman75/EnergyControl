package modelo;
import java.util.Date;

public class TramaDiaria extends Trama{

			
	public TramaDiaria() {
		super();
		Dispositivo="";
		CUPS="";
		Hora=0;
		Fecha = null;
		VolumenMedido = 0;
		VolumenNormalizado = 0;
		Presion = 0;
		Temperatura = 0;
		IncVolMedido = 0;
		IncVolNormalizado = 0;
		IncVolMedidoError = 0;
		IncVolNormalizadoError = 0;
		IncVolMaxMedidoHora = null;
		IncVolMaxMedido = 0;
		IncVolMinMedidoHora = null;
		IncVolMinMedido = 0;
		IncVolMaxNormalizadoHora = null;
		IncVolMaxNormalizado = 0;
		IncVolMinNormalizadoHora = null;
		IncVolMinNormalizado = 0;
		CaudalVolMaxMedidoHora = null;
		CaudalVolMaxMedido = 0;
		CaudalVolMinMedidoHora = null;
		CaudalVolMinMedido = 0;
		CaudalVolMaxNormalizadoHora = null;
		CaudalVolMaxNormalizado = 0;
		CaudalVolMinNormalizadoHora = null;
		CaudalVolMinNormalizado = 0;
		TramasReales = 0;
		TramasConsumo = 0;
		
	}
	public TramaDiaria(Date fecha, int volumenMedido, int volumenNormalizado,
			float presion, float temperatura, float incVolMedido,
			float incVolNormalizado, float incVolMedidoError,
			float incVolNormalizadoError, Date incVolMaxMedidoHora,
			float incVolMaxMedido, Date incVolMinMedidoHora,
			float incVolMinMedido, Date incVolMaxNormalizadoHora,
			float incVolMaxNormalizado, Date incVolMinNormalizadoHora,
			float incVolMinNormalizado, Date caudalVolMaxMedidoHora,
			float caudalVolMaxMedido, Date caudalVolMinMedidoHora,
			float caudalVolMinMedido, Date caudalVolMaxNormalizadoHora,
			float caudalVolMaxNormalizado, Date caudalVolMinNormalizadoHora,
			float caudalVolMinNormalizado, int tramasReales, int tramasConsumo) {
		super();
		Dispositivo="";
		CUPS="";
		Hora=0;
		Fecha = fecha;
		VolumenMedido = volumenMedido;
		VolumenNormalizado = volumenNormalizado;
		Presion = presion;
		Temperatura = temperatura;
		IncVolMedido = incVolMedido;
		IncVolNormalizado = incVolNormalizado;
		IncVolMedidoError = incVolMedidoError;
		IncVolNormalizadoError = incVolNormalizadoError;
		IncVolMaxMedidoHora = incVolMaxMedidoHora;
		IncVolMaxMedido = incVolMaxMedido;
		IncVolMinMedidoHora = incVolMinMedidoHora;
		IncVolMinMedido = incVolMinMedido;
		IncVolMaxNormalizadoHora = incVolMaxNormalizadoHora;
		IncVolMaxNormalizado = incVolMaxNormalizado;
		IncVolMinNormalizadoHora = incVolMinNormalizadoHora;
		IncVolMinNormalizado = incVolMinNormalizado;
		CaudalVolMaxMedidoHora = caudalVolMaxMedidoHora;
		CaudalVolMaxMedido = caudalVolMaxMedido;
		CaudalVolMinMedidoHora = caudalVolMinMedidoHora;
		CaudalVolMinMedido = caudalVolMinMedido;
		CaudalVolMaxNormalizadoHora = caudalVolMaxNormalizadoHora;
		CaudalVolMaxNormalizado = caudalVolMaxNormalizado;
		CaudalVolMinNormalizadoHora = caudalVolMinNormalizadoHora;
		CaudalVolMinNormalizado = caudalVolMinNormalizado;
		TramasReales = tramasReales;
		TramasConsumo = tramasConsumo;
	}
	
	
	private String Dispositivo;
	private String CUPS;
	private int Hora;
	
	private Date Fecha;
	
	private int VolumenMedido;
	private int VolumenNormalizado;
	
	private float Presion;
	private float Temperatura;
	
	private float IncVolMedido;
	private float IncVolNormalizado;
	
	private float IncVolMedidoError;
	private float IncVolNormalizadoError;
	
	private Date IncVolMaxMedidoHora;
	private float IncVolMaxMedido;
	private Date IncVolMinMedidoHora;
	private float IncVolMinMedido;
	
	private Date IncVolMaxNormalizadoHora;	
	private float IncVolMaxNormalizado;
	private Date IncVolMinNormalizadoHora;	
	private float IncVolMinNormalizado;
	
	private Date CaudalVolMaxMedidoHora;
	private float CaudalVolMaxMedido;
	private Date CaudalVolMinMedidoHora;
	private float CaudalVolMinMedido;
	
	private Date CaudalVolMaxNormalizadoHora;	
	private float CaudalVolMaxNormalizado;
	private Date CaudalVolMinNormalizadoHora;	
	private float CaudalVolMinNormalizado;
	
	
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
	public Date getIncVolMaxMedidoHora() {
		return IncVolMaxMedidoHora;
	}
	public void setIncVolMaxMedidoHora(Date incVolMaxMedidoHora) {
		IncVolMaxMedidoHora = incVolMaxMedidoHora;
	}
	public float getIncVolMaxMedido() {
		return IncVolMaxMedido;
	}
	public void setIncVolMaxMedido(float incVolMaxMedido) {
		IncVolMaxMedido = incVolMaxMedido;
	}
	public Date getIncVolMinMedidoHora() {
		return IncVolMinMedidoHora;
	}
	public void setIncVolMinMedidoHora(Date incVolMinMedidoHora) {
		IncVolMinMedidoHora = incVolMinMedidoHora;
	}
	public float getIncVolMinMedido() {
		return IncVolMinMedido;
	}
	public void setIncVolMinMedido(float incVolMinMedido) {
		IncVolMinMedido = incVolMinMedido;
	}
	public Date getIncVolMaxNormalizadoHora() {
		return IncVolMaxNormalizadoHora;
	}
	public void setIncVolMaxNormalizadoHora(Date incVolMaxNormalizadoHora) {
		IncVolMaxNormalizadoHora = incVolMaxNormalizadoHora;
	}
	public float getIncVolMaxNormalizado() {
		return IncVolMaxNormalizado;
	}
	public void setIncVolMaxNormalizado(float incVolMaxNormalizado) {
		IncVolMaxNormalizado = incVolMaxNormalizado;
	}
	public Date getIncVolMinNormalizadoHora() {
		return IncVolMinNormalizadoHora;
	}
	public void setIncVolMinNormalizadoHora(Date f) {
		IncVolMinNormalizadoHora = f;
	}
	public float getIncVolMinNormalizado() {
		return IncVolMinNormalizado;
	}
	public void setIncVolMinNormalizado(float incVolMinNormalizado) {
		IncVolMinNormalizado = incVolMinNormalizado;
	}
	public Date getCaudalVolMaxMedidoHora() {
		return CaudalVolMaxMedidoHora;
	}
	public void setCaudalVolMaxMedidoHora(Date caudalVolMaxMedidoHora) {
		CaudalVolMaxMedidoHora = caudalVolMaxMedidoHora;
	}
	public float getCaudalVolMaxMedido() {
		return CaudalVolMaxMedido;
	}
	public void setCaudalVolMaxMedido(float caudalVolMaxMedido) {
		CaudalVolMaxMedido = caudalVolMaxMedido;
	}
	public Date getCaudalVolMinMedidoHora() {
		return CaudalVolMinMedidoHora;
	}
	public void setCaudalVolMinMedidoHora(Date caudalVolMinMedidoHora) {
		CaudalVolMinMedidoHora = caudalVolMinMedidoHora;
	}
	public float getCaudalVolMinMedido() {
		return CaudalVolMinMedido;
	}
	public void setCaudalVolMinMedido(float caudalVolMinMedido) {
		CaudalVolMinMedido = caudalVolMinMedido;
	}
	public Date getCaudalVolMaxNormalizadoHora() {
		return CaudalVolMaxNormalizadoHora;
	}
	public void setCaudalVolMaxNormalizadoHora(Date caudalVolMaxNormalizadoHora) {
		CaudalVolMaxNormalizadoHora = caudalVolMaxNormalizadoHora;
	}
	public float getCaudalVolMaxNormalizado() {
		return CaudalVolMaxNormalizado;
	}
	public void setCaudalVolMaxNormalizado(float caudalVolMaxNormalizado) {
		CaudalVolMaxNormalizado = caudalVolMaxNormalizado;
	}
	public Date getCaudalVolMinNormalizadoHora() {
		return CaudalVolMinNormalizadoHora;
	}
	public void setCaudalVolMinNormalizadoHora(Date caudalVolMinNormalizadoHora) {
		CaudalVolMinNormalizadoHora = caudalVolMinNormalizadoHora;
	}
	public float getCaudalVolMinNormalizado() {
		return CaudalVolMinNormalizado;
	}
	public void setCaudalVolMinNormalizado(float caudalVolMinNormalizado) {
		CaudalVolMinNormalizado = caudalVolMinNormalizado;
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
	public void setTramasConsumo(int tramasConsumo) {
		this.TramasConsumo = tramasConsumo;
	}
	
	public String Fields() {
		
		String campos="";
		
		campos = "Dispositivo, ";
		campos+= "CUPS, ";
		campos+= "Fecha, ";
		campos+= "Hora, ";
		campos+= "VolumenMedido, ";
		campos+= "VolumenNormalizado, ";
		campos+= "Presion, ";
		campos+= "Temperatura, ";
		campos+= "IncVolMedido, ";
		campos+= "IncVolNormalizado, ";
		campos+= "IncVolMedidoError, ";
		campos+= "IncVolNormalizadoError, ";
		campos+= "IncVolMaxMedidoHora, ";
		campos+= "IncVolMaxMedido, ";
		campos+= "IncVolMinMedidoHora, ";
		campos+= "IncVolMinMedido, ";
		campos+= "IncVolMaxNormalizadoHora, ";
		campos+= "IncVolMaxNormalizado, ";
		campos+= "IncVolMinNormalizadoHora, ";
		campos+= "IncVolMinNormalizado, ";
		campos+= "CaudalVolMaxMedidoHora, ";
		campos+= "CaudalVolMaxMedido, ";
		campos+= "CaudalVolMinMedidoHora, ";
		campos+= "CaudalVolMinMedido, ";
		campos+= "CaudalVolMaxNormalizadoHora, ";
		campos+= "CaudalVolMaxNormalizado, ";
		campos+= "CaudalVolMinNormalizadoHora, ";
		campos+= "CaudalVolMinNormalizado, ";
		campos+= "tramasReales, ";
		campos+= "tramasConsumo";		
				
		return campos;
	}
	@Override
	public String Values() {
		
		
		
		try {
			String valores="";
			
			Hora=Integer.parseInt(modelo.Fechas.sdfHora.format(Fecha));
			
			valores = "'" + Dispositivo + "', ";
			valores+= "'" + CUPS + "', ";
			valores+= "'" + modelo.Fechas.sdfBD.format(Fecha) + "', ";
			valores+= Hora + ", ";
			valores+= VolumenMedido + ", ";
			valores+= VolumenNormalizado + ", ";
			valores+= Presion + ", ";
			valores+= Temperatura + ", ";
			valores+= IncVolMedido + ", ";
			valores+= IncVolNormalizado + ", ";
			valores+= IncVolMedidoError + ", ";
			valores+= IncVolNormalizadoError + ", ";
			valores+= "'" + modelo.Fechas.sdfBD.format(IncVolMaxMedidoHora) + "', ";
			valores+= IncVolMaxMedido + ", ";
			valores+= "'" + modelo.Fechas.sdfBD.format(IncVolMinMedidoHora) + "', ";
			valores+= IncVolMinMedido + ", ";
			valores+= "'" + modelo.Fechas.sdfBD.format(IncVolMaxNormalizadoHora) + "', ";
			valores+= IncVolMaxNormalizado +", ";
			valores+= "'" + modelo.Fechas.sdfBD.format(IncVolMinNormalizadoHora) + "', ";
			valores+= IncVolMinNormalizado + ", ";
			valores+= "'" + modelo.Fechas.sdfBD.format(CaudalVolMaxMedidoHora) + "', ";
			valores+= CaudalVolMaxMedido + ", ";
			valores+= "'" +  modelo.Fechas.sdfBD.format(CaudalVolMinMedidoHora) + "', ";
			valores+= CaudalVolMinMedido + ", ";
			valores+= "'" + modelo.Fechas.sdfBD.format(CaudalVolMaxNormalizadoHora) + "', ";
			valores+= CaudalVolMaxNormalizado + ", ";
			valores+= "'" + modelo.Fechas.sdfBD.format(CaudalVolMinNormalizadoHora) + "', ";
			valores+= CaudalVolMinNormalizado + ", ";
			valores+= TramasReales + ", ";
			valores+= TramasConsumo;		
					
			return valores;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void setTagXml(String Tag, String Valor) {
		switch(Tag){
		case "fe":
			this.setFecha(modelo.Fechas.parseDate(Valor, modelo.Fechas.sdfBD));
			break;
		case "ct":
			this.setTramasConsumo(Integer.parseInt(Valor));			
			break;
		case "tb":
			this.setIncVolMedido(Integer.parseInt(Valor));
			break;
		case "tn":
			this.setIncVolNormalizado(Integer.parseInt(Valor));
			break;
		case "eb":
			this.setIncVolMedidoError(Float.parseFloat(Valor));
			break;
		case "en":
			this.setIncVolNormalizadoError(Float.parseFloat(Valor));
			break;
		case "vx":
			this.setIncVolMaxMedido(Float.parseFloat(Valor));
			break;
		case "fx":
			this.setIncVolMaxMedidoHora(modelo.Fechas.parseDate(Valor, modelo.Fechas.sdfBD));
			break;
		case "vy":
			this.setIncVolMaxNormalizado(Float.parseFloat(Valor));
			break;
		case "fy":
			this.setIncVolMaxNormalizadoHora(modelo.Fechas.parseDate(Valor, modelo.Fechas.sdfBD));
			break;
		case "qx":
			this.setCaudalVolMaxMedido(Float.parseFloat(Valor));
			break;
		case "tx":
			this.setCaudalVolMaxMedidoHora(modelo.Fechas.parseDate(Valor,modelo.Fechas.sdfBD));
			break;
		case "qy":
			this.setCaudalVolMaxNormalizado(Float.parseFloat(Valor));
			break;
		case "ty":
			this.setCaudalVolMaxNormalizadoHora(modelo.Fechas.parseDate(Valor,modelo.Fechas.sdfBD));
			break;
		case "bx":
			this.setIncVolMinMedido(Float.parseFloat(Valor));
			break;
		case "dx":
			this.setIncVolMinMedidoHora(modelo.Fechas.parseDate(Valor, modelo.Fechas.sdfBD));			
			break;
		case "by":
			this.setIncVolMinNormalizado(Float.parseFloat(Valor));			
			break;
		case "dy":
			this.setIncVolMinNormalizadoHora(modelo.Fechas.parseDate(Valor, modelo.Fechas.sdfBD));
			break;
		case "kx":
			this.setCaudalVolMinMedido(Float.parseFloat(Valor));			
			break;
		case "sx":
			this.setCaudalVolMinMedidoHora(modelo.Fechas.parseDate(Valor, modelo.Fechas.sdfBD));
			break;
		case "ky":
			this.setCaudalVolMinNormalizado(Float.parseFloat(Valor));
			break;
		case "sy":
			this.setCaudalVolMinNormalizadoHora(modelo.Fechas.parseDate(Valor, modelo.Fechas.sdfBD));
			break;			
		default:
			break;
		}
		
			
		
		}
	
	
	
	
	}
	
	
	

