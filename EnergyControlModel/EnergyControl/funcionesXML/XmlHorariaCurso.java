package funcionesXML;

import org.w3c.dom.Node;

public class XmlHorariaCurso extends XmlLectura{

	public XmlHorariaCurso(String rutaFichero, String[] Elementos, String ElementoPadre) {
		super(rutaFichero, Elementos, ElementoPadre,false);
	}
	public XmlHorariaCurso(String rutaFichero) {
		super(rutaFichero, new String[]{"hora","Vm","Vn","P","T","QVm","QVn","IVm",
				"IVn","IVmE","IVnE","ntr","ntc"},"lec",false);
	}
	@Override
	protected void addListaTrama(Node elemento) {
		// TODO Auto-generated method stub
		
	}
	

}
