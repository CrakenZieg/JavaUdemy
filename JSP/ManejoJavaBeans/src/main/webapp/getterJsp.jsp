<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee los valores de un JavaBean</title>
    </head>
    <body>
        <h1>JSP que lee los valores de un JavaBean!</h1>
<!-- busca la instancia para ese scope o crea una instancia si no existe -->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
<!-- con getProperty Java llama al metodo get+property haciendo mayus en la 
primer letra del nombre de la propiedad, por eso aunque no existe el atributo
area podemos llamar a la propiedad 'area', y en realidad llamamos al metodo getArea()
-->
        </br>
        Valor base: <jsp:getProperty name="rectangulo" property="base" />
        </br>
        Valor altura: <jsp:getProperty name="rectangulo" property="altura" />
        </br>
        Valor area: <jsp:getProperty name="rectangulo" property="area" />
        </br>
        </br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
