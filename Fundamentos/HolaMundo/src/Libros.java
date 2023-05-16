
import java.util.Scanner;

public class Libros {

    public static void main(String args[]) {
        Scanner consola = new Scanner(System.in);

        System.out.println("¿Cual es el nombre del Libro?");
        var nombreL = consola.nextLine();
        System.out.println("¿Cual es el autor del Libro?");
        var autorL = consola.nextLine();
        System.out.println("El libro se llama " + nombreL + " y su autor es " + autorL);

    }
}
