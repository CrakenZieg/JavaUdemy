
package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversiones {
    
//definimos un formato general de fecha
    private static final String FORMATO_FECHA = "dd-mm-yyyy";
    
//definimos un metodo que toma como parametro un tipo Date y devuelve un String
//con el formato general que creamos, usado por un objeto de clase SimpleDateFortmat
    public static String format(Date fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
//Creamos otro format que reciba un objeto de tipo String para poder mandar uno que 
//no puede formatear, intentamos crear un error
    public static String format(String fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
    
}
