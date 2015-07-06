package funcionesHTTP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;




public class SolicitudPHP {
	private static final String USER_AGENT= "Mozilla/5.0";	
	private static String StrURL="";
	private static String StrError="";
	private static StringBuffer RespuestaPHP;
	
	private static Hashtable<String,String> Parametros= new Hashtable<String,String>();
	
	public static Hashtable<String,String> getParametros() {
		return Parametros;
	}

	public static void setParametro(String Clave, String Valor){		
	    getParametros().put(Clave,Valor);	    
	}

	public static String getStrError() {
		return StrError;
	}

	public static void setStrError(String strError) {
		StrError = strError;
	}

	public static String getStrURL() {
		return StrURL;
	}

	public static void setStrURL(String strURL) {
		StrURL = strURL;
	}

	
	public static StringBuffer getRespuestaPHP() {
		return RespuestaPHP;
	}

	public static void setRespuestaPHP(StringBuffer respuestaPHP) {
		RespuestaPHP = respuestaPHP;
	}

	public static int sendPost(){
				
		
		//conectando
		try {
			
			//montando la url
			URL url=null;		
			url = new URL(StrURL);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//cabecera de la petición
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
	        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");	        
	        con.setDoOutput(true);	        	        
	                
	        
	        
	        String urlParametros="";
                  
	        urlParametros=ConcatParams();
	        
	        
                                    
            // Enviamos los datos por POST
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParametros);
            wr.flush();
            wr.close();
            //Capturamos la respuesta del servidor
            int Respuesta = con.getResponseCode();
            
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParametros);
            System.out.println("Response Code : " + Respuesta);
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            //Mostramos la respuesta del servidor por consola
            System.out.println(response);
            //cerramos la conexión
            in.close();
            
	        setRespuestaPHP(response);
            
	        return Respuesta;
	        
		} catch (Exception e) {
			setStrError(e.getMessage());
			return 0;
		}
		
	}
	
	private static String ConcatParams()
    {
        try {
			boolean FirstParam = true;
			StringBuilder Parametros = null;
			
			Parametros = new StringBuilder();
			    
			Enumeration<String> claves = getParametros().keys();
			while( claves.hasMoreElements() ) {
				
				String clave = claves.nextElement();
				String valor = getParametros().get(clave);
				clave = URLEncoder.encode(clave, "UTF-8");
				valor = URLEncoder.encode(valor, "UTF-8");
				Parametros.append(FirstParam ? "" : "&");
				Parametros.append(clave + "=" + valor);		
				
				FirstParam = false;   		 		
							 
			}      
			
	
			
			
			return Parametros == null ? "": Parametros.toString();
		} catch (UnsupportedEncodingException e) {			
			return "";
		}
    }

	
}
