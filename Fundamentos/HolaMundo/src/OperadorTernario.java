
public class OperadorTernario {
    
    public static void main(String args[]) {
        
        var a = 3;
        var b = 2;
        
        var resultado1 = (a < b) ? "Verdadero" : "Falso";
        System.out.println("resultado1 = " + resultado1);
        
        var numero = 8;
        
        var resultado2 = (numero % 2 == 0)? "Es par" : "Es impar";
        System.out.println("resultado2 = " + resultado2);
        
    }
    
}
