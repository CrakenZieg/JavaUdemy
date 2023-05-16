
package domain;

public class Gerente extends Empleado {
    private String departamento;
    
    public Gerente(String nombre, double sueldo, String departamento){
        super(nombre, sueldo);
        this.departamento = departamento;
        
    }
        
    @Override
    public String obtenerDetalles(){
        //return "Nombre: " + this.nombre + ", sueldo: " + this.sueldo + ", departamento: " + this.departamento;
        return super.obtenerDetalles() + ", departamento: " + this.departamento;
        //con super usamos el metodo de la clase padre y le funciones.
    }
    
}
