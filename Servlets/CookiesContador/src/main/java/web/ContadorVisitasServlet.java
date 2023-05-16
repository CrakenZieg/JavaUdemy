
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
    //declaramos una variable contador
        int contador = 0;
        
    //Pedimos las cookies
        Cookie[] cookies = request.getCookies();
    //si la lista no está vacia
        if(cookies != null){
    //revisamos si existe la cookie contadorVisitas entre las cookies del navegador
            for(Cookie c: cookies){
                if(c.getName().equals("contadorVisitas")){
    //si alguna es la que buscamos, recuperamos el valor y lo parseamos a entero
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
    //incrementamos las visitas en 1
        contador++;
    //creamos una nueva cookie con los nuevos datos
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
    //hacemos expirar la cookie en una hora (en segundos)
        c.setMaxAge(3600); 
    //la agregamos a la respuesta
        response.addCookie(c);
        
    //enviamos la informacion al navegador
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.print("Contador de visitas de cada cliente: "+ contador);
        
//HTTP es un protocolo stateless, es decir, no guarda informacion, por lo tanto,
//para guardar informacion de sesiones, en este caso, la cantidad de visitas,
//creamos una cookie en el cliente que la almacene, cuando recibimos un get de 
//este, le pedimos la cookie, recuperamos el valor, le agregamos una visita y
//lo sobreescribimos
        
    }
}
