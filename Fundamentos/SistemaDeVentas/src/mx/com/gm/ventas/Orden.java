
package mx.com.gm.ventas;

import mx.com.gm.ventas.Producto;

public class Orden {
    
    private static final int MAX_PRODUCTOS = 10;
    private int contadorProductos;
    private static int contadorOrden = 0;
    private int idOrden;
    private Producto productos[];
    
    public Orden(){
        this.idOrden = ++Orden.contadorOrden;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    //inicializo el array con el maximo de elementos, necesitaba inicializarlo ya que no los tipo object empiezan 
    //null hasta que los inicializas
    }
    public void agregarProducto(Producto producto){
        if(this.contadorProductos < Orden.MAX_PRODUCTOS){
            productos[contadorProductos++] = producto;
        } else {
            System.out.println("Se ha superado el máximo de productos: " + Orden.MAX_PRODUCTOS);
        }
    }
    
    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < this.contadorProductos; i++) {
            total += productos[i].getPrecio(); //yo lo haria asi
            /*Producto producto = this.productos[i];
              total += producto.getPrecio();      
            */
        }
        // System.out.println("El total de la orden es: $"+ total);
        return total;
    }
    
    public void mostrarOrden(){
        System.out.println("Id Orden: " + this.idOrden);
        double totalOrden = this.calcularTotal();
        System.out.println("Total de la Orden: $" + totalOrden);
        System.out.println("Productos de la orden:");
        for(int i = 0; i < this.contadorProductos; i++){
            System.out.println(this.productos[i]);
        }
        
    }
    
    
}
