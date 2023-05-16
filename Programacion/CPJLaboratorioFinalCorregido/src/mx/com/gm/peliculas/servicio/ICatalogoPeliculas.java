
package mx.com.gm.peliculas.servicio;

public interface ICatalogoPeliculas {
    
    String NOMBRE_ARCHIVO = "peliculas.txt";
    
    public void agregarPelicula(String nombrePelicula);
    
    public void listarPelicula();

    public void buscarPelicula(String buscar);

    public void iniciarCatalogoPeliculas();
    
}