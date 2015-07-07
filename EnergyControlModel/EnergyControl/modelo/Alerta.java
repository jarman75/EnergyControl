package modelo;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import funcionesBD.MedElecBD;
import funcionesBD.MedidasBD;
import funcionesBD.SucesosBD;
import funcionesHTTP.HTTPGenerico;
import funcionesHTTP.SolicitudPHP;
//import funcionesMail.SendAuthentication;


public class Alerta extends TimerTask {
	
	private Dispositivo dispositivo = null;
	private List<UsuarioSuceso> listaUsuarios = null;
	private Suceso suceso = null;
	private Timer timer=null;
	 
		
	public Suceso getSuceso() {
		return suceso;
	}

	public void setSuceso(Suceso suceso) {
		this.suceso = suceso;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	public List<UsuarioSuceso> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioSuceso> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
	public boolean cancel(){
	 
		try {
			this.timer.cancel();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	 	
	}
	public void run() {
					
		//System.out.println("Hora inicio tarea " + this.suceso.Id + ": "+new Date());				
		  
		
		  try {
			  
			  //obtener valor actual
			  String valor;				
			  valor = obtener_valDispositivo();
			  if (Numeros.esNumero(valor)){
				  this.suceso.setValorActual(Float.parseFloat(valor));
			  }
			  				
			} catch (Exception e) {
				
				this.suceso.setValorActual(0);
			}
		  
		  //comprobar si hay alerta
		  if (this.suceso.isAlertaActiva()) {				 
			  
			  this.suceso.setAlertaActiva(false);
			  
			  if (grabar_suceso()) {
				  System.out.println("suceso grabado correctamente");			
		  	  }
			  
			  
			  List<UsuarioSuceso> usuarios =  this.getListaUsuarios();
			  if (usuarios!=null){
				  for (UsuarioSuceso user:usuarios){			  
					  
					  //por mail
					  if (user.isPorEMail()){
						  if (enviar_mail_post(user)){
							  System.out.println("envio mail correctamente");
						  }
					  }
					  //por sms
					  if (user.isPorSMS()){
						  if (enviar_sms(user)){
							  System.out.println("envio sms correctamente");
						  }
					  }
					  
					  
					  
				  }
			  }
			  

		  }			
		
		//System.out.println("Hora fin tarea: "+ this.suceso.Id + ": " + new Date());
		
	}
		

	private boolean grabar_suceso() {
		SucesosBD sucBD = new SucesosBD();	
		
		return sucBD.GrabarHistoSuceso(this.suceso.Id, this.suceso.getAlertaFechaInicial(), this.suceso.getAlertaFecha(), this.suceso.getValorAlerta());
	}

	private String obtener_valDispositivo() {
		String valor;		
		
		try {			
			
			valor = "";
			String par = "";				
			switch(this.suceso.Variable){
			case "potencia":
				par="API";
				valor = obtener_valorCircutor(par);
				break;
			case "reactiva":
				MedElecBD medida = new MedElecBD();
				float reactivaVal =  medida.ObtenerPorcReactiva(this.dispositivo.getNombre());
				valor=Float.toString(reactivaVal);
				break;
			case "desconexion":
				if (this.suceso.Energia.equals("Gas")){
					MedidasBD med = new MedidasBD();
					valor = Integer.toString(med.obtener_TramasPerdidas(this.dispositivo.getNombre(), this.suceso.getIntervaloMinutos()));
				}
				break;
			}
			
						
			return valor;
			
		} catch (Exception e) {
			
			return "0";
		}
	}

	private String obtener_valorCircutor(String par) {
		try {
			String valor;
			HTTPGenerico httpGet = new HTTPGenerico("192.168.1.250", 8080, "services/user/values.xml?var=" + 
					this.dispositivo.getNombre()  + "." + par);			
			DOMSource res = httpGet.ExecutaDOM();			
			res.getNode().normalize();			
			Element values = (Element) res.getNode().getChildNodes().item(0);							
			Element variable = (Element) values.getChildNodes().item(0);
			Element value = (Element) variable.getChildNodes().item(1);						
			valor = value.getFirstChild().getNodeValue();
			return valor;
		} catch (DOMException e) {
			return "";
		}
	}

	private boolean enviar_sms(UsuarioSuceso user){
		
		 
				 
		
		try {			
			
			//el mensaje ha de ir sin espacios, sustituir espacios por '+'
			String strMsg="";		
			strMsg = "Alerta+Activada+Id:" + this.suceso.getId() + "+Tipo:" + this.suceso.getVariable() + "+Valor:" + this.suceso.getValorAlerta();
			
			//llama a EnvioSMS con parametros <puerto> <telefono> <mensaje>
			Runtime.getRuntime().exec("java -jar EnvioSMS.jar COM1 " + user.getTelefono() + " " + strMsg);
			return true;
			
		} catch (IOException e) {
			return false;
		}
		
		
		
	}
	
	private boolean enviar_mail_post(UsuarioSuceso user) {
		
		SolicitudPHP.setStrURL("http://localhost/Advanced/newweb/php_script/envia_suceso_email.php");
		//SolicitudPHP.setStrURL("http://192.168.1.15/appenergycontrol/newweb/php_script/envia_suceso_email.php");
		
		SolicitudPHP.setParametro("tipo_aviso", this.suceso.getVariable());
		SolicitudPHP.setParametro("id_suceso", ""+this.suceso.getId());
		SolicitudPHP.setParametro("dispositivo", this.dispositivo.getNombre());
		SolicitudPHP.setParametro("periodo", ""+this.suceso.PeriodoElectrico);
		SolicitudPHP.setParametro("umbral", ""+this.suceso.getValorMaximo());
		SolicitudPHP.setParametro("maximo", ""+this.suceso.getValorAlerta());
		SolicitudPHP.setParametro("hora_inicio", Fechas.sdfBD.format(this.suceso.getAlertaFecha()));
		SolicitudPHP.setParametro("email_usuario", "soporte@energymarket.es");
		SolicitudPHP.setParametro("nombre_usuario", "Soporte Market");		
		int res = SolicitudPHP.sendPost();
		
		if (res!=1) {
			return false;
		}else{
			return true;
		}
		
		
	}

	
	
	
	
}
