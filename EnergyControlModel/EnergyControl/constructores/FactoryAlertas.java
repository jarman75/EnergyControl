package constructores;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import funcionesBD.*;
import modelo.*;

public class FactoryAlertas {
	//lista contenedora de alertas
	private List<Alerta> Alertas;
			
	public FactoryAlertas(){
		setAlertas(null);
	}
	
	public List<Alerta> getAlertas() {
		return Alertas;
	}

	public void setAlertas(List<Alerta> alertas) {
		Alertas = alertas;
	}

	public boolean Generar_Alertas(){
		
		
		try {
			// acceso BD
			ContadoresBD contadorBD = new ContadoresBD();
			SucesosBD sucesosBD = new SucesosBD();
			
			Alertas = new ArrayList<Alerta>();
			
			//leer dispositivos con sucesos		
			List<Dispositivo> dispos = contadorBD.obtener_dispositivosEnSucesos(null);
			if (dispos==null) throw new Exception("no hay dispositivos con sucesos");
			
			
			Calendar calendar=Calendar.getInstance();
			Date FechaHora = calendar.getTime();
			
			for (Dispositivo dispo: dispos){			
											
				int periodoDispo = contadorBD.obtener_periodoDispositivo(dispo.getNombre(), FechaHora);
				
				//lista contenedora de sucesos del dispositivo
				List<Suceso> sucesos = sucesosBD.obtener_sucesos(dispo.getNombre(),periodoDispo);
				
				if (sucesos!=null){
					for  (Suceso suceso: sucesos){
						
						Alerta alerta = new Alerta();
						//se añade dispositivo al suceso
						alerta.setDispositivo(dispo);
						//se añade suceso
						alerta.setSuceso(suceso);
						//se añade lista usuarios para aviso del suceso
						List<UsuarioSuceso> listaUsuarios = sucesosBD.obtener_usuariosSuceso(suceso.getId());
						if (listaUsuarios!=null){
							alerta.setListaUsuarios(listaUsuarios);
						}
						
						//se añade alerta a lista de alertas
						Alertas.add(alerta);
					}
				}
				
				
				
			}
			
			return true;
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
			return false;
		}
				
		
	}
	
	
}
