
package operaciones;

public class Operaciones {
//hay sobrecarga de metodos cuando hay mas de un metodo con un mismo nombre
//y diferentes parametros, puede variar el retorno y el acceso, pero no puede
//ser mas restrictivo, si el primero es public, el resto tambien    
    public static int sumar(int a, int b){
        System.out.println("Sumar (int a, int b)");
        return a + b;
    }
    
    public static double sumar(double a, double b){
        System.out.println("Sumar (double a, double b)");
        return a + b;
    }
    
}
