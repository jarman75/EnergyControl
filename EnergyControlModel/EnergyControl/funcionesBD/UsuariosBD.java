package funcionesBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsuariosBD extends AccesoBD{
	
	public UsuariosBD() {		
		super.UltimoError="";
		//super.server="192.168.1.249";		
		super.bd="LecturasGas";
		super.user="root";
		super.psw="EnergyAdminPlus";
	}

	public List<Usuario> obtener_usuarios(String FiltroUsuario){
		Connection con = null;
		try{
			con=abrir_conexion();
			ResultSet result = ejecutar_query(con,"select Id, Nombre, Password, Telefono, Email, Tipo from Usuarios where advanced='si' " + FiltroUsuario);
			
			List<Usuario> listaUsuarios=new ArrayList<Usuario>();
			
			while (result.next()){
				Usuario user = new Usuario(result.getInt("id"),result.getString("Nombre"),result.getString("Password"),
						result.getString("Tipo"), result.getInt("Telefono"),result.getString("Email"));
				listaUsuarios.add(user);
			}
			
			result.close();
			return listaUsuarios;
			
		}catch (Exception ex) {
			return null;
		}finally{
			cerrar_conexion(con);
		}
		
	}
		
	public List<Usuario> obtener_usuariosEnSucesos(String usuario){
		if (usuario!=null || usuario=="")
			usuario=" and Nombre = '" + usuario + "'";		
		return obtener_usuarios("and Id in (Select Id_Usuario from Suceso_Usuario) " + usuario);
	}
}
