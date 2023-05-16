
package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {
    
    //public static final String CATALOGO = "C:\\ProgramacionCursos\\JavaUdemy\\Programacion\\CPJLaboatorioFinal\\Datos\\";
    
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    void crear(String nombreArchivo) throws AccesoDatosEx;
   
    void borrar(String nombreArchivo) throws AccesoDatosEx;
    
}
