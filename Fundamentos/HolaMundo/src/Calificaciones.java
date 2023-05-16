
import java.util.Scanner;
        
public class Calificaciones {
    
    public static void main(String args[]){
    
        Scanner consola = new Scanner(System.in);
        var calificacion = 0.0;
        var nota = "A";
        
        System.out.println("Proporciona una calificacion entre 0 y 10: ");
        calificacion = Double.parseDouble(consola.nextLine());
        
        if(9 <= calificacion && calificacion <= 10){
            nota = "A";
        } else if (8 <= calificacion && calificacion < 9) {
            nota = "B";
        } else if (7 <= calificacion && calificacion < 8) {
            nota = "C";
        } else if (6 <= calificacion && calificacion < 7) {
            nota = "D";
        } else if (0 <= calificacion && calificacion < 6) {
            nota = "F";
        } else {
            nota = "Valor desconocido";
        }
        
        System.out.println(nota);
        
    }
    
}
