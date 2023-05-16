import java.util.Scanner;

public class ConversionDeTipos {
    
    public static void main(String args[]) {
        
        //String a Int
        var edad = "30";
        var edadInt = Integer.parseInt(edad);
        
        System.out.println("Edad es " + edad + " y vale " + edadInt);
        
        System.out.println("String + 1 = " + (edad + 1) + ", Int + 1 = " + (edadInt +1) );
        
        //Analogamente existe Double.parseDouble('param') que transforma un String en un Double
        
        Scanner consola = new Scanner(System.in);
        //scanner devuelve un string
        System.out.println("Que edad tenes?");
        edadInt = Integer.parseInt(consola.nextLine());
        System.out.println("Tenes " + edadInt + " años");
        
        //poniendo puntos de ruptura y mirando en el debug ves que cambia el tipo de las variables
        
        var edadIntAString = String.valueOf(edadInt);
        System.out.println("Tu edad en String es = " + edadIntAString);
        
        var caracter = "holas".charAt(1);
        System.out.println("caracter = " + caracter);  
        
        System.out.println("Dame un caracter:");
        caracter = consola.nextLine().charAt(0);
        System.out.println("caracter = " + caracter);
        
    }
    
}
