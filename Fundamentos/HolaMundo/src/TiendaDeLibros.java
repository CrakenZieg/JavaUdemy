import java.util.Scanner;

public class TiendaDeLibros {
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        
        String nombre;
        Integer id;
        Double precio;
        Boolean envioGratuito;
    
        System.out.println("Proporciona el nombre:");
        nombre = console.nextLine();
        System.out.println("Proporciona el id:");
        id = Integer.parseInt(console.nextLine());
        System.out.println("Proporciona el precio:");
        precio = Double.parseDouble(console.nextLine());
        System.out.println("Envio gratuito? (y/n):");
        envioGratuito = ("y".equals(console.nextLine()));
        
        System.out.println(nombre + " #" + id + "\nPrecio: $" + precio + "\nEnvio Gratuito: " + envioGratuito);

        
        
    }
}
