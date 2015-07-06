package funcionesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD  {
	 
	protected String server;
	protected String bd;
	protected String user;
	protected String psw;
	
	protected String UltimoError;

	public AccesoBD() {
		server="192.168.1.249";
		bd="";
		user="";
		psw="";
		UltimoError="";
	}
	
	
	protected void setUltimoError(String ultimoError) {
		UltimoError = ultimoError;
	}
	
	public String getUltimoError() {
		return UltimoError;
	}
	
	protected boolean cerrar_conexion(Connection con){
	
	try {
		if (con!=null) con.close();
		return true;
	} catch (SQLException e) {
		setUltimoError(e.getMessage());
		return false;
	}	

}

	protected Connection abrir_conexion(){
	

	try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();			
		}catch(Exception e){	
			setUltimoError(e.getMessage());
			return null;
		}
	
	
	Connection con=null;	
	try {
		
		con =DriverManager.getConnection("jdbc:mysql://" + this.server + "/" + this.bd + "?"
				+"user=" + this.user +"&password=" + this.psw);
		return con;		
	} catch (SQLException ex) {		
		setUltimoError(ex.getMessage());
		return null;
	}
	
}

	
	protected ResultSet ejecutar_query(Connection con, String query){	
	
	ResultSet rs = null;
	Statement cmd = null;	
	
	try {
		cmd=con.createStatement();
		rs = cmd.executeQuery(query);
		return rs;
	} catch (SQLException e) {		
		setUltimoError(e.getMessage());
		return null;
	}	
	
	
}

	protected boolean ejecutar_updateDelete(Connection con, String query){
	Statement cmd = null;
	try{
		cmd = con.createStatement();
		cmd.executeUpdate(query);
		return true;
	} catch (SQLException e) {	
		setUltimoError(e.getMessage()); 
		return false;
	}
}

	

}