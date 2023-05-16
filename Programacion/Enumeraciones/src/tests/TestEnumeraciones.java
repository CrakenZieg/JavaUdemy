
package tests;

import enumeracion.Continentes;
import enumeracion.Dias;

public class TestEnumeraciones {
    
    public static void main(String[] args) {
//para acceder a sus elementos los tratamos como un atributo
//los elementos son Strings
        System.out.println("Lunes: " + Dias.LUNES);
        indicarDia(Dias.JUEVES);
//Solamente podemos pasarle el tipo Dias, no un String
    
        System.out.println("Continente nro 4: " + Continentes.AMERICA + " tiene " + Continentes.AMERICA.getPaises() + " paises");
        //Accedo a los elementos de la enumeracion con sintaxis analoga a la de las clases
    }
    
    private static void indicarDia(Dias dias){
        switch(dias){
            case LUNES:
                System.out.println("Primer dia de la semana");
                break;
            case MARTES:
                System.out.println("Segundo dia de la semana");
                break;
            case MIERCOLES:
                System.out.println("Tercer dia de la semana");
                break;
            case JUEVES:
                System.out.println("Cuarto dia de la semana");
                break;
            case VIERNES:
                System.out.println("Quinto dia de la semana");
                break;
            case SABADO:
                System.out.println("Sexto dia de la semana");
                break;
            case DOMINGO:
                System.out.println("Septimo dia de la semana");
                break;
            
        }
    }
    
}
