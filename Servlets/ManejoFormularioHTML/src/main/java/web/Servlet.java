
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usuario"); //recuperamos el parametro
        String password = request.getParameter("password"); //idem
        String tecnologias[] = request.getParameterValues("tecnologia"); //recuperamos los valores del parametro (es un array)
        String generos = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String musica[] = request.getParameterValues("musica");
        String comentarios = request.getParameter("comentarios");
        
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Resultado Servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el Servlet</h1>");
        out.print("<table border='1'>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario: ");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Password: ");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Tecnologias: ");
        out.print("</td>");
        out.print("<td>");
        for(String tecnologia:tecnologias){
            out.print(tecnologia);
            out.print(" / ");
        }
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Genero: ");
        out.print("</td>");
        out.print("<td>");
        out.print(generos);
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupacion: ");
        out.print("</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Musica: ");
        out.print("</td>");
        out.print("<td>");
        if(musica != null){//si no pones el condicional, puede intentar imprimir null
            for(String musicas: musica){
                out.print(musicas);
                out.print(" / ");
            }
        } else {
            out.print("Valor no proporcionaco");
        }
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Comentarios: ");
        out.print("</td>");
        out.print("<td>");
        out.print(comentarios);
        out.print("</td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
        
        
        
    }
 
}
