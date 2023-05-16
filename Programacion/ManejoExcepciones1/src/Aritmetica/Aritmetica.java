
package Aritmetica;

import excepciones.OperacionExcepcion;
//aunque Java ya tiene una excepcion para eso, nosotros construimos una nueva
public class Aritmetica {
//creamos un metodo, y como sabemos que puede tirar una excepcion, lo declaramos con
//"throws (nombre excepcion)"
    public static int division(int numerador, int denominador) throws OperacionExcepcion{
//si OperacionExepcion heredara de RuntimeException no sería necesario aclarar en el
//metodo que excepcion tira este (menos codigo, mas limpio) 
//pero la ejecucion terminaria abruptamente
//en los comienzos se recomendaba que las excepciones fueran hijas de Exception
//hoy es mas recomendado que sean hijas de RuntimeException, solo se recomienda 
//que sean hijas de Exception (con los TryCatch como consecuencia) si estamos 
//seguros que se da la excepcion, donde se requiere realmente
        if (denominador == 0){
//aca es que tira la excepcion, antes de que Java ejecute el /0;
            throw new OperacionExcepcion("Division por cero");
        }
        return numerador / denominador;
    }
}
