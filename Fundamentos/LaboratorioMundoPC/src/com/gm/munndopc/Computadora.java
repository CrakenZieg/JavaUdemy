
package com.gm.munndopc;

public class Computadora {
    
    private static int contadorComputadora = 0;
    private final int idComputadora;
    private String nombre;
    private Monitor monitor;
    private Raton raton;
    private Teclado teclado;
    
    public Computadora(){
        this.idComputadora = ++Computadora.contadorComputadora;
    }
    
    public Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton){
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }
    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Raton getRaton() {
        return this.raton;
    }
    public void setRaton(Raton raton) {
        this.raton = raton;
    }

    public Teclado getTeclado() {
        return this.teclado;
    }
    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public static int getContadorComputadora() {
        return Computadora.contadorComputadora;
    }
    public int getIdComputadora() {
        return this.idComputadora;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computadora{");
        sb.append("idComputadora=").append(this.idComputadora);
        sb.append(", nombre=").append(this.nombre);
        sb.append(", monitor=").append(this.monitor);
        sb.append(", raton=").append(this.raton);
        sb.append(", teclado=").append(this.teclado);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
