
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
//con doPost vamos a procesar los valores que nos envia el formulario y después respondemos al navegador
//leemos los parametros del formulario html con .getParameter()
    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");
    
    System.out.println("usuario = " + usuario);
    System.out.println("password = " + password);
        
    PrintWriter out = response.getWriter();
    out.print("<html>");
    out.print("<body>");
    out.print("El parametro usuario es: "+usuario);
    out.print("<br/>");
    out.print("El parametro contraseña es: "+password);
    out.print("</body>");
    out.print("</html>");
    out.close();
    
    }
    
}
