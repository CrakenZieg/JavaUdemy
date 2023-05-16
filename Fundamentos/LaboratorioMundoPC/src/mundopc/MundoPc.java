
package mundopc;

import com.gm.munndopc.*;

public class MundoPc {
    
    public static void main(String[] args) {
        
        Raton raton1 = new Raton("Mouse1", "Genius");
        Raton raton2 = new Raton("Mouse2", "Logitech");
        Raton raton3 = new Raton("Mouse3", "Overtech");
        
        Teclado teclado1 = new Teclado("Teclado1", "Genius");
        Teclado teclado2 = new Teclado("Teclado2", "Logitech");
        Teclado teclado3 = new Teclado("Teclado3", "Overtech");
        
        Monitor monitor1 = new Monitor("LG", 29);
        Monitor monitor2 = new Monitor("Sanyo", 30);
        Monitor monitor3 = new Monitor("Hitachi", 31);
        
        Computadora computadora1 = new Computadora("Negra", monitor1, teclado1, raton1);
        Computadora computadora2 = new Computadora("Roja", monitor2, teclado2, raton2);
        Computadora computadora3 = new Computadora("Verde", monitor3, teclado3, raton3);
        
        Orden orden1 = new Orden();
        
        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        orden1.agregarComputadora(computadora2);
        orden1.agregarComputadora(computadora3);
        orden1.agregarComputadora(computadora1);
        
        orden1.mostrarOrden();
        
    }
    
}
