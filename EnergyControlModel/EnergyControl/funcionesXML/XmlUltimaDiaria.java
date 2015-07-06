package funcionesXML;

import org.w3c.dom.Node;

public class XmlUltimaDiaria extends XmlLectura {

	public XmlUltimaDiaria(String rutaFichero, String[] Elementos, String ElementoPadre) {
		super(rutaFichero, Elementos, ElementoPadre,false);
	}
	public XmlUltimaDiaria(String rutaFichero){
		super(rutaFichero,new String[]{"hora","Vm","Vn","P","T","IVm","IVn","IVmE","IVnE","IVm_max","IVn_max","IVm_min","IVn_min","QVm_max","QVn_max","QVm_min","QVn_min","ntr","ntc"},"lec",false);
	}
	@Override
	
	protected void addListaTrama(Node elemento) {
		// TODO Auto-generated method stub
		
	}
	

}
