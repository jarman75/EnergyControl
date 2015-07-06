package funcionesXML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Enumeration;
import java.util.Hashtable;



public abstract class XmlLectura {
	protected String RutaFichero;
	protected String[] Elementos;
	protected String ElementoPadre;
	protected Hashtable<String, String> ElementosXML = new Hashtable<String, String>();	
	protected String ultimoError="";
	protected int NElementos=0;
	
	public XmlLectura(String rutaFichero, String[] elementos, String elementoPadre, boolean ResultadosEnLista) {		
		this.RutaFichero=rutaFichero;
		this.Elementos = elementos;
		this.ElementoPadre=elementoPadre;
		if (ResultadosEnLista){
			this.CargarLista();
		}else{
			this.Cargar();
		}
	}
	
	public String getUltimoError() {
		return this.ultimoError;
	}

	protected void setUltimoError(String ultimoError) {
		this.ultimoError = ultimoError;
	}

	public int getNElementos() {
		return this.NElementos;
	}
	
	public Hashtable<String, String> getElementosXML() {
		return ElementosXML;
	}
	
	protected String[] DateTags = new String[] {"fe","fx","fy","tx","ty","dx","dy","sx","sy"};
	
	
	
	protected void putValor(String Clave, String Valor){		
	    getElementosXML().put(Clave,Valor);	    
	}
	
	public void Out(){		
		
		Enumeration<String> claves = this.getElementosXML().keys();
		 while( claves.hasMoreElements() ) {
			 Object clave = claves.nextElement();
		     Object valor = this.getElementosXML().get(clave);
		     System.out.println("Elemento: " + clave.toString() + ", valor:  " + valor.toString());			 
		 }
		     	
		     
	}
    	
	protected void Cargar() {
		
		try {
			  File file = new File(RutaFichero);
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();			  
			  
			  String rootNode = doc.getDocumentElement().getNodeName();			  			  
			  NodeList nodeLst = doc.getElementsByTagName(rootNode);			  

			  for (int s = 0; s < nodeLst.getLength(); s++) {
			    
				  Node fstNode = nodeLst.item(s);			    
				  
				  if ((fstNode.getNodeType() == Node.ELEMENT_NODE) && (fstNode.getNodeName() == this.ElementoPadre)) {			      
			    	
			    	this.NElementos++;
			    	Element fstElmnt = (Element) fstNode;
			    	
			    	for (int e = 0; e < this.Elementos.length; e++){
			    		
			    		NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(Elementos[e]);
			    		Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
					    
			    		if (fstNmElmnt!=null && fstNmElmnt.hasChildNodes()){
					    	NodeList fstNm = fstNmElmnt.getChildNodes();					    
					    	this.putValor(Elementos[e], ((Node) fstNm.item(0)).getNodeValue());
					    	
					    	//atributos
					    	if (fstNmElmnt.hasAttributes()){
					    		org.w3c.dom.NamedNodeMap att = fstNmElmnt.getAttributes();
					    		for (int a=0;a<att.getLength();a++){	    			
					    			
					    			this.putValor(Elementos[e]+"_"+att.item(a).getNodeName(), fstNmElmnt.getAttribute(att.item(a).getNodeName()));
					    		}
					    	}
					    	
					    	//if (fstNmElmnt.hasAttribute("hr")){
					    	//	String valAtributo = fstNmElmnt.getAttribute("hr");
					    	//	this.putValor(Elementos[e]+"_hr", valAtributo);					    		 
					    	//}
					    }else{
					    	this.putValor(Elementos[e], "null");
					    }
					    
			    	}		      
			    }
			    
			  }
			  
		  } catch (Exception e) {
			  	this.setUltimoError(e.getMessage());
			  	this.NElementos=0;
			    e.printStackTrace();
		  }
		
	}

	
	protected void CargarLista() {
		
		try {
			  
			  File file = new File(this.RutaFichero);			  
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();			  
			  String rootNode = doc.getDocumentElement().getNodeName();			  			  
			  NodeList nodeLst = doc.getElementsByTagName(rootNode);			  

			  for (int s = 0; s < nodeLst.getLength(); s++) {			    
				  Node fstNode = nodeLst.item(s);				  
				  if (fstNode.getNodeType() == Node.ELEMENT_NODE) 
				  {			    	
					  	Element fstElmnt = (Element) fstNode;			    		
			    		NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(this.ElementoPadre);					    
			    		for (int j=0; j<fstNmElmntLst.getLength();j++)
					    {
			    			Element fstNmElmnt = (Element) fstNmElmntLst.item(j);			    							    	
						    //atributos del nodo
						    if (fstNmElmnt.getNodeName()==this.ElementoPadre && fstNmElmnt.hasAttributes()){						    		
						    	addListaTrama(fstNmElmnt);						    	
						    }						    
					    }
				  }				  
			  }			  
			  
		  } catch (Exception e) {
			  	this.setUltimoError(e.getMessage());
			  	this.NElementos=0;
			    e.printStackTrace();
		  }
		
	}

	protected abstract void addListaTrama(Node elemento);

	

	


	
}
