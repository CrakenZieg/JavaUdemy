<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance variables</title>
    </head>
    <body>
        <h1><b>Alcance variables!</b></h1>
        <br/><br/>
        <b>Variable request:</b>
        <br/><br/>
        Base: ${rectanguloRequest.base}<br/>
        Altura: ${rectanguloRequest.altura}<br/>
        Area: ${rectanguloRequest.area}
        <br/><br/>
        <b>Variable session:</b>
        <br/><br/>
        Base: ${rectanguloSession.base}<br/>
        Altura: ${rectanguloSession.altura}<br/>
        Area: ${rectanguloSession.area}
        <br/><br/>
        <b>Variable application:</b>
        <br/><br/>
        Base: ${rectanguloApplication.base}<br/>
        Altura: ${rectanguloApplication.altura}<br/>
        Area: ${rectanguloApplication.area}
        <br/><br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al inicio</a>
    </body>
</html>
