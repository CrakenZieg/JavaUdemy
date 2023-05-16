
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//vamos a responder con html
        response.setContentType("text/html;charset=UTF-8");
//se va a refrescar cada segundo
        response.setHeader("refresh", "1");
//obtenemos la fecha actual
        Date fecha = new Date();
//generamos un formato para fecha
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");
//formateamos nuestra fecha
        String horaFormateada = formateador.format(fecha);
        
        PrintWriter out = response.getWriter();
        out.print("Hora actualizada: " + horaFormateada);
        out.close();
        
    }
}
