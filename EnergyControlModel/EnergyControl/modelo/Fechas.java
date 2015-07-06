package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Fechas {
	public static SimpleDateFormat sdfLocal = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	public static SimpleDateFormat sdfLocalDia = new SimpleDateFormat("dd-MM-yyyy");
	public static SimpleDateFormat sdfBD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdfBDdia = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	public static SimpleDateFormat sdfHora = new SimpleDateFormat("HH");
	
	public static Date parseDate(String date, SimpleDateFormat sdf)
	{
	    
	    Date fecha;
		try {
			fecha = sdf.parse(date);
			return fecha;
		} catch (ParseException e) {			
			return null;
		}    
	}

}
