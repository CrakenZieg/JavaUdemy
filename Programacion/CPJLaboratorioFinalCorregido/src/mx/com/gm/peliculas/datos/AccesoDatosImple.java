
package mx.com.gm.peliculas.datos;

import java.util.*;
import java.io.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImple implements IAccesoDatos{
    
    @Override
    public boolean existe(String nombreArchivo){
        var archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx{
        var archivo = new File(nombre);
        List<Pelicula> listaCatalogo = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null){
                listaCatalogo.add(new Pelicula(lectura));
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas: "+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas: "+ex.getMessage());
        }
        return listaCatalogo;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx{
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());//FileWriter (archivo, (adjuntar contenido o no))
            salida.close();
            System.out.println("Se ha escrito información al archivo: " + pelicula);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir peliculas: "+ex.getMessage());
        }
    }
    
    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        String output = null;
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            int indice = 1;
            while (lectura != null){
                if(buscar != null && buscar.equalsIgnoreCase(lectura)){
                    output = "La pelicula " + buscar + " está en la linea "+ indice;
                    break;
                }
                lectura = entrada.readLine();
                indice++;             
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar pelicula: "+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar pelicula: "+ex.getMessage());
        }
        return output;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx{
        var archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al crear el archivo: "+ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if(archivo.exists()){
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        }
    }
    
}
