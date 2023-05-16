
package domain;

public class Empleado extends Persona {
//como esta clase no va a heredar a nadie sus atributos, 
//usamos private y no protected
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleados;

    /*public Empleado(int idEmpleado, double sueldo, String nombre, char genero, int edad, String direccion) {
        super(nombre, genero, edad, direccion);
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
    }*/
    public Empleado(){
        this.idEmpleado = ++Empleado.contadorEmpleados;
    }
//puedo usar this() para llamar a un constructor propio de la clase o super(param)
//para llamar a un constructor heredado, pero no puedo llamar a los 2 al mismo tiempo
//en este caso creo un Empleado() (que ya da id) y después lo llamo en Empleado(param),    
//y reemplazo el super(param) con los atributos heredados directamente (por eso no tienen
//que ser private)    
    public Empleado(String nombre, double sueldo){
        //super(nombre);//usa el constructor del padre
        this();//podría tener parametros, y también, ese constructor, llamar a super(param)
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado=").append(this.idEmpleado);
        sb.append(", nombre=").append(this.nombre);
        sb.append(", sueldo=").append(this.sueldo);
        sb.append('}');
        return sb.toString();
    }*/
//puedo meter un toString dentro, para incluir el del padre
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado=").append(this.idEmpleado);
        sb.append(", sueldo=").append(this.sueldo);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
}
