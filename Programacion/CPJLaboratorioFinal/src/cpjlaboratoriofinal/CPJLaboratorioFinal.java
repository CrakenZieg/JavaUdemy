
package cpjlaboratoriofinal;
import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;


public class CPJLaboratorioFinal {
    public static void main(String[] args) {
        CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImple();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String nombreArchivo = "prueba.txt";
        
        do{
            System.out.println("Elige opción:");
            System.out.println("1.-Iniciar catalogo peliculas");
            System.out.println("2.-Agregar pelicula");
            System.out.println("3.-Listar peliculas");
            System.out.println("4.-Buscar pelicula");
            System.out.println("0.-Salir");
            opcion = Integer.parseInt(scanner.nextLine());
        switch(opcion){
                case 1:
                    System.out.println("Introduce un nombre para el archivo:");
                    nombreArchivo = scanner.nextLine();
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
                    System.out.println("Se ha creado el archivo " + nombreArchivo);
                    break;
                case 2:
                    System.out.println("Introduce un nombre para la pelicula a agregar");
                    catalogoPeliculas.agregarPelicula(scanner.nextLine(), nombreArchivo);
                    System.out.println("Se ha agregado la pelicula en " + nombreArchivo);
                    break;
                case 3:
                    System.out.println("Las películas en " + nombreArchivo + " son:");
                    catalogoPeliculas.listarPelicula(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula");
                    catalogoPeliculas.buscarPelicula(nombreArchivo, scanner.nextLine());
                    System.out.println("Búsqueda finalizada");
                    break;
                case 0:
                    System.out.println("Saliendo");
            }         
        } while(opcion != 0);
    }
}

    
