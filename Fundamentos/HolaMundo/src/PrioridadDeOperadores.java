
public class PrioridadDeOperadores {
    
    public static void main(String args[]) {
    
        var x = 5;
        System.out.println("x = " + x);
        var y = 10;
        System.out.println("y = " + y);
        System.out.println("z = ++x + y--");
        var z = ++x + y--;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
                
        var resultado1 = 4 + 5 * 6 / 3;
        System.out.println("resultado1 = " + resultado1);
        
        var resultado2 = (4 + 5) *6 / 3;
        System.out.println("resultado2 = " + resultado2);
    
    }
    
}
