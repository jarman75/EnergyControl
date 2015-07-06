package modelo;

import java.util.Calendar;
import java.util.Date;
import funcionesBD.SucesosBD;

public class Suceso {
	
	public Suceso(int id, String dispositivo, float valorMaximo, int intervaloMinutos, 
			String energia, int periodoElectrico, String variable) {
		
		Id=id;
		Dispositivo = dispositivo;
		ValorMaximo = valorMaximo;
		if (intervaloMinutos>0){ 
			IntervaloMinutos = intervaloMinutos;
		}else{
			IntervaloMinutos = 1;
		}
		Energia = energia;
		PeriodoElectrico=periodoElectrico;
		Variable=variable;
		
		AlertaActiva=false;
		setValorAlerta(0);
				
		minutoActual=0;
		tramaActual=0;
		
		ValorActual=null;
		ValorActual = new float[IntervaloMinutos][60];
		
	}
		
	protected int Id;
	protected String Dispositivo;
	protected String Energia;
	protected int PeriodoElectrico;	
	protected String Variable;
	protected float ValorMaximo;
	protected int IntervaloMinutos;	
		
	private boolean AlertaActiva;
	private Date AlertaFecha;
	private Date AlertaFechaInicial;
	private float ValorAlerta;	
	
	private float ValorActual[][];	
	private int minutoActual;
	private int tramaActual;
		
	public int getMinutoActual() {
		return minutoActual;
	}

	public void setMinutoActual() {
		
		if (this.minutoActual<IntervaloMinutos-1){
			++this.minutoActual;
		}else{
			this.minutoActual=0;	
			this.tramaActual=0;
		}
	}	
		
	public int getTramaActual() {
		return tramaActual;
	}

	public void setTramaActual() {
		if (this.tramaActual<59){
			++this.tramaActual;
		}else{
			this.tramaActual=0;
			this.setMinutoActual();
		}
	}

	public String getVariable() {
		return Variable;
	}

	public void setVariable(String variable) {
		Variable = variable;
	}		

	public int getPeriodoElectrico() {
		return PeriodoElectrico;
	}

	public void setPeriodoElectrico(int periodoElectrico) {
		PeriodoElectrico = periodoElectrico;
	}

	public String getEnergia() {
		return Energia;
	}

	public void setEnergia(String energia) {
		Energia = energia;
	}
	
	public boolean isAlertaActiva() {
		return AlertaActiva;
	}
	
	public void setValorActual(float valorActual) {		
		
		//Calendar calendario = Calendar.getInstance();;
		//Date fechaAhora = calendario.getTime();
			
		
		try {
			switch(Variable){
			case "potencia":
				//ver si estamos en periodo afectado, para sucesos potencia			
				//ContadoresBD contador = new ContadoresBD();
				//int periodoActual = contador.obtener_periodoDispositivo(Dispositivo, fechaAhora);
				//if (PeriodoElectrico!=0 && periodoActual!=PeriodoElectrico) {																
				//	return; 
				//}
				break;
			case "reactiva":
				//si se avisó ya este mes por reactiva, no avisa más
				SucesosBD suces = new SucesosBD(); 
				if (suces.SucesoReactivaAvisado(this.Id)){
					return;
				};
				
				if (valorActual>ValorMaximo){
					this.setAlertaActiva(true);
					this.setValorAlerta(valorActual);
				}			
				return;
			case "desconexion":
				//si se avisó ya este día por desconexión, no avisa más
				SucesosBD sucesdes = new SucesosBD(); 
				if (sucesdes.SucesoDesconexionAvisado(this.Id)){
					return;
				};			

				if (valorActual>ValorMaximo){
					this.setAlertaActiva(true);
					this.setValorAlerta(valorActual);								
				}
				return;
			default:
				return;				
			}
			
			ValorActual[minutoActual][tramaActual] = valorActual;		
			
			if (minutoActual==IntervaloMinutos-1 && tramaActual==59){		
				float media = obtener_mediaValor();			
				
				ValorActual=null;
				ValorActual = new float[IntervaloMinutos][60];
				
				if (media > ValorMaximo){	
					//activar alerta
					this.setAlertaActiva(true);	
					this.setValorAlerta(media);
				}			
				
			}
			
			this.setTramaActual();
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
	}

	private float obtener_mediaValor() {
		
		//calcular media minuto
		float media=0;
		float maximo=0;
		float suma=0;
		
		for (int m=0;m<IntervaloMinutos;m++){
			for (int t=0;t<60;t++)
			{
				suma+=ValorActual[m][t];
				if (ValorActual[m][t]>maximo) maximo=ValorActual[m][t];
			}
		}
		media = suma / (IntervaloMinutos*60);
		return media;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDispositivo() {
		return Dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		Dispositivo = dispositivo;
	}

	public float getValorMaximo() {
		return ValorMaximo;
	}

	public void setValorMaximo(int valorMaximo) {
		ValorMaximo = valorMaximo;
	}

	public int getIntervaloMinutos() {
		return IntervaloMinutos;
	}

	public void setIntervaloMinutos(int intervaloMinutos) {
		IntervaloMinutos = intervaloMinutos;
	}
	
	public void setAlertaActiva(boolean alertaActiva) {		
		AlertaActiva = alertaActiva;
		//setAlertaFecha(null);
		//setAlertaFechaInicial(null);
		
		if (alertaActiva){
			Calendar calendario = Calendar.getInstance();;
			Date fechaAhora = calendario.getTime();	
			setAlertaFecha(fechaAhora);
			
			calendario.add(Calendar.MINUTE, IntervaloMinutos*(-1));
			Date fechaInicial=calendario.getTime();
			setAlertaFechaInicial(fechaInicial);
			
		}
	}

	public Date getAlertaFecha() {
		return AlertaFecha;
	}

	public void setAlertaFecha(Date alertaFecha) {
		AlertaFecha = alertaFecha;
	}

	public Date getAlertaFechaInicial() {
		return AlertaFechaInicial;
	}

	public void setAlertaFechaInicial(Date alertaFechaInicial) {
		AlertaFechaInicial = alertaFechaInicial;
	}

	public float getValorAlerta() {
		return ValorAlerta;
	}

	public void setValorAlerta(float valorAlerta) {
		ValorAlerta = valorAlerta;
	}

		
}
