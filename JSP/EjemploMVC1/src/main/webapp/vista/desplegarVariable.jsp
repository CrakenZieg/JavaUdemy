<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables</h1>
        Variable en alcance de request:
    <!-- expression language va a buscar en los diferentes scopes la variable 
    'mensaje', en este caso nosotros la habíamos agregado en el request -->
        ${mensaje}
        </br>
        Variable en calcance de sesion:
        </br>
        Rectangulo:
        </br>
        Base: ${rectangulo.base} 
        Altura: ${rectangulo.altura}
        Area: ${rectangulo.area}
    <!-- hay que recordar que no accedemos directamente a las propiedades, en 
    realidad se accede a los metodos getBase, getAltura y getArea -->
        </br>
        <a href="${pageContext.request.contextPath}/index.jsp">
            Link al index
        </a>
    </body>
</html>
