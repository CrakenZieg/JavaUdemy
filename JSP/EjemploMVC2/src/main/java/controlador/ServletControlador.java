
package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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
        
        String accion = request.getParameter("accion");
        
        //2do paso: Creamos los JavaBeans para diferentes scopes
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 4);
        Rectangulo recApplication = new Rectangulo(5, 6);
        
        //3er paso: Agregamos los JavaBean a los diferentes alcances
        //revisamos el parametro accion proporcionado:
        if("agregarVariables".equals(accion)){
            //alcance request
            request.setAttribute("rectanguloRequest", recRequest);    
            //alcance session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSession", recSession);
            //alcance application
            //debemos recuperar el contexto del servlet
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", recApplication);
            //agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
        
        //4to paso: Redireccionamos al jsp de index
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } else if ("listarVariables".equals(accion)){
                        
        //4to paso: Redireccionamos al jsp que despliega las variables
            //vamos a crea un jsp privado, por eso lo creamos en WEB-INF (no es un recurso publico)
            //solo va a ser accesible desde el lado del servidor => los servlets
            //hacemos forward para reeviar los obj request y response que tienen 
            //toda la informacion que agregamos antes
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
//.getRequestDispatcher funciona como envoltorio (wrapper) de lo que nosotros queramos
//comunicar dentro del servidor y para el lado del cliente
        } else {//si no proporcionamos ningun parametro
        
        //4to paso: Accion no proporcionada o desconocida
            request.setAttribute("mensaje", "Accion no proporcionada o desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            
        //response.sendRedirect("index.jsp"); tambien nos devolveria al index, sin
        //embargo no nos permite compartir informacion con el JSP ya que no 
        //propaga los objetos request y response
        
        }
        
        
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariable.jsp");
        //propagamos a esta vista los objetos request y response
        rd.forward(request, response);
        
    }
    
}
