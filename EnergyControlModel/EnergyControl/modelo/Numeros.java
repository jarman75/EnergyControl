package modelo;

public class Numeros {
	

	public static boolean esNumero(String valor){
		try{
			@SuppressWarnings("unused")
			float n = Float.parseFloat(valor);			
			return true;
		}catch (Exception ex){
			return false;
		}
		
	}
}
