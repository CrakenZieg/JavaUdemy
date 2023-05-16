package Clases;


public class Persona {
    
    //atributos de la clase
    public String nombre;
    public String apellido;
    
    //no es buena practica dejar disponibles a modificacion atributos de una clase desde otra
    
    public void desplegarInformacion() {
    
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        
    }
        
}
