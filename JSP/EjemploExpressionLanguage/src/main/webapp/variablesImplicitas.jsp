<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL y variabables implicitas</title>
    </head>
    <body>
        <h1>EL y variabables implicitas</h1>
<!-- 
Expression Language te permite generar formatos de texto y demas que pueden
acceder a diferentes datos, en el ejemplo, accede a datos como el path, headers,
sesion, parametros que le mandamos y tipo de server, hay muchas mas opciones
-->
        <ul>
            <li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
            <li>Navegador del Cliente: ${header["User-Agent"]}</li>
            <li>Id Sesion: ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <li>Valor parametro: ${param.usuario}</li>
        </ul>
        </br>
        </br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
