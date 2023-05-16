
package domain;

public class Empleado {
    
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario){
        this.nombre = nombre;
        this.salario = salario;
    }
    
    public String obtenerDetalles(){
        return "Nombre: " + this.nombre + ", sueldo: " + this.salario;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("nombre=").append(nombre);
        sb.append(", salario=").append(salario);
        sb.append('}');
        return sb.toString();
    }
    
}
