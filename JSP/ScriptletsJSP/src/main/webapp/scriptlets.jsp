<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br><%--los comentarios en java no van al navegador--%> <!-- los comentarios html van al navegador -->
        <%--Scriplet para enviar informacion al navegador--%>
        <% 
            out.print("Saludos desde un Scriptlet");
        %>
        <br>
        <%--Scriplet para manipular los objetos implicitos--%>
        <% 
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicacion: "+nombreAplicacion);
        %>
        <br>
        <%--Scriplet con codigo condicionado--%>
        <%--Lo siguiente no es buena practica--%>
        <% 
            if(session != null && session.isNew()) {
        %>
        La sesion Si es nueva
        <% 
            } else if(session != null) {
        %>
        La sesion No es nueva
        <% } %>
        <br>
        <a href="index.html">Regresar al inicio</a>
    </body>
</html>
