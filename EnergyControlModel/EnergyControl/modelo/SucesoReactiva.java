package modelo;

public class SucesoReactiva extends Suceso {

	public SucesoReactiva(int id, String dispositivo, int valorMaximo,
			int intervaloMinutos) {
		super(id, dispositivo, valorMaximo, intervaloMinutos, "Electricidad", 0, "reactiva");		
	}

}
