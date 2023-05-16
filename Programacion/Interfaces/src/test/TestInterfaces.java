
package test;

import accesodatos.*;

public class TestInterfaces {
    
    public static void main(String[] args) {
//creo una variable tipo Interface, le asigno el hijo en MySQL 
        IAccesoDato datos = new ImplementacionMySQL();
//llamo a uno de los metodos, como la variable lo tiene, pero la asignacion es la 
//que lo implementa, datos.listar() va a llamar al metodo en la clase 
//ImplementacionMySQL
        datos.listar();
//Reutilizo la variable, asignandole ahora el hijo de Oracle
        datos = new ImplementacionOracle();
//Idem, aunque ahora datos.listar() va a llamar al metodo en la clase 
//ImplementacionOracle
        datos.listar();
//El polimorfismo es la razón de esta flexibilidad
        
        IAccesoDato datos1 = new ImplementacionMySQL();
        imprimir(datos1);
        datos1 = new ImplementacionOracle();
        imprimir(datos1);

    
    }
//El siguiente metodo, tiene como parametro a una interface
    public static void imprimir(IAccesoDato datos){
        datos.listar();
    }
    
}
