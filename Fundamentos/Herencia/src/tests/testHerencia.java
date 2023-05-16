
package tests;

import domain.Cliente;
import domain.Empleado;
import java.util.Date;

public class testHerencia {
    
    public static void main(String[] args) {
        
        Empleado empleado_1 = new Empleado("Juan", 5000);        
        System.out.println("empleado_1 = " + empleado_1);        
        var fecha = new Date();
//creamos variable fecha para que no moleste la vista del paso a paso de la creacion del cliente
//para crear el cliente va a persona, ahí a object, y va recorriendo los constructores, hasta llegar a cliente
        Cliente cliente_1 = new Cliente(fecha, true, "Carla", 'F', 30, "Saturno 15");
        System.out.println("cliente_1 = " + cliente_1);

    }
    
}
