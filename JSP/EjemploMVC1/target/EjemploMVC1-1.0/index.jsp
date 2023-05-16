<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <br>
<!-- ponemos el nombre como expresion language para que se modifique automaticamente 
    si es que nosotros modificamos el nombre de la aplicacion (sea contextPath o la carpeta)
--> 
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al Servlet Controlador que despliega las variables
        </a>
    </body>
</html>
