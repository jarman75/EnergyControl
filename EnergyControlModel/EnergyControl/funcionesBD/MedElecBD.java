package funcionesBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;

import modelo.Fechas;

public class MedElecBD extends AccesoBD{
	
	public MedElecBD() {
		//super.server="192.168.1.249";
		super.bd="Contadores";
		super.user="root";
		super.psw="EnergyAdminPlus";		
	}
		
	public float ObtenerPorcReactiva(String Dispositivo){
		
		Calendar calendar = Calendar.getInstance();		
		
		Date FechaHora=calendar.getTime();
		int mes = calendar.get(Calendar.MONTH) + 1;
		String smes = (mes<10)? "0"+mes : Integer.toString(mes);
		
		String strfecha="01-" +  smes + "-" + calendar.get(Calendar.YEAR);
		Date FechaInicialMes = modelo.Fechas.parseDate(strfecha, modelo.Fechas.sdfLocalDia);
				
		long fechamilisegundos = FechaHora.getTime();		
		java.sql.Date fechaHasta = new java.sql.Date(fechamilisegundos);
		
		fechamilisegundos = FechaInicialMes.getTime();		
		java.sql.Date fechaDesde = new java.sql.Date(fechamilisegundos);
		
				
		Connection con = abrir_conexion();
		
		String selectSQL = "{? = Call F_porcentaje_reactiva (?,?,?)}";
		try {
			
			java.sql.CallableStatement callStatement = con.prepareCall(selectSQL);
			callStatement.registerOutParameter(1, Types.FLOAT);			
			callStatement.setString(2,Dispositivo);	
			callStatement.setDate(3, fechaDesde);
			callStatement.setDate(4, fechaHasta);
			callStatement.execute();			
			
			float res= callStatement.getInt(1);			
			return res;
			
			
		} catch (SQLException e) {
			setUltimoError(e.getMessage());
			return 0;
		}finally{
			cerrar_conexion(con);
		}
		
	}
	
	public int ObtenerReactiva(String Dispositivo){
		Connection con = abrir_conexion();
		
		try{
			
			Calendar calendar = Calendar.getInstance();
			calendar.getTime();
			int mes = calendar.get(Calendar.MONTH);
			
			String query ="Select sum(Reactiva_con) reactiva from Curva_Carga "					
					+ "where Dispositivo = '" + Dispositivo + "' and month(fecha) = " + mes; 
					
			ResultSet res = this.ejecutar_query(con, query);
			
			int valor=0; 
			
			while(res.next()){
			   valor=res.getInt("reactiva");
			}
			
			return valor;			
		}catch (Exception ex){
			return 0;
		}finally{
			cerrar_conexion(con);
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
			
			String query="Select count(*) from curva_carga where fecha >= '" + FInicial + "' and  fecha <= '" + FFinal + "' and dispositivo = '" + NombreDispositivo + "'"; 
				
			ResultSet res = ejecutar_query(cnn, query);				
			int registros = 0;
			while(res.next()){
				registros = res.getInt(0);
			}
			
			return IntervaloHoras - (registros/4);				
			
						
		}catch(Exception e){		
			setUltimoError(e.getMessage());
			return IntervaloHoras;
		}finally{			
			cerrar_conexion(cnn);			
		}	

	}


}
