
package domain;

public class Persona {
    
    private int idPersona;
    private String nombre;
    
    private static int contadorPersonas;
    
    public Persona(String nombre){
        this.nombre = nombre;
        //incrementamos el contador, no se recomienda usar this para variables estaticas
        Persona.contadorPersonas++;
        this.idPersona = Persona.contadorPersonas;
        //o podría hacer this.idPersona = ++Persona.contadorPersonas;
        
    }

    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }
    public static void setContadorPersonas(int contadorPersonas) {
        Persona.contadorPersonas = contadorPersonas;
    }
    
    @Override //anotacion, en este caso indica que reescribis el metodo toString de la clase Object
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + '}';
    }
    
    /*public String toString(){
        return "Persona [id: " + this.idPersona +
                ", nombre: " + this.nombre + "]";
        
    }*/
    
    
}
