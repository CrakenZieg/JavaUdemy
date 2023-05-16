
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //simulando los valores correctos
        String usuarioOk = "Juan";
        String passwordOk = "1234";
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        
        if(usuarioOk.equals(usuario) && passwordOk.equals(password)){
            out.print("<h1>");
            out.print("Datos correctos");
            out.print("</h1>");
            out.print("<h2>");
            out.print("<br>Usuario: "+usuario);
            out.print("<br>Password: "+password);
            out.print("</h2>");
        } else {
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
        }
        
        
    }
    
}
