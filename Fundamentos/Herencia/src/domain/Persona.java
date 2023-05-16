
package domain;

public class Persona {
//protected esta pesnado para que se pueda acceder a este atributo desde
//las clases hijas, dentro y fuera del paquete.
//a diferencia de private (no accede nadie)
//o default (herencia solo dentro del mismo paquete)  
//o public (accede cualquiera)    
    protected String nombre;
    protected char genero;
    protected int edad;
    protected String direccion;
    
    public Persona(){
    }
    
    public Persona(String nombre){
        this.nombre = nombre;
    }

    public Persona(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public char getGenero() {
        return this.genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    public int getEdad() {
        return this.edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", genero=").append(genero);
        sb.append(", edad=").append(edad);
        sb.append(", direccion=").append(direccion);
        sb.append(", ").append(super.toString());//llamamos a toString() de la clase object, que nos devuelve el lugar en la memoria
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
