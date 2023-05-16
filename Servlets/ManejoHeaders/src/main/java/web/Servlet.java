
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//Metodo Http
        String metodoHttp = request.getMethod(); 
//Uri: uniform resource identifier, cadena que identifica los recursos –físicos o abstractos– de una red de forma unívoca
        String uri = request.getRequestURI(); 
//Tipo de autenticación
        String AuthType = request.getAuthType();
//tipo de headers
        Enumeration headers =request.getHeaderNames();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Headers HTTP</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Headers HTTP</h1>");
        out.print("Metodo http: " + metodoHttp + " (porque es un link)");
        out.print("<br>");
        out.print("URI: " + uri);
        out.print("<br>");
        out.print("AuthType: " + AuthType);
        out.print("<br>");
        while(headers.hasMoreElements()){
            String nombreHeader = (String) headers.nextElement();//devuelve un objet, con (String) lo downcasteamos a string
            out.print("Header: <b>" + nombreHeader + "</b>");
            out.print("<br>");
            out.print(request.getHeader(nombreHeader));
            out.print("<br>");
        }
        
        
        
        out.print("</body>");
        out.print("</html>");
        
        
    }
}
