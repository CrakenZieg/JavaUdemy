
package cpjlaboratoriofinal;
import mx.com.gm.peliculas.servicio.*;
import java.util.Scanner;


public class CPJLaboratorioFinal {
    public static void main(String[] args) {
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImple();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        
        do{
            System.out.println("Elige una opción: \n"
            + "1. Iniciar catalogo peliculas\n"
            + "2. Agregar pelicula\n"
            + "3. Listar peliculas\n"
            + "4. Buscar pelicula\n"
            + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
        switch(opcion){
                case 1:
                    catalogoPeliculas.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce un nombre para la pelicula a agregar");
                    var nombrePelicula = scanner.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogoPeliculas.listarPelicula();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula");
                    var buscar = scanner.nextLine();
                    catalogoPeliculas.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }         
        } while(opcion != 0);
    }
}

    
