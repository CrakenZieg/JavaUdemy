
package com.gm.munndopc;

public class Orden {
    
    private static final int MAX_COMPUTADORAS = 10;
    private int contadorComputadoras;
    private static int contadorOrdenes = 0;
    private final int idOrden;
    private Computadora computadoras[];
    
    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }
    
    public void agregarComputadora(Computadora computadora){
        if(this.contadorComputadoras < Orden.MAX_COMPUTADORAS){
            this.computadoras[this.contadorComputadoras++] = computadora;
        } else {
            System.out.println("Has superado el limite de la orden: " + Orden.MAX_COMPUTADORAS);
        }
    }

    public static int getMAX_COMPUTADORAS() {
        return Orden.MAX_COMPUTADORAS;
    }
    public int getContadorComputadoras() {
        return this.contadorComputadoras;
    }
    public static int getContadorOrdenes() {
        return Orden.contadorOrdenes;
    }
    public int getIdOrden() {
        return this.idOrden;
    }
    public Computadora[] getComputadoras() {
        return this.computadoras;
    }

    public void mostrarOrden(){
        System.out.println("Orden id: " + this.idOrden);
        for (int i = 0; i < contadorComputadoras; i++){
            System.out.println("Computadora: " + computadoras[i]);
        }
    }
    
}
