<!-- Importamos la libreria de JSTL core -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- JSTL extiende de JSP, que extiende de servlet

core: iteraciones, condicionales, manipulación de URL y otras funciones generales.
xml: para la manipulación de XML y para XML-Transformation.
sql: para gestionar conexiones a bases de datos.
fmt: para la internacionalización y formateo de las cadenas de caracteres como cifras.

-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core (JSP Standar Tag Library)</h1>
        <!-- Manipulacion de Variables -->
        <!-- definimos la variable -->
        <c:set var="nombre" value="Ernesto"/>
        <!-- desplegamos el valor -->
        Varialbe nombre: <c:out value="${nombre}"/>
        </br>
        </br>
        Variable con codigo html: 
        <c:out value="<h4>Hola!</h4>" escapeXml="false"/>
        </br>
        </br>
        <!-- Codigo condicionado, uso de if -->
        <c:set var="bandera" value="true"/>
        
        <c:if test="${bandera}" >
            La bandera es verdadera!
        </c:if>
        </br>   
        <!-- Codigo condicionado, uso de switch -->
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    </br> 
                    Opcion 1 seleccionada
                </c:when>
                <c:when test="${param.opcion == 2}">
                    </br> 
                    Opcion 2 seleccionada
                </c:when>
                <c:otherwise>
                    </br>
                    Opcion proporcionada desconocida: ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>
        <!-- Iteracion de un arreglo -->
        <%
            String nombres[] = {"Claudia", "Pedro", "Juan"};
            request.setAttribute("nombres", nombres);
        %>
        </br>
        Lista de nombres:
        </br>
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>Nombre: ${persona}</li>
            </c:forEach>
        </ul>
<!-- Expression language va a buscar la variable 'nombres' en los diferentes scopes,
     en el orden: page, request, session, aplication
-->
        </br>
        </br>
        <a href="index.jsp">Volver</a>
    </body>
</html>
