package funcionesXML;

import org.w3c.dom.Node;

public class XmlUltimaTrama extends XmlLectura{

	public XmlUltimaTrama(String rutaFichero, String[] Elementos, String ElementoPadre) {
		super(rutaFichero, Elementos,ElementoPadre,false);		
	}
	public XmlUltimaTrama(String rutaFichero){
		super(rutaFichero, new String[]{"hora","Vm","Vn","P","T","QVm","QVn","al"},"lec",false);
	}
	@Override
	protected void addListaTrama(Node elemento) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
