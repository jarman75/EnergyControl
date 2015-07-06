package modelo;

public class SucesoPotencia extends Suceso{

	protected String Periodo;
		
	public SucesoPotencia(int id, String dispositivo, int valorMaximo,
			int intervaloMinutos, String periodo, int periodoElectrico) {
		super(id, dispositivo, valorMaximo, intervaloMinutos, "Electricidad", periodoElectrico, "potencia");
		Periodo=periodo;
		
	}

	public String getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}

}
