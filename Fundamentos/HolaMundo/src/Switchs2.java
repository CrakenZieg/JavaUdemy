import java.util.Scanner;

public class Switchs2 {
    
    public static void main(String args[]){
    
        Scanner consola = new Scanner(System.in);
        var mes = 2;
        var estacion = "Estacion desconocida";
        
        System.out.println("Proporciona un mes:");
        mes = Integer.parseInt(consola.nextLine());
        
        switch(mes){
            case 1:
            case 2:                
            case 12:
                estacion = "Verano";
                break;
            case 3:
            case 4:                
            case 5:
                estacion = "Otono";
                break;
            case 6:
            case 7:                
            case 8:
                estacion = "Invierno";
                break;
            case 9:
            case 10:                
            case 11:
                estacion = "Primavera";
                break;
            default:
                estacion = "Caso no encontrado";
        }
        
        System.out.println("Estacion: " + estacion);
        
    }
    
}
