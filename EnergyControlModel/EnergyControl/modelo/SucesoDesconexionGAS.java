package modelo;

public class SucesoDesconexionGAS extends Suceso {

	public SucesoDesconexionGAS(int id, String dispositivo, float valorMaximo,
			int intervaloMinutos) {
		super(id, dispositivo, valorMaximo, intervaloMinutos, "Gas",
				0, "desconexion");
		
	}

}
