
package mx.com.gm.peliculas.datos;

import java.util.*;
import java.io.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImple implements AccesoDatos{
    
    @Override
    public boolean existe(String nombreArchivo) throws LecturaDatosEx{
        boolean existe;
        var archivo = new File(nombreArchivo);
        if (nombreArchivo == null){
            throw new LecturaDatosEx("No hay nombre de archivo para comparar");
        }
        existe = archivo.exists();
        return existe;
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx{
        var archivo = new File(nombre);
        if(nombre == null){
            throw new LecturaDatosEx("No hay nombre de archivo");
        }
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
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return listaCatalogo;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws LecturaDatosEx, EscrituraDatosEx{
        if (pelicula == null || nombreArchivo == null){
            throw new LecturaDatosEx("No hay nombre de archivo o pelicula definida, debes introducir ambos");
        }
        if(!existe(nombreArchivo)){
            crear(nombreArchivo);
            System.out.println("Se creo el archivo");
        }
        File archivo = new File(nombreArchivo);
        if(anexar){       
            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
                salida.println(pelicula.getNombre());//FileWriter (archivo, (adjuntar contenido o no))
                salida.close();
                System.out.println("Se ha anexado a "+ pelicula.getNombre() + " en el archivo " + nombreArchivo);
            } catch (FileNotFoundException ex) {       
                ex.printStackTrace(System.out);
            } catch (IOException ex) { 
                ex.printStackTrace(System.out);
            }          
        }else{
            try {
                PrintWriter salida = new PrintWriter(archivo);
                salida.println(pelicula.getNombre());//escribe en el archivo
                salida.close();
                    System.out.println("Se ha agregado a "+ pelicula.getNombre() + " en el archivo " + nombreArchivo);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
    
    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        String output = "";
        if (nombreArchivo == null){
            throw new LecturaDatosEx("No hay nombre de archivo, debes introducir un nombre de archivo");
        }
        if (buscar == null){
            throw new LecturaDatosEx("No hay nombre de pelicula, debes introducir un nombre de pelicula");
        }
        if(!existe(nombreArchivo)){
            throw new LecturaDatosEx("No existe el archivo");
        }
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            int i = 0;
            while (lectura != null){
                if(lectura == buscar){
                    System.out.println("La pelicula está en la linea "+ i +" del archivo " + nombreArchivo);
                    output = "La pelicula está en la linea "+ i +" del archivo " + nombreArchivo;
                    return output;
                }
                lectura = entrada.readLine();
                i++;             
            }
            entrada.close();
            System.out.println(buscar + " no se encuentra en " + nombreArchivo);
            output = buscar + " no se encuentra en " + nombreArchivo;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return output;
    }

    @Override
    public void crear(String nombreArchivo) throws LecturaDatosEx, EscrituraDatosEx{
        if (nombreArchivo == null){
            throw new LecturaDatosEx("No hay nombre de archivo, debes introducir un nombre de archivo");
        }
        if (existe(nombreArchivo)){
            throw new EscrituraDatosEx("El archivo ya existe");
        }
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws LecturaDatosEx{
        if (nombreArchivo == null){
            throw new LecturaDatosEx("No hay nombre de archivo, debes introducir un nombre de archivo");
        }
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
    
}
