
import java.util.Scanner;

public class ScannersMethod {
    public static void main(String args[]) {
        var usuario = "Mau";
        System.out.println("usuario = " + usuario);
        
        Scanner consola = new Scanner(System.in);
        System.out.println("Escribi el nombre del Mau:");
        var nombreMau = consola.nextLine();
        System.out.println("nombreMau = " + nombreMau);
        System.out.println("Que hace el Mau?");
        var accion = consola.nextLine();
        System.out.println("El "+ usuario + " se llama " + nombreMau+ " y hace " + accion);
                
        
    }
}
