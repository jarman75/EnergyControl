package modelo;

public class SucesoTensionSobre extends Suceso{
	
	public SucesoTensionSobre(int id, String dispositivo, int valorMaximo,
			int intervaloMinutos, String fase) {
		super(id, dispositivo, valorMaximo, intervaloMinutos, "Electricidad", 0, fase);
		Fase=fase;
	}
	
	
	protected String Fase;
	
	public String getFase() {
		return Fase;
	}
	public void setFase(String fase) {
		Fase = fase;
	}

}
