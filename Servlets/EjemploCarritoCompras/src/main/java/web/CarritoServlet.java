
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");
    
//creamos o recuperamos la sesion
    HttpSession sesion = request.getSession();
    
//recuperamos la lista de articulos agregados previamente
    List<String> articulos = (List<String>) sesion.getAttribute("articulos");
//devuelve un objeto y los casteamos a Lista<de strings>

//vemos si hay articulos/existe la lista
    if(articulos == null){
//inicializamos la lista
        articulos = new ArrayList<>();
//la agregamos a la sesion
        sesion.setAttribute("articulos", articulos);
    }
    
//procesamos el articulo nuevo
    String articuloNuevo = request.getParameter("articulo");
    
//revisamos y agregamos el articulo
    if(articuloNuevo != null && !articuloNuevo.trim().equals("")){
        articulos.add(articuloNuevo);
    }
    
//automaticamente modifica la lista de articulos en el objeto session por que 
//estamos manejando referencias de objetos

//con try(){} no necesitamos hacer out.close() ya que cierra automaticamente la sesion 
//al terminar el bloque {}
        try (
//imprimimos la lista:
            PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de articulos</h1>");
            out.print("<br>");
            out.print("<ul>");
//iteramos cada articulo
            for(String articulo: articulos){
            out.print("<li>"+articulo+"</li>");
            }
            out.print("</ul>");
//agregamos link para volver al inicio
            out.print("<br>");
            out.print("<a href='/EjemploCarritoCompras'>Regresar al inicio</a>");
        }

//*Si entramos en http://localhost:8080/EjemploCarritoCompras/ vemos la pagina y podemos agregar articulos
//*cuando clickeamos en 'Enviar' vamos a http://localhost:8080/EjemploCarritoCompras/CarritoServlet
//*si intentamos acceder desde otra ventana a http://localhost:8080/EjemploCarritoCompras/CarritoServlet
//*nos rechaza, nos estamos comunicando mediante un get y el metodo doGet no está definido

    }
}
