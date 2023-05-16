
package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import modelo.Rectangulo;


@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
        //1er paso: Procesar parametros
        
        //2do paso: Creamos los JavaBeans
        Rectangulo rec = new Rectangulo(3, 4);
        
        //3er paso: Agregamos el JavaBean a algún alcance
        //seteamos en un atributo un mensaje en el request
        request.setAttribute("mensaje", "Saludos desde el servlet");
        
        //creamos un objeto session y le damos el atributo "rectangulo" y valor rec (el JavaBean) 
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rec);
        
        //4to paso: Redireccionamos a la vista seleccionada
        
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariable.jsp");
        //propagamos a esta vista los objetos request y response
        rd.forward(request, response);
        
    }
    
}
