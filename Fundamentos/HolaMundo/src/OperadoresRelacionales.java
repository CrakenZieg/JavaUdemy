
public class OperadoresRelacionales {
    
    public static void main(String args[]){
        
        int a = 3, b = 2;
        var c = (a == b); //no es necesario el parentesis a la derecha porque primero analiza ese lado
                
        System.out.println("c = " + c); 
        
        var d = (a !=b );
        
        System.out.println("d = " + d);
        
        //Los String tienen un metodo especial para comparar, no se usa ==
        
        var string1 = "Hola";
        var string2 = "Hola";
        
        var e = string1 == string2;
        System.out.println("e = " + e);
        
        var f = string1.equals(string2);
        System.out.println("f = " + f);
        
        //se usa string.equals(otroString)
        
        var g = a < b;
        System.out.println("g = a < b = " + g);
        
        var h = b < a;
        System.out.println("h = a > b = " + h);
        
        if( a % 2 == 0) {
            System.out.println("a es Par porque es " + a);
        } else {
            System.out.println("a es Impar porque es " + a);
        }
        
        var edad = 30;
        var adulto = 18;
        
        if(edad>=adulto){
            System.out.println("Es adulto");
        } else {
            System.out.println("Es menor de edad");
        }
        
    }
    
}
