
public class OperadoresDeAsignacion {
    
    public static void main(String arg[]){
    
        int a = 3, b = 2;
        int c = a + 5 - b;
        
        System.out.println("c = " + c);
        
        System.out.println("a = " + a);
        a += 1;
        System.out.println("(a += 1) =" + a);
        
        System.out.println("a = " + a);
        a -= 1;
        System.out.println("(a -= 1) =" + a);
        
        System.out.println("a = " + a);
        a *= 2;
        System.out.println("(a *= 2) =" + a);
        
        System.out.println("a = " + a);
        a /= 2;
        System.out.println("(a /= 2) =" + a);
    
        System.out.println("a = " + a);
        a %= 2;
        System.out.println("(a %= 2) =" + a);
        
    }
    
}
