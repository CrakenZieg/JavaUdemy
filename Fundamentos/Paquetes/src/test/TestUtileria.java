//paquete donde esta la clase
package test;
//imports
//import ar.com.nombreproyecto.Utileria;
//import ar.com.nombreproyecto.*; importaria todas las clases (solo las importa si las usa)
//lo que exporta
//es posible importar solo metodos estaticos
import static ar.com.nombreproyecto.Utileria.imprimir;

public class TestUtileria {
    
    public static void main(String[] args) {
        imprimir("Saludos"); 
//si no importaba solo los metodos estaticos, deberia haber escrito:
//Utileria.imprimir("Saludos");
//o usando el nombre "completamente calificado" (no recomendable)
//ar.com.nombreproyecto.Utileria.imprimir("Saludos");        
    }
    
}
