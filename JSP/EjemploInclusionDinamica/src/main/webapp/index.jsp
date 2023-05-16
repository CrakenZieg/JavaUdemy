<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusion Dinamica</title>
    </head>
    <body>
        <h1>Ejemplo Inclusion Dinamica!</h1>
        <br>
<%--Incluimos las 2 paginas dentro de la original--%>
        <jsp:include page="paginas/recursoPublicoJSP.jsp"></jsp:include>
        <br>
<%--A esta segunda le pasamos un paramtro tambien--%>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
    </body>
</html>
