
package accesodatos;

public interface IAccesoDato {
//las interfaces no heredan de la clase Object, pero si hay herencia ente interfaces
//Los atributos en las interfaces son constantes (public static final, el compilador lo agrega)
//No podemos dejar atributos sin asignar valor 
//Las interfaces no tienen constructor y todos sus metodos son public abstract (también lo agrega el comp)
    
    int MAX_REGISTROS = 10;
    
//metodos clasicos de manejo con DDBB
    void insertar();
    
    void listar();
    
    void actualizar();
    
    void eliminar();
    
//Cada uno de los metodos anteriores los van a implementar las clases que trabajen con esta interface
}
