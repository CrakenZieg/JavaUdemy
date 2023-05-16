<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!-- Usamos los tags de struts -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludos desde Struts2</title>
    </head>
    <body>
        <!-- accedemos a la variable saludosAtr de la clase HolaMundoStruts mediante su getter -->
        <h1><s:property value="saludosAtr"></s:property></h1>
    </body>
</html>
