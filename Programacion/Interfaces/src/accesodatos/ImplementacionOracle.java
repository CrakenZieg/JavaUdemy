
package accesodatos;

public class ImplementacionOracle implements IAccesoDato {

    @Override
    public void insertar() {
        System.out.println("Insertad desde Oracle");
    }

    @Override
    public void listar() {
        System.out.println("Listar desde Oracle");
    }

    @Override
    public void actualizar() {
        System.out.println("Actualizar desde Oracle");
    }

    @Override
    public void eliminar() {
        System.out.println("Eliminar desde Oracle");
    }
    
}
