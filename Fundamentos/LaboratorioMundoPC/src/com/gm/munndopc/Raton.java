
package com.gm.munndopc;

public class Raton extends DispositivoEntrada {
    
    private static int contadorRatones = 0;
    private final int idRaton;
        
    public Raton(String tipoEntrada, String marca){
        super(tipoEntrada, marca);
        this.idRaton = ++Raton.contadorRatones;
    }

    public static int getContadorRatones() {
        return Raton.contadorRatones;
    }
    public int getIdRaton() {
        return this.idRaton;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Raton{");
        sb.append("idRaton=").append(this.idRaton);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
