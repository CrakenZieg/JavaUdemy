
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
    //suponemos usuario nuevo
        boolean nuevoUsuario = true;
    //obtenemos el array de cookies
        Cookie[] cookies = request.getCookies();
    //buscamos si existe una cookie creada con anterioridad llamada 'visitanteRecurrente'
        if(cookies != null){
            for(Cookie c: cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
    //Si ya existe la cookie es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        String mensaje = null;
    //Si es un usuario nuevo
        if(nuevoUsuario){
    //creamos la cookie 'visitanteRecurrente'
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
    //la agregamos a la respuesta
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez!";
        } else {
            mensaje = "Gracias por visitar nuevamente nuestro sitio!";
        }
    //generamos una respuesta con la informacion en base a la cookie
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje: "+ mensaje);
        out.close();
        
    }
}
