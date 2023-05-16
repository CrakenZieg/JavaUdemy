
public class OperadoresUnarios {
    
    public static void main(String args[]) {
        
        //cambia signo
        var a = 3;
        var b = -a;
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        //cambia booleano
        var bool = true;
        var noBool = !bool;
        
        System.out.println("bool = " + bool);
        System.out.println("noBool = " + noBool);
        
        //++(var) suma y asigna, (var)++ asigna y suma cuando se use de nuevo 
        var e = 3;
        System.out.println("e = " + e);
        var f = ++e;
        System.out.println("f = ++e = " + f + " ( e vale + " + e + ")");
        var g = e++;
        System.out.println("g = e++ = " + g + " ( e vale + " + e + ")");
        
        //aplica lo mismo para --
        
    }
    
}
