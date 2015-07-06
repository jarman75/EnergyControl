package funcionesXML;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import modelo.TramaDiaria;
import modelo.Fechas;



public class XmlUltimaDiariaKroms extends XmlLectura {

		
	public XmlUltimaDiariaKroms(String rutaFichero, String[] elementos,
			String elementoPadre) {
		super(rutaFichero, elementos, elementoPadre,true);		
	}
	public XmlUltimaDiariaKroms(String rutaFichero){
		super(rutaFichero, new String []{"fe","ct","tb","tn","eb","en","vx","fx","yy",
				"fy","qx","tx","qy","ty","bx","dx","by","dy","kx","sx","ky","sy"},"e_lt",true);
		
	}
	
	
	protected List<TramaDiaria> tramasDiarias;
	public List<TramaDiaria> obtener_tramasDiarias() {
		return tramasDiarias;
	}	
	
	protected void addListaTrama(Node elemento)	
	{		
	
		TramaDiaria th = new TramaDiaria();		
		
		try {
			
			for (int i=0;i<elemento.getAttributes().getLength();i++)
			{						    			
				Node att = (Node) elemento.getAttributes().item(i);
				if ( Arrays.asList(DateTags).contains(att.getNodeName()) == false){
					th.setTagXml(att.getNodeName(), att.getNodeValue());						    				
				}else{						    				
					//conversión fecha
					SimpleDateFormat sdf = new SimpleDateFormat("yyDDDHHmm");
					sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
					Date auxFecha=Fechas.parseDate(att.getNodeValue(),sdf);
					
					String fbd=Fechas.sdfBDdia.format(auxFecha);
					th.setTagXml(att.getNodeName(), fbd);
				}
			}
			
			if (tramasDiarias==null) {
				tramasDiarias = new ArrayList<TramaDiaria>();
			}
			this.tramasDiarias.add(th);
			
		} catch (DOMException e) {			
			e.printStackTrace();			
		} 

	}
		

	
	
	

}
