<% 
    String colorFondo = request.getParameter("colorFondo");
%>
<%-- Tiene sentido usar la variable request ya que es un servlet diferente --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor='<%=colorFondo%>'>
        <h1>Hello World!</h1>
    </body>
</html>
