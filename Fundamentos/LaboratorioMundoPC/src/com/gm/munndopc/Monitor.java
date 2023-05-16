
package com.gm.munndopc;

public class Monitor {
    
    private static int contadorMonitores = 0;
    private final int idMonitor;
    private String marca;
    private double tamano;
    
    public Monitor(){
        this.idMonitor = ++Monitor.contadorMonitores;
    }
    
    public Monitor(String marca, double tamano){
        this();
        this.marca = marca;
        this.tamano = tamano;
    }

    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getTamano() {
        return this.tamano;
    }
    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public static int getContadorMonitores() {
        return Monitor.contadorMonitores;
    }
    public int getIdMonitor() {
        return this.idMonitor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monitor{");
        sb.append("idMonitor=").append(this.idMonitor);
        sb.append(", marca=").append(this.marca);
        sb.append(", tamano=").append(this.tamano);
        sb.append('}');
        return sb.toString();
    }
        
}
