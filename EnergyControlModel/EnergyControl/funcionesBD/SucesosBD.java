package funcionesBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Suceso;
import modelo.SucesoDesconexionGAS;
import modelo.SucesoPotencia;
import modelo.SucesoReactiva;
import modelo.SucesoTensionSobre;
import modelo.SucesoTensionSub;
import modelo.UsuarioSuceso;

public class SucesosBD extends AccesoBD {
	
	public SucesosBD() {		
		//super.server="localhost";
		super.bd="Contadores";
		super.user="root";
		super.psw="EnergyAdminPlus";
	}

	public List<Suceso> obtener_sucesos(String dispositivo, int PeriodoActual){
			
			
		
		try{
								
			List<Suceso>lista_sucesos = new ArrayList<Suceso>();			
			
			//potencia
			List<SucesoPotencia> lista_sp = new ArrayList<SucesoPotencia>();
			lista_sp = obtener_sucesosPotencia(dispositivo, PeriodoActual);
			if (lista_sp!=null){
				for(int s=0;s<lista_sp.size();s++){
					lista_sucesos.add ( new Suceso ( lista_sp.get(s).getId(), lista_sp.get(s).getDispositivo(), 
							lista_sp.get(s).getValorMaximo(), lista_sp.get(s).getIntervaloMinutos(), lista_sp.get(s).getEnergia(), 
							lista_sp.get(s).getPeriodoElectrico(), lista_sp.get(s).getVariable() ));
				}
			}
			
			/*sobre_tensión
			List<SucesoTensionSobre> lista_ts = new ArrayList<SucesoTensionSobre>();
			lista_ts = obtener_sucesosTensionSobre(dispositivo);
			if (lista_ts!=null){
				for(int s=0;s<lista_ts.size();s++){
					lista_sucesos.add ( new Suceso ( lista_ts.get(s).getId(), lista_ts.get(s).getDispositivo(), 
							lista_ts.get(s).getValorMaximo(), lista_ts.get(s).getIntervaloMinutos(), lista_ts.get(s).getEnergia(),
							0, lista_sp.get(s).getVariable()	));
				}
			}
			
			//sub_tensión
			List<SucesoTensionSub> lista_tsub = new ArrayList<SucesoTensionSub>();
			lista_tsub = obtener_sucesosTensionSub(dispositivo);
			if (lista_tsub!=null){
				for(int s=0;s<lista_tsub.size();s++){
					lista_sucesos.add ( new Suceso ( lista_tsub.get(s).getId(), lista_tsub.get(s).getDispositivo(), 
							lista_tsub.get(s).getValorMaximo(), lista_tsub.get(s).getIntervaloMinutos(), lista_tsub.get(s).getEnergia(),
							0, lista_tsub.get(s).getVariable() ));
				}
			}*/
			
			//reactiva
			List<SucesoReactiva> lista_ra = new ArrayList<SucesoReactiva>();
			lista_ra = obtener_sucesosReactiva(dispositivo);
			if (lista_ra!=null){
				for(int s=0;s<lista_ra.size();s++){
					lista_sucesos.add ( new Suceso(lista_ra.get(s).getId(), lista_ra.get(s).getDispositivo(), 
							lista_ra.get(s).getValorMaximo(), lista_ra.get(s).getIntervaloMinutos(), lista_ra.get(s).getEnergia(),
							0, lista_ra.get(s).getVariable()	));
				}
			}
			
			//desconexion gas
			List<SucesoDesconexionGAS> lista_dxg = new ArrayList<SucesoDesconexionGAS>();
			lista_dxg = obtener_sucesosDesconexionGas(dispositivo);
			if (lista_dxg!=null){
				for (int s=0;s<lista_dxg.size();s++){
					lista_sucesos.add ( new Suceso(lista_dxg.get(s).getId(), lista_dxg.get(s).getDispositivo(), 
							lista_dxg.get(s).getValorMaximo(), lista_dxg.get(s).getIntervaloMinutos(), lista_dxg.get(s).getEnergia(),
							0, lista_dxg.get(s).getVariable()	));
				}
			}
			
			
			return lista_sucesos;
			
		}catch(Exception ex){
			return null;
		}
	}
	
	private List<SucesoDesconexionGAS> obtener_sucesosDesconexionGas(
			String dispositivo) {
		
		Connection con = null;
		
		if (dispositivo!=null && dispositivo!=""){
			dispositivo=" and dispositivo = '" + dispositivo + "'";
		}else{
			dispositivo="";
		}
		
		try{
			con = abrir_conexion();
			ResultSet result = ejecutar_query(con,"select id, umbral, tiempo, dispositivo from Sucesos where activo = 'Si' and tipo = 'desconexion' " + dispositivo + " order by id");
			List<SucesoDesconexionGAS> listaSucesos = new ArrayList<SucesoDesconexionGAS>();
			while (result.next()){				
				SucesoDesconexionGAS Suceso=
					new SucesoDesconexionGAS(result.getInt("id"),result.getString("dispositivo"),
					result.getInt("umbral"),result.getInt("tiempo"));
				listaSucesos.add(Suceso);
			}
			result.close();
			return listaSucesos;
			
		}catch(Exception ex){
			setUltimoError(ex.getMessage());
			return null;			
		}finally{
			cerrar_conexion(con);
		}	
		
		
	}

	public List<SucesoPotencia> obtener_sucesosPotencia(String dispositivo, int periodoActual){
		Connection con = null;		
		String condicionPeriodo="";
		if (periodoActual!=0){
			condicionPeriodo=" and periodo = 'p"+periodoActual+"'";
		}
		if (dispositivo!=null && dispositivo!=""){
			dispositivo=" and dispositivo = '" + dispositivo + "'";
		}else{
			dispositivo="";
		}
		
		try{
			con = abrir_conexion();
			ResultSet result = ejecutar_query(con,"select id, periodo, umbral, tiempo, dispositivo from Sucesos where activo = 'Si' and tipo = 'potencia' " + dispositivo + condicionPeriodo + " order by id");
			List<SucesoPotencia> listaSucesos = new ArrayList<SucesoPotencia>();
			while (result.next()){
				String aux = result.getString("periodo").substring(1, 2);
				int periodo = Integer.parseInt(aux);
				SucesoPotencia Suceso=
					new SucesoPotencia(result.getInt("id"),result.getString("dispositivo"),
					result.getInt("umbral"),result.getInt("tiempo"), result.getString("periodo"), periodo);
				listaSucesos.add(Suceso);
			}
			result.close();
			return listaSucesos;
			
		}catch(Exception ex){
			setUltimoError(ex.getMessage());
			return null;			
		}finally{
			cerrar_conexion(con);
		}		
	}
	
	public List<SucesoTensionSobre> obtener_sucesosTensionSobre(String dispositivo){
		
		if (dispositivo!=null && dispositivo!=""){
			dispositivo=" and dispositivo = '" + dispositivo + "'";
		}else{
			dispositivo="";
		}
		
		Connection con = null;	
		
		
		try{
			con = abrir_conexion();
			ResultSet result = ejecutar_query(con,"select id, fase, umbral, tiempo, dispositivo from Sucesos "
					+ "where activo = 'Si' and tipo = 'tension_sobre' " + dispositivo + " order by id");
			List<SucesoTensionSobre> listaSucesos = new ArrayList<SucesoTensionSobre>();
			while (result.next()){
				SucesoTensionSobre Suceso=
					new SucesoTensionSobre(result.getInt("id"),result.getString("dispositivo"),
					result.getInt("umbral"),result.getInt("tiempo"), result.getString("fase"));
				listaSucesos.add(Suceso);
			}
			
			result.close();
			return listaSucesos;
			
		}catch(Exception ex){
			setUltimoError(ex.getMessage());
			return null;			
		}finally{
			cerrar_conexion(con);
		}		
	}
	
	public List<SucesoTensionSub> obtener_sucesosTensionSub(String dispositivo){
		
		if (dispositivo!=null && dispositivo!=""){
			dispositivo=" and dispositivo = '" + dispositivo + "'";
		}else{
			dispositivo="";
		}
		
		Connection con = null;		
		try{
			con = abrir_conexion();
			ResultSet result = ejecutar_query(con,"select id, fase, umbral, tiempo, dispositivo from Sucesos "
					+ "where activo = 'Si' and tipo = 'tension_sub' " + dispositivo + " order by id");
			List<SucesoTensionSub> listaSucesos = new ArrayList<SucesoTensionSub>();
			while (result.next()){
				SucesoTensionSub Suceso=
					new SucesoTensionSub(result.getInt("id"),result.getString("dispositivo"),
					result.getInt("umbral"),result.getInt("tiempo"), result.getString("fase"));
				listaSucesos.add(Suceso);
			}
			result.close();
			return listaSucesos;
			
		}catch(Exception ex){
			setUltimoError(ex.getMessage());
			return null;			
		}finally{
			cerrar_conexion(con);
		}		
	}
	
	public List<SucesoReactiva> obtener_sucesosReactiva(String dispositivo){
		
		if (dispositivo!=null && dispositivo!=""){
			dispositivo=" and dispositivo = '" + dispositivo + "'";
		}else{
			dispositivo="";
		}
		
		Connection con = null;		
		try{
			con = abrir_conexion();
			ResultSet result = ejecutar_query(con,"select id, umbral, tiempo, dispositivo from Sucesos "
					+ "where activo = 'Si' and tipo = 'reactiva' " + dispositivo + " order by id");
			List<SucesoReactiva> listaSucesos = new ArrayList<SucesoReactiva>();
			while (result.next()){
				SucesoReactiva Suceso=
					new SucesoReactiva(result.getInt("id"),result.getString("dispositivo"),
					result.getInt("umbral"),result.getInt("tiempo"));
				listaSucesos.add(Suceso);
			}
			result.close();
			return listaSucesos;
			
		}catch(Exception ex){
			setUltimoError(ex.getMessage());
			return null;			
		}finally{
			cerrar_conexion(con);
		}		
	}
	
	public List<UsuarioSuceso> obtener_usuariosSuceso(int idSuceso){
		Connection con =abrir_conexion();
		try
		{
			ResultSet result = this.ejecutar_query(con, "select Id_suceso, Medio, "
					+ "Nombre, Email, Telefono from Suceso_Usuario "
					+ "inner join Usuarios on Suceso_Usuario.Id_usuario=Usuarios.Id"  
					+ " where Suceso_Usuario.Id_suceso=" + idSuceso );
			
			List<UsuarioSuceso> lista = new ArrayList<UsuarioSuceso>();
			
			while (result.next()){
				lista.add( new UsuarioSuceso (result.getInt("Id_suceso"),
						result.getString("Nombre"), result.getString("Medio"), result.getString("Email"), 
						result.getInt("Telefono") ));
			}
			
			return lista;
			
		}catch(Exception ex){
			return null;
		}finally{
			cerrar_conexion(con);
		}
	}
	
	public boolean GrabarHistoSuceso(int idSuceso, Date FechaInicial, Date FechaFinal, float Valor){
		
		Connection con =abrir_conexion();
		try
		{
			String query = "INSERT INTO Historico_Sucesos (Id_Suceso,Fecha_inicio,Fecha_fin,valor)" +
				"VALUES	(" + idSuceso + ", " +
				"'" + modelo.Fechas.sdfBD.format(FechaInicial) +  "', " +
				"'" + modelo.Fechas.sdfBD.format(FechaFinal) + "', " +
				Valor + ")";
			
			return this.ejecutar_updateDelete(con, query);
												
		}catch(Exception ex){
			return false;
		}finally{
			cerrar_conexion(con);
		}
	}
		
	public boolean SucesoReactivaAvisado(int idSuceso){
		Connection con = abrir_conexion();
		try
		{
			Calendar calendar = Calendar.getInstance();			
			calendar.getTime();
			int mes = calendar.get(Calendar.MONTH)+1;
			int mesSuceso=0;		
			boolean avisado=false;
			
			String query = "SELECT month(fecha_fin) mes From Historico_Sucesos Where Id_Suceso = " + idSuceso + " order by fecha_fin desc";
			
			ResultSet res = this.ejecutar_query(con, query);
			while (res.next()){
				mesSuceso = res.getInt("mes");
				if (mes==mesSuceso){
					avisado=true;
					break;
				}
			}		
			
			return avisado;
			
		}catch(Exception ex){
			
			return false;
			
		}finally{
			
			cerrar_conexion(con);
			
		}
	}
	
	public boolean SucesoDesconexionAvisado(int idSuceso){
		Connection con = abrir_conexion();
		try
		{
			Calendar calendar = Calendar.getInstance();			
			calendar.getTime();
			int dia = calendar.get(Calendar.DAY_OF_MONTH);
			int diaSuceso=0;		
			boolean avisado=false;
			
			String query = "SELECT dayofmonth(fecha_fin) dia From Historico_Sucesos Where Id_Suceso = " + idSuceso + " order by fecha_fin desc";
			
			ResultSet res = this.ejecutar_query(con, query);
			while (res.next()){
				diaSuceso = res.getInt("dia");
				if (dia==diaSuceso){
					avisado=true;
					break;
				}
			}		
			
			return avisado;
			
		}catch(Exception ex){
			
			return false;
			
		}finally{
			
			cerrar_conexion(con);
			
		}
	}
}
