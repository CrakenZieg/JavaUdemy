package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//Este "decorador" me permite reconocerlo y accederlo desde el navegador
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet{
//Sobreescribimos los metodos de la clase padre HttpServlet
//doGet() recibe 2 parametros, request y response, glassfish se va a encargar de llamar a este metodo
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//recibimos la peticion request y respondemos
//definimos lo que vamos a contestar -texto/html,etc-
        response.setContentType("text/html;charset=UTF-8");
//PrintWriter: prints formatted representations of objects to a text-output stream
        PrintWriter out = response.getWriter();
//respondemos
        out.println("Hola mundo desde Servlets");
        
    }
    
}
