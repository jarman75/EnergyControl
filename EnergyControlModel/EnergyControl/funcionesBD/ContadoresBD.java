package funcionesBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Dispositivo;
import modelo.Fechas;


public class ContadoresBD extends AccesoBD {
		
	public ContadoresBD(){
		//super.server="localhost";
		super.bd="Contadores";
		super.user="root";
		super.psw="EnergyAdminPlus";
		
	}
		
	
	
	public List<Dispositivo> obtener_dispositivos(String FiltroDispositivo){
		Connection con = null;
		if (FiltroDispositivo==null) FiltroDispositivo="";
		try{
			con = abrir_conexion();
			ResultSet result = ejecutar_query(con, "select Nombre,CUPS,IP,Puerto,Software from Ficha_Dispositivo "
					+ "where Acceso='Motor' " + FiltroDispositivo);			
			List<Dispositivo> listaDispositivos= new ArrayList<Dispositivo>();			
			while(result.next()){
				Dispositivo dis = new Dispositivo(result.getString("Nombre"),result.getString("CUPS"),
						result.getString("IP"),result.getInt("Puerto"),result.getString("Software"));
				listaDispositivos.add(dis);
			}
			result.close();
			return listaDispositivos;			
		}catch(Exception ex){
			setUltimoError(ex.getMessage());
			return null;
		}finally{
			cerrar_conexion(con);
		}
	}
		
	public List<Dispositivo> obtener_dispositivosEnSucesos(String dispositivo){
		if (dispositivo!=null && dispositivo!=""){
			dispositivo=" and Nombre = '" + dispositivo + "'";
		}else{
			dispositivo="";
		}
		return obtener_dispositivos("and Nombre in (Select Dispositivo from Sucesos) " + dispositivo);
	}
	
	public List<Dispositivo> obtener_dispositivosElectricidad(String dispositivo){		
		if (dispositivo!=null && dispositivo!=""){
			dispositivo=" and Nombre = '" + dispositivo + "'";
		}else{
			dispositivo="";
		}
		return obtener_dispositivos("and Tipo_Energia='Electricidad' " + dispositivo);			
	}
		
	public List<Dispositivo> obtener_dispositivosGAS(String dispositivo){
		if (dispositivo!=null && dispositivo!=""){
			dispositivo=" and Nombre = '" + dispositivo + "'";
		}else{
			dispositivo="";
		}
		return obtener_dispositivos("and Tipo_Energia='Gas' " + dispositivo);		
	}
		
	public int obtener_periodoDispositivo (String Dispositivo, Date FechaHora){
		
		
				
		Connection con = abrir_conexion();
			
		
		try {
			
			Calendar calendar = Calendar.getInstance();		
			if (FechaHora==null){
				FechaHora=calendar.getTime();
			}
			//long fechamilisegundos = FechaHora.getTime();
			//java.sql.Time fecha = new java.sql.Time(fechamilisegundos);
			
			String fecha = Fechas.sdfBD.format(FechaHora);
			
			String selectSQL = "{? = Call F_consultar_periodo (?,?)}";
			
			java.sql.CallableStatement callStatement = con.prepareCall(selectSQL);
			callStatement.registerOutParameter(1, Types.INTEGER);
			
			callStatement.setString(2,Dispositivo);	
			callStatement.setString(3, fecha);
			callStatement.execute();			
			
			int res= callStatement.getInt(1);			
			return res;
			
			
		} catch (SQLException e) {
			setUltimoError(e.getMessage());
			return 0;
		}finally{
			cerrar_conexion(con);
		}
		
		
	}

}
