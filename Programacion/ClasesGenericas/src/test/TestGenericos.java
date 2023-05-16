
package test;

import genericos.ClaseGenerica;

public class TestGenericos {
    
    public static void main(String[] args) {
        
        ClaseGenerica<Integer> objetoInteger = new ClaseGenerica(15);
        
        objetoInteger.obtenerTipo();
        
        ClaseGenerica<String> objetoString = new ClaseGenerica("Roberto");
        
        objetoString.obtenerTipo();
        
    }
    
}
