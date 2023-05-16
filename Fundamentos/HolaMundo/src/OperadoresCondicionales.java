
public class OperadoresCondicionales {
    
    public static void main(String args[]) {
        
        var a = 7;
        var valMinimo = 0;
        var valMaximo = 10;
        
        var resultado = (a>=valMinimo)&&(a<=valMaximo);
        
        if(resultado){
            System.out.println("Dentro del rango");
        } else {
            System.out.println("Fuera del rango");
        }
        
        var vacaciones = true;
        var diaDeDescanso = false;
        
        if (vacaciones || diaDeDescanso) {
            System.out.println("Puede asistir");
        } else {
            System.out.println("No puede asistir");
        }
        
    }
    
}
