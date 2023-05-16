
import java.util.Scanner;

public class Rectangulo {
    
    public static void main(String args[]) {
    
        Scanner consola = new Scanner(System.in);
        int ancho = 0;
        int alto = 0;
        
        System.out.println("Proporciona el alto:");
        alto = Integer.parseInt(consola.nextLine());
        System.out.println("Proporciona el ancho:");
        ancho = Integer.parseInt(consola.nextLine());
        System.out.println("Area: " + (ancho * alto)); 
        System.out.println("Perimetro: " + (ancho + alto)*2);
        
    }
    
}
