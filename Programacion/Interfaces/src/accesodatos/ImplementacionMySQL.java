
package accesodatos;

//La clase debe implementar los metodos de la interface o sea abstracta (y que los implemente un hijo)
public class ImplementacionMySQL implements IAccesoDato {

    @Override //implementa un metodo abstract
    public void insertar() {
        System.out.println("Insertad desde MySQL");
    }

    @Override
    public void listar() {
        System.out.println("Listas desde MySQL");
    }

    @Override
    public void actualizar() {
        System.out.println("Actualizar desde MySQL");
    }

    @Override
    public void eliminar() {
        System.out.println("Eliminardesde MySQL");
    }
    
}
