
package testclientews;

import ClienteEMS.servicio.*;

public class TestServicioSumarWS {
    
    public static void main(String[] args) {
        //creamos una instancia del servicio y la llamamos
        ServicioSumarWS servicioSumar = new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutando Servicio SumarWS");
        int x=6;
        int y=3;
        int resultado = servicioSumar.sumar(x, y);
        System.out.println("Resultado : " + x +" + "+ y + " = " + resultado);
        System.out.println("Fin del servicio Sumarws");
        
    }
    
    
    
}

//Generamos una app SumarWS, la desplegamos en glasfish 5, obtenemos la dirección wsdl desde la parte de endpoint
//creamos esta app que use ese servicio, agregando al pom codehaus mojo y luego plugin incluyendo la url del wsdl
//despues hacemos runMaven con el goal de generate-sources y nos crea en el paquete indicado las clases necesarias
//para importar el servicio y poder usarlo