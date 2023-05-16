
package test;

import java.util.*;

public class TestColecciones {
    public static void main(String[] args) {
//La ventaja de las colecciones sobre los Array es que a la lista le podemos sumar 
//elementos dinamicamente (el array se crea con determinada cantidad de elementos)
//La coleccion tipo lista mantiene el orden
        List miLista = new ArrayList();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");
        imprimirColeccion(miLista);
//La coleccion tipo set no mantiene el orden
        Set miSet = new HashSet();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Sabado");
        miSet.add("Domingo");
        imprimirColeccion(miSet);
//la ventaja del set sobre la lista es que es más rapido para trabajar con/sobre el
//la ventaja de la lista es que esta ordenada y ademas se pueden repetir elementos
//Un mapa funciona asociando un valor a una llave, donde ambos son tipo Object
        Map miMapa = new HashMap();
        miMapa.put("valor1", "Roberto1");//como no hereda de colleciones, el metodo 
        miMapa.put("valor2", "Roberto2");//para agregar es otro (map).put(key, value)
        miMapa.put("valor3", "Roberto3");//los argumentos son objetos
        
        String elementoDelMapa = (String) miMapa.get("valor2");
        System.out.println("elementoDelMapa = " + elementoDelMapa);
        
        imprimirColeccion(miMapa.keySet());//(map).keyset() devuleve un set con las key
        imprimirColeccion(miMapa.values());//(map).keyset() devuleve un set con los valores
        
    }
    
    public static void imprimirColeccion(Collection coleccion) {
        //ciclo for each (el parametro es un objeto "elemento" que pertenece a "miLista")
        System.out.println(coleccion.toString() + "en ciclo 'for(Object elemento: colecion)'");
        for(Object elemento: coleccion){
            System.out.println("Elemento = " + elemento);
        }
        System.out.println(coleccion.toString() + "en ciclo 'colecion.forEach(elemento ->'");
        //con funcion lamda o flecha (para cada elemento de "miLista" )
        coleccion.forEach(elemento -> {
            System.out.println("Elemento = " + elemento);
        });
    }
}
