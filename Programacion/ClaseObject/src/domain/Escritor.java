
package domain;

public class Escritor extends Empleado {
   
    private final TipoEscritura tipoEscritura;
        
    public Escritor(String nombre, double salario, TipoEscritura tipoEscritura){
        super(nombre, salario);
        this.tipoEscritura = tipoEscritura;
    }

    @Override
    public String obtenerDetalles(){
        return super.obtenerDetalles() + ", tipo: " + this.tipoEscritura.getDescripcion();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();        
        sb.append(super.toString());
        sb.append(", Escritor: ");
        sb.append("tipo de escritura=").append(tipoEscritura);
        sb.append('.');
        return sb.toString();
    }
    
    public TipoEscritura getTipoEscritura(){
        return this.tipoEscritura;
    }
    
}
