package funcionesBD;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.TimeZone;

import modelo.Fechas;
import modelo.TipoMedida;
import modelo.TramaDiaria;
import modelo.TramaHoraria;

public class MedidasBD extends AccesoBD {
			
	private SimpleDateFormat sdfBD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				
	private SimpleDateFormat sdfHora = new SimpleDateFormat("HH");
	
	public MedidasBD(){
		super.UltimoError="";
		//super.server="192.168.1.249";		
		super.bd="LecturasGas";
		super.user="root";
		super.psw="EnergyAdminPlus";

	}
	
	private Hashtable<String,String> mapaCamposKroms(){
		Hashtable <String,String> campos = new Hashtable<String,String>();
		campos.put("Dispositivo", "Dispositivo");
		campos.put("Cups", "CUPS");
		campos.put("fecha", "Fecha");
		campos.put("hh", "Hora");
		campos.put("vb", "VolumenMedido");
		campos.put("vn", "VolumenNormalizado");
		campos.put("presion", "Presion");
		campos.put("temperatura", "Temperatura");
		campos.put("qb", "CaudalVolMedido");
		campos.put("qn", "CaudalVolNormalizado");
		campos.put("estado", "Alarma");		
		
		return campos;
	}
	private Hashtable<String,String> mapaCamposEstandar(){
		
		Hashtable <String,String> campos = new Hashtable<String,String>();
		campos.put("Dispositivo", "Dispositivo");
		campos.put("Cups", "CUPS");
		campos.put("hora", "Fecha");
		campos.put("hh", "Hora");
		campos.put("Vm", "VolumenMedido");
		campos.put("Vn", "VolumenNormalizado");
		campos.put("P", "Presion");
		campos.put("T", "Temperatura");
		campos.put("QVm", "CaudalVolMedido");
		campos.put("QVn", "CaudalVolNormalizado");
		campos.put("IVm", "IncVolMedido");
		campos.put("IVn", "IncVolNormalizado");
		campos.put("IVmE", "IncVolMedidoError");
		campos.put("IVnE", "IncVolNormalizadoError");
		campos.put("ntr", "tramasReales");
		campos.put("ntc", "tramasConsumo");
		campos.put("al", "Alarma");
		campos.put("IVm_max", "IncVolMaxMedido");
		campos.put("IVm_max_hr", "IncVolMaxMedidoHora");
		campos.put("IVn_max", "IncVolMaxNormalizado");
		campos.put("IVn_max_hr", "IncVolMaxNormalizadoHora");
		campos.put("IVm_min", "IncVolMinMedido");
		campos.put("IVm_min_hr", "IncVolMinMedidoHora");
		campos.put("IVn_min", "IncVolMinNormalizado");
		campos.put("IVn_min_hr", "IncVolMinNormalizadoHora");
		campos.put("QVm_max", "CaudalVolMaxMedido");
		campos.put("QVm_max_hr", "CaudalVolMaxMedidoHora");
		campos.put("QVn_max", "CaudalVolMaxNormalizado");
		campos.put("QVn_max_hr", "CaudalVolMaxNormalizadoHora");
		campos.put("QVm_min", "CaudalVolMinMedido");
		campos.put("QVm_min_hr", "CaudalVolMinMedidoHora");
		campos.put("QVn_min", "CaudalVolMinNormalizado");
		campos.put("QVn_min_hr", "CaudalVolMinNormalizadoHora");
		return campos;
	}

	// <ULTIMA HORARIA  funciones para almacenar ultima trama horaria>		
	public boolean grabar_gasUltimaHoraria(List<TramaHoraria> tramas, String NombreDispositivo, String cupsDispositivo, String tipoSoftware){
		
		 
		Connection cnn = null;
		cnn=abrir_conexion();
		
		try{
			
			String campos="";
			String valores="";
			
			for (int i=0;i<tramas.size();i++){		
								
				tramas.get(i).setDispositivo(NombreDispositivo);				
				tramas.get(i).setCUPS(cupsDispositivo);
				
				campos = tramas.get(i).Fields();							
				valores = tramas.get(i).Values();				
				
				if (valores==null) {
					throw new Exception ("error grabando trama horaria.");
				}
				String query="insert ignore into ultima_horaria (" + campos + ") values (" + valores + ")"; 
				
				if (ejecutar_updateDelete(cnn, query)==false){				
					throw new Exception ("error grabando trama horaria."); 
				}
				
			}			

			return true;				
			
						
		}catch(Exception e){		
			setUltimoError(e.getMessage());
			return false;
		}finally{			
			cerrar_conexion(cnn);			
		}	
					
		
	}	
	
	// <ULTIMA DIARIA  funciones para almacenar ultima trama diaria>		
	public boolean grabar_gasUltimaDiaria(List<TramaDiaria> tramas, String NombreDispositivo, String cupsDispositivo, String tipoSoftware){
						 
			Connection cnn = null;
			cnn=abrir_conexion();
			
			try{
				
				String campos="";
				String valores="";
				
				for (int i=0;i<tramas.size();i++){		
									
					tramas.get(i).setDispositivo(NombreDispositivo);				
					tramas.get(i).setCUPS(cupsDispositivo);
					
					campos = tramas.get(i).Fields();							
					valores = tramas.get(i).Values();				
					
					if (valores!=null){
						String query="insert ignore into ultima_diaria (" + campos + ") values (" + valores + ")";					
						if (ejecutar_updateDelete(cnn, query)==false){				
							throw new Exception ("error grabando trama diaria."); 
						}
					}
					
				}			

				return true;				
							
			}catch(Exception e){		
				setUltimoError(e.getMessage());
				return false;
			}finally{			
				cerrar_conexion(cnn);			
			}			
		}	

	public boolean grabar_lecturaGas(Hashtable<String,String> ElementosXML,TipoMedida tLec, String NombreDispositivo, String cupsDispositivo, String tipoSoftware){
		
	    	    
	    String valFechaHora="";
	    String fmtFechaHora="";
	    Hashtable <String,String> mapaCampos=null;
	   
	    
	    switch(tipoSoftware) {
	    case "Kroms":
	    	valFechaHora="fecha";
	    	fmtFechaHora="dd/MM/yyyy HH:mm:ss";
	    	mapaCampos=mapaCamposKroms();
	    	
	    	break;	    
	    default:
	    	valFechaHora="hora";
	    	fmtFechaHora="dd/MM/yyyy HH:mm";
	    	mapaCampos=mapaCamposEstandar();
	    	break;	    	
	    }
	    
		Connection cnn = null;
		
		try{
					
			SimpleDateFormat sdfXML = new SimpleDateFormat(fmtFechaHora);					
			
			
			switch(tipoSoftware){
			case "Kroms":
				sdfXML.setTimeZone(TimeZone.getTimeZone("UTC"));								
				break;
			default:
				sdfXML.setTimeZone(TimeZone.getDefault());								
				break;			
			}
			
			
			String Fecha="";
			String Hora="";			
			
			if (ElementosXML.containsKey(valFechaHora)==false){
				
				Calendar FechaHora = Calendar.getInstance();
				Fecha = sdfBD.format(FechaHora.getTime());
				Hora = sdfHora.format(FechaHora.getTime());
				
				Fecha=null;
				
			}else{												
								
				//la fecha que viene en el xml				
				Date FechaHora = modelo.Fechas.parseDate(ElementosXML.get(valFechaHora), sdfXML);
				
				//la fecha/Hora a grabar en BD
				Fecha = sdfBD.format(FechaHora);				
				Hora=sdfHora.format(FechaHora);
				
				
			}
			
			ElementosXML.put(valFechaHora, "'" + Fecha + "'");
			ElementosXML.put("hh", Hora);
			ElementosXML.put("Dispositivo", "'" + NombreDispositivo + "'");
			ElementosXML.put("Cups","'" + cupsDispositivo + "'");			
			
			
			
			Enumeration<String> claves = null;
			claves =  ElementosXML.keys();		
			
			String campos ="";
			String valores = "";
			
			while (claves.hasMoreElements()) {
				  String clave = claves.nextElement();
				  String campo = mapaCampos.get(clave);				  
				  String valor = ElementosXML.get(clave);	
				  if (clave!=null && clave.contains("_hr") ){
					  Date FechaHora = modelo.Fechas.parseDate(valor,sdfXML);
					  valor="'" + sdfBD.format(FechaHora) + "'";
				  }
				  
				  if (campos==""){				  
					  campos = campo;
					  valores = valor;
				  }else{
					  campos = campos + ", " + campo;
					  valores = valores + ", " + valor;				  
				  }
				  
			}
			
			
			
			
			String tabla="";
			
			switch(tLec){
				case diaCurso:
					tabla="diaria_curso";
					break;
				case horaCurso:
					tabla="horaria_curso";
					break;
				case ultDia:
					tabla="ultima_diaria";				
					break;
				case ultHora:
					tabla="ultima_horaria";
					break;
				case ultTrama:
					tabla="ultima_trama";
					break;
				default:
					break;		
			}
				
			
			cnn=abrir_conexion();		
			String query="insert ignore into " + tabla + "(" + campos + ") values (" + valores + ")"; 
						
			if (ejecutar_updateDelete(cnn, query)==false){
				return false;
			}else{
				return true;
			}
						
		}catch(Exception e){		
			setUltimoError(e.getMessage());
			return false;
		}finally{			
			cerrar_conexion(cnn);			
		}	
		
	}
	
	public int obtener_TramasPerdidas(String NombreDispositivo, int IntervaloHoras){
		
		//devuelve tramas perdidas
		//Desde hoy-intervalo horas Hasta hoy.hora.actual			
		

		Connection cnn = null;
		cnn=abrir_conexion();
		
		try{
			
			Calendar calendario = Calendar.getInstance();
			Date fechaFinal = calendario.getTime();
			calendario.add(Calendar.HOUR_OF_DAY, IntervaloHoras*(-1));
			Date fechaInicial=calendario.getTime();
			
			String FInicial=Fechas.sdfBD.format(fechaInicial);
			String FFinal=Fechas.sdfBD.format(fechaFinal);
			
			String query="Select count(*) tramas from ultima_horaria where fecha >= '" + FInicial + "' and  fecha <= '" + FFinal + "' and dispositivo = '" + NombreDispositivo + "'"; 
				
			ResultSet res = ejecutar_query(cnn, query);				
			int registros = 0;
			while(res.next()){
				registros = res.getInt("tramas");
			}
			
			return IntervaloHoras - registros;				
			
						
		}catch(Exception e){		
			setUltimoError(e.getMessage());
			return IntervaloHoras;
		}finally{			
			cerrar_conexion(cnn);			
		}	

	}

}		

