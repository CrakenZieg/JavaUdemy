
package test;

import java.util.*;

public class TestColeccionesGenericas {
    public static void main(String[] args) {
//Las colecciones previamente vistas no tenian un tipo determinado hasta ser inicializadas
//ahora aclaramos que los elementos de la lista (o coleccion) que implementamos 
//van a ser de tipo String, la ventaja es al procesar, por ejemplo 2 colecciones de 
//distinto tipo son distintas y listo, no hace falta comparar hash
        List<String> miLista = new ArrayList<>();
//List<tipo> (nombre) = new tipoColeccion<notacionDiamante>(constructorVacio);
//ya en tiempo de compilacion nos marca error al introducir un elemento de tipo diferente
//la ventaja tambien es que al recuperar un elemento de esa coleccion no necesitamos 
//marcar su tipo o hacer conversion, sabemos que si el generico es String, los 
//elementos son String, por ejemplo:
//System.out.println("elementoDeLaLista = " + miLista.get(3))
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");
        imprimirColeccion(miLista);
//La coleccion tipo set no mantiene el orden, se procesa mas rapido que la lista
//el set no permite repetir elementos
        Set<String> miSet = new HashSet<>();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Sabado");
        miSet.add("Domingo");
        imprimirColeccion(miSet);
        
//Para los mapas, podemos aclara el tipo generico de la key y del valor
        Map<String, String> miMapa = new HashMap<>();
        miMapa.put("valor1", "Roberto1");//como no hereda de colleciones, el metodo 
        miMapa.put("valor2", "Roberto2");//para agregar es otro (map).put(key, value)
        miMapa.put("valor3", "Roberto3");//los argumentos son objetos
//Si en un map agregamos un valor con una key que ya existe, ese valor reemplaza al
//anterior que ya estaba asociado a esa key        
        String elementoDelMapa = miMapa.get("valor2");
        System.out.println("elementoDelMapa = " + elementoDelMapa);
        
        imprimirColeccion(miMapa.keySet());//(map).keyset() devuleve un set con las key
        imprimirColeccion(miMapa.values());//(map).keyset() devuleve un set con los valores
        
    }
    
    public static void imprimirColeccion(Collection<String> coleccion) {
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
