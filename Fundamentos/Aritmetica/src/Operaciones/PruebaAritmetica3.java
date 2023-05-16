
package Operaciones;

public class PruebaAritmetica3 {
    
    public static void main(String[] args) {
        
        //variables locales:
        var a = 10;
        var b = 2;
        
        //cuando corre java, al pasar a miMetodo(), las variables a y b no quedan disponibles,
        //ya que están en el metodo main()
        miMetodo();         
                
        //System.gc() borra de la memoria los objetos que no estan referenciados en el codigo,
        //por ejemplo, si creo un objeto 
        //Aritmetica aritmeticaT = new Aritmetica(); --->creo objeto y lo referencio aritmeticaT
        //aritmeticaT = null; ---> cambio la referencia, ahora el objeto no esta referido en el codigo
        //si llamo System.gc() va a ver en la memoria el objeto que cree en el primer paso, que ya no 
        //tiene referencia en el codigo y lo va a eliminar
        //generalmente no es necesario llamar este tipo de metodos ya que la mayoria de las cosas son 
        //locales y se borran cuando cumplen su funcion
        
    }
    
    public static void miMetodo() {
    
        System.out.println("Otro metodo");
        
    }
    
}
