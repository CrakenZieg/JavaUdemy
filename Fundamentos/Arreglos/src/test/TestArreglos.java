
package test;

public class TestArreglos {
    
    public static void main(String[] args) {
//los arrays son objetos, por eso new
//despues el tipo de dato que llevan y 
//la cantidad de elementos
        int edades[] = new int[3];
//no se pueden agregar elementos al array,
//para tener un "arreglo dinamico" se usa 
//list, map o set (veremos despues)
        System.out.println("edades = " + edades);
        
        edades[0] = 4;
        System.out.println("edades 0 = " + edades[0]);
        
        edades[1] = 5;
        edades[2] = 6;
//si tratamos de acceder a una posicion fuera del arreglo,
//el IDE no se da cuenta hasta que lo hacemos correr
        
        for (int i = 0; i < edades.length; i++){
            System.out.println("elemento " + (i) + " = " + edades[i]);
        }
//podemos inicializar un array con los elementos ya incluidos
//se llama sintaxis resumida, por ejemplo:

        String frutas[] = {"Naranja", "Platano", "Uva"};        
        
        for (int i = 0; i < frutas.length; i++){
            System.out.println("Frutas:"+frutas[i]);
        }
        
    }
    
}
