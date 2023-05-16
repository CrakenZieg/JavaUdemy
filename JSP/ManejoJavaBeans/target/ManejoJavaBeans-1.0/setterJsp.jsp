
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica a un JavaBean</title>
    </head>
    <body>
        <h1>JSP que modifica a un JavaBean!</h1>
<!-- Creamos un objeto rectangulo: usamos el bean -> creamos variable rectangulo 
-> va a ser una instancia de beans.Rectangulo (de esa clase) -> alcance de session
para que no se elimine inmediatamente (hay 4 scopes page, request, session, application )

request: cuando pedimos se crea el objeto pero dura mientras la request

session: cuando pedimos se crea pero dura mientras existe la sesion

application: cuando pedimos se crea pero dura mientras funciona la aplicacion

-->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        Modificamos los atributos:
        </br>
<!-- Definimos los valores
-->
        <%
            int baseValor = 5;
            int alturaValor = 10;
        %>
<!-- Le pasamos los valores a la instancia mediante los setters
-->
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>" />
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>" />
        
        Nuevo valor de base: <%=baseValor%>
        </br>
        Nuevo valor de altura: <%=alturaValor%>
        </br>
        </br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
