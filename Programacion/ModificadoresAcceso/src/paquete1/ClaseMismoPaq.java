
package paquete1;

public class ClaseMismoPaq extends Clase1{
    
    public ClaseMismoPaq(){
        super(1);
        System.out.println("Clase hija en mismo paquete accede al constructor default");  
        System.out.println("Clase hija en mismo paquete accede a: " + this.atributoDefault);
        System.out.println("Clase hija en mismo paquete accede a:");
        this.metodoDefault();
        
    }
    
}
