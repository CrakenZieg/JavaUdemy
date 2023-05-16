
package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public interface AccesoDatos {
    
    //public static final String CATALOGO = "C:\\ProgramacionCursos\\JavaUdemy\\Programacion\\CPJLaboatorioFinal\\Datos\\";
    
    boolean existe(String nombreArchivo) throws LecturaDatosEx;
    
    List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws LecturaDatosEx, EscrituraDatosEx;
    
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    void crear(String nombreArchivo) throws LecturaDatosEx, EscrituraDatosEx;
   
    void borrar(String nombreArchivo) throws LecturaDatosEx;
    
}
