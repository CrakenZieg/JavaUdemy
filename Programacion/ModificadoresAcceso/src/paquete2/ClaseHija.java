
package paquete2;

import paquete1.Clase1;

public class ClaseHija extends Clase1 {
    
    public ClaseHija(){
        super("prot");
        System.out.println("ClaseHija accede a constructor de Clase1");
        this.atributoProtected = "atributoProtected";
        System.out.println("ClaseHija accede a protected de Clase1 = " + this.atributoProtected);
        this.metodoProtected();
        System.out.println("Metodo protected de Clase1");
        
    }
    
}
