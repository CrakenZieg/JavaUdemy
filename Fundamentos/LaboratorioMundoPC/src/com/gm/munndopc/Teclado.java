
package com.gm.munndopc;

public class Teclado extends DispositivoEntrada{
    
    private static int contadorTeclados = 0;
    private final int idTeclado;
    
        
    public Teclado(String tipoEntrada, String marca){
        super(tipoEntrada, marca);
        this.idTeclado = ++Teclado.contadorTeclados;
    }

    public static int getContadorTeclados() {
        return Teclado.contadorTeclados;
    }
    public int getIdTeclado() {
        return this.idTeclado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Teclado{");
        sb.append("idTeclado=").append(this.idTeclado);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
