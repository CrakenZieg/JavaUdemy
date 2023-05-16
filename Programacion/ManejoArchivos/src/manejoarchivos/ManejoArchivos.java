
package manejoarchivos;

import java.io.*;//io viene de Input Output
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoArchivos {
    
    public static void crearArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {//como printwriter puede tirar excepcion se abre en un contenedor try
            PrintWriter salida = new PrintWriter(archivo);//abre el archivo
            salida.close();//cuando se cierra es que se crea el archivo
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void escribirArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);//escribe en el archivo
            salida.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void anexarArchivo(String nombreArchivo, String contenido){
         File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);//FileWriter (archivo, (adjuntar contenido o no))
            salida.close();
            System.out.println("Se ha anexado informacion al archivo");
        } catch (FileNotFoundException ex) {//excepcion de FileWriter         
            ex.printStackTrace(System.out);
        } catch (IOException ex) {//excepcion de PrintWriter   
            ex.printStackTrace(System.out);
        }
    }
    
    public static void leerArchivo(String nombreArchivo){
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
//FileReader lee de a caracteres, BufferedReader nos permite leer conjuntos de caracteres
            var lectura = entrada.readLine();//acumula la primera linea
            while (lectura != null){
                System.out.println("Lectura = " + lectura);//imprime
                lectura = entrada.readLine();//recorre la siguiente
            }
            entrada.close();
        } catch (FileNotFoundException ex) {//excepcion de FileWriter
            ex.printStackTrace(System.out);
        } catch (IOException ex) {//excepcion de readLine()
            ex.printStackTrace(System.out);
        }
    }
    
}
