package funcionesXML;

import org.w3c.dom.Node;

public class XmlUltimaTramaKroms extends XmlLectura{

	public XmlUltimaTramaKroms(String rutaFichero, String[] Elementos, String ElementoPadre) {
		super(rutaFichero, Elementos, ElementoPadre,false); 
	}
	
	public XmlUltimaTramaKroms(String rutaFichero) {
		super(rutaFichero, new String[]{"fecha","vb","vn","presion","temperatura",
				"qb","qn","estado"},"datos",false); 
	}

	@Override
	protected void addListaTrama(Node elemento) {
		// TODO Auto-generated method stub
		
	}

	
	

}
