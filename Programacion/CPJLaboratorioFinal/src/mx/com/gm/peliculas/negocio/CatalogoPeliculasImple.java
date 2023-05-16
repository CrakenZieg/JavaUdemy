
package mx.com.gm.peliculas.negocio;
import mx.com.gm.peliculas.datos.AccesoDatosImple;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImple implements CatalogoPeliculas{
    
    public CatalogoPeliculasImple(){};
    
    AccesoDatosImple datos = new AccesoDatosImple();
        
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        try {
            datos.escribir(pelicula, nombreArchivo, true);
        } catch (LecturaDatosEx ex) {
            System.out.println("Se produjo un error!");
        } catch (EscrituraDatosEx ex) {
            System.out.println("Se produjo un error!");
        }
    }

    @Override
    public void listarPelicula(String nombreArchivo) {
        try {
            System.out.println(datos.listar(nombreArchivo));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        try {
            datos.buscar(nombreArchivo, buscar);
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                try {
                    datos.crear(nombreArchivo);
                } catch (EscrituraDatosEx ex) {
                    ex.printStackTrace(System.out);
                }
            } else {
                try {
                    datos.crear(nombreArchivo);
                } catch (EscrituraDatosEx ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
