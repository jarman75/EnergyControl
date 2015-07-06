package funcionesHTTP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class HTTPGenerico implements SolicitudHTTP {

	protected String ipRemota="";
	protected int puerto=80;
	protected String ruta="";
	
	
	public HTTPGenerico(String ipRemota, String ruta) {	
		this.ipRemota=ipRemota;
		this.ruta=ruta;
	}					
	
	public HTTPGenerico(String ipRemota, int puerto, String ruta){
		this.ipRemota=ipRemota;
		this.puerto=puerto;
		this.ruta=ruta;
	}
	
	
	public DOMSource ExecutaDOM(){
		
		try {
			URL url = new URL(this.getUrl().toString());
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(60000);
			connection.setReadTimeout(60000);			
			org.w3c.dom.Document doc = parseXML(connection.getInputStream());
			if (doc==null) throw new Exception("error obteniendo datos.");			
			DOMSource domSource=new DOMSource(doc);
			return domSource;		
		} catch (Exception e) {
			return null;
		}
        
	}
	
	public StreamResult Execute(String rutaFichero) {
		
		//se declara resultado
		StreamResult resultado = null;		
		//se declara file stream
		FileOutputStream fichero = null;		
		
		try{
			
			
			URL url = new URL(this.getUrl().toString());
	        URLConnection connection = url.openConnection();
	        connection.setConnectTimeout(60000);
	        connection.setReadTimeout(60000);
	        
	        org.w3c.dom.Document doc = parseXML(connection.getInputStream());
	        if (doc==null) throw new Exception("error obteniendo datos.");					
	        
	        if (rutaFichero==null || rutaFichero==""){
	        	
	        	fichero=null;	        	        	

	            DOMSource domSource=new DOMSource(doc);	            
	            
	            StringWriter stringWriter=new StringWriter();	            
	            StreamResult result = new StreamResult(stringWriter);	            
	            
	            TransformerFactory tFactory =TransformerFactory.newInstance();
	            Transformer transformer = tFactory.newTransformer();
	            transformer.setOutputProperty("indent","yes");
	            
	            transformer.transform(domSource, result);        
	            resultado=result;
           	    				
	        }else{			
				//escribir documento en un fichero xml
				DOMSource domsrc= new DOMSource(doc);			
				fichero = new FileOutputStream( new File(rutaFichero));
				resultado = new StreamResult(fichero);
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer transformer = tf.newTransformer();
				transformer.transform(domsrc, resultado);
	        }
								
		}
		catch (Exception ex){
			System.out.println("error peticion http.");
			//ex.printStackTrace();					
			
		}
		finally{
			try {
				if (fichero!=null) fichero.close();
				System.out.println("proceso finalizado...");
			}
			catch(IOException ex){
				System.out.println("error acceso fichero respuesta xml.");
				//ex.printStackTrace();
			}
		}
		
								
		return resultado;
	}

	private Document parseXML(InputStream inputStream) {
		javax.xml.parsers.DocumentBuilderFactory dbf=null;
		javax.xml.parsers.DocumentBuilder db=null;		
        Document doc = null;       
        
        
        try
        {
        	//se crean objetos para manejo xml    		
    		dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
    		db=dbf.newDocumentBuilder();
    		doc = db.parse(inputStream);        	
                }
        catch(Exception ex)
        {
            return null;
        }       

        return doc;
	}

	
	public int getPuerto() {
		// TODO Auto-generated method stub
		return this.puerto;
	}
	
	public void setPuerto(int puerto) {
		// TODO Auto-generated method stub
		this.puerto=puerto;

	}
	
	public String getIpRemota() {
		// TODO Auto-generated method stub
		return this.ipRemota;
	}
	
	public void setIpRemota(String ipRemota) {
		// TODO Auto-generated method stub
		this.ipRemota=ipRemota;

	}
	
	public String getRuta() {
		// TODO Auto-generated method stub
		return this.ruta;
	}
	
	public void setRuta(String ruta) {
		// TODO Auto-generated method stub
		this.ruta=ruta;

	}	
		
	public java.net.URL getUrl() {		 
		URI uriPeticion;
		try {
			uriPeticion = new URI("http://" + this.ipRemota + ":" + this.puerto + "/" + this.ruta);
			uriPeticion.toURL();
			java.net.URL auxURL=null;			
			auxURL= uriPeticion.toURL();
			return auxURL;
		} catch (URISyntaxException e) {			
			e.printStackTrace();
			return null;
		} catch (MalformedURLException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	

}
