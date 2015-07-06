package funcionesXML;

import modelo.TramaHoraria;
import modelo.Fechas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.TimeZone;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;


public class XmlUltimaHorariaKroms extends XmlLectura {
	
		
	public XmlUltimaHorariaKroms(String rutaFichero, String[] Elementos, String ElementoPadre) {
		super(rutaFichero, Elementos, ElementoPadre,true);		
	}
	public XmlUltimaHorariaKroms(String rutaFichero){
		super(rutaFichero, new String []{"fe","vb","vn","db","dn","qb","qn",
				"eb","en","pm","tm","nt"},"e_lc",true);
		
	}
		
	protected List<TramaHoraria> tramasHorarias;	
	public List<TramaHoraria> obtener_tramasHorarias()	
	{
		return this.tramasHorarias;		
	}
	
	protected void addListaTrama(Node elemento) {
		TramaHoraria th = new TramaHoraria();		
		
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
					String fdb=Fechas.sdfBD.format(auxFecha);
					th.setTagXml(att.getNodeName(), fdb);
				}
			}
			
			if (tramasHorarias==null) {
				tramasHorarias = new ArrayList<TramaHoraria>();
			}
			this.tramasHorarias.add(th);
			
		} catch (DOMException e) {			
			e.printStackTrace();			
		} 
		
	}

		
	
	
	
}
