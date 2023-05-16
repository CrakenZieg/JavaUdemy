
import java.util.Scanner;

public class Estacion {
    
    public static void main(String args[]) {
    
        Scanner consola = new Scanner(System.in);
        var mes = 1;
        var estacion = "Estacion desconocida";
        
        System.out.println("Proporciona un mes:");
        mes = Integer.parseInt(consola.nextLine());
        
        if(mes == 1 || mes ==2 || mes == 12) {
            estacion = "Verano";
        } else if(3 <= mes && mes <= 5){
            estacion = "Otono";
        } else if(5 < mes && mes < 9){
            estacion = "Invierno";
        } else if(9 <= mes && mes <= 11) {
            estacion = "Primavera";
        }
        
        System.out.println("estacion = " + estacion);
                   
    }
    
}
