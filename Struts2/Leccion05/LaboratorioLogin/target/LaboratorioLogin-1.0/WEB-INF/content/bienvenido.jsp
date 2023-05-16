<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="bienvenido.titulo" /></title>
    </head>
    <body>
        <h1><s:text name="bienvenido.titulo" /></h1>
        <h2>
            <s:text name="bienvenido.mensaje" />
        </h2>
        </br>
        <s:text name="form.usuar" />: <s:property value="usuario" />
        </br>
        <s:text name="form.contra" />: <s:property value="password" />
    </body>
</html>
