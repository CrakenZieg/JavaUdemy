
package test;

import domain.Persona;

public class TestMatrices {
    
    public static void main(String[] args) {
        //matriz de 3 renglones y 2 columnas
        int edades[][] = new int[3][2];
        System.out.println("edades = " + edades);
        
        for (int i = 0; i<edades.length; i++){
            for (int j = 0; j<edades[i].length;j++){
                edades[i][j] = i+j;
                System.out.println("posicion["+i+"]["+j+"]="+edades[i][j]);
            }
        }
        
        String verduleria[][] = {{"papa", "batata", "zapallo", "berenjena", "cebolla"}, {"naranja", "manzana", "pera", "kiwi"}};
        
        for (int i = 0; i<verduleria.length; i++){
            for (int j = 0; j<verduleria[i].length;j++){
                System.out.println("Articulo ("+i+";"+j+"): " + verduleria[i][j]);
            }
        }
        
        Persona personas[][] = new Persona[2][3];
        personas[0][0] = new Persona("Viqui");
        personas[0][1] = new Persona("Mau");
        personas[0][2] = new Persona("Juan");
        personas[1][0] = new Persona("nano");
        personas[1][1] = new Persona("tomy");
        personas[1][2] = new Persona("pelu");
        imprimir(personas);
    }
    
    public static void imprimir(Object matriz[][]){
        for (int i = 0; i<matriz.length; i++){
            for (int j = 0; j<matriz[i].length;j++){
                System.out.println("Valor en la posicion ("+i+";"+j+"): " + matriz[i][j]);
            }
        }
    }
    
}
