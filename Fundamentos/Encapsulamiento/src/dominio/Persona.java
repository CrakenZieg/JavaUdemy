
package dominio;

public class Persona {
//nada, default o package permite acceder a los datos desde la clase o el paquete
//public desde todos lados
//private desde ningun lado
    private String nombre;
    private double sueldo;
    private boolean eliminado;
    
    public Persona(String nombre, double sueldo, boolean eliminado){
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.eliminado = eliminado;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public double getSueldo(){
        return this.sueldo;
    }
    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }
    public boolean isEliminado(){ //cuando el get es sobre boolean se usa 'is' y no 'get'
        return this.eliminado;
    }
    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
    }
    public String toString(){
        return "Persona [nombre: " + this.nombre +
                ", sueldo: " + this.sueldo +
                ", eliminado: " + this.eliminado + "]";
    }
    
    
}
