import java.util.Scanner;

public class MayorDeDos {
    
    public static void main(String args[]){
    
        Scanner consola = new Scanner(System.in);
        
        int a = 0, b = 0;
        
        System.out.println("Proporciona el numero a:");
        a = Integer.parseInt(consola.nextLine());
        System.out.println("Proporciona el numero b:");
        b = Integer.parseInt(consola.nextLine());
        
        if (a < b){
            System.out.println("El numero mayor es:\n" + b);
        } else {
            System.out.println("El numero mayor es:\n" + a);
        }
        
    }
    
}

