
package domain;

import java.util.Objects;

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

    
    
    @Override
    public int hashCode() {//"convierte" al objeto en un int "lo mas unico posible"
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;//¿misma referencia en memoria? son iguales
        }
        if (obj == null) {
            return false;//¿el otro objeto es null? son diferentes
        }
        if (getClass() != obj.getClass()) {
            return false;//¿son de diferente tipo? son diferentes
        }
        final Empleado other = (Empleado) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;//¿son diferentes los valores del atributo 'salario'? son diferentes
        }
        return Objects.equals(this.nombre, other.nombre);
    //devuelve, en este caso, el resultado de la igualdad o no de los atributos 'nombre' de cada objeto
    }
    
    
    
}
