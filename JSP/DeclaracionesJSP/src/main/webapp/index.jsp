<%--Agregamos una declaracion de JSP, podemos declara un atributos o metodos, 
van a formar parte de la clase del servlet generado--%>

<%! 
    //Declaramos una variable con su metodo get
    private String usuario = "Alberto";
    public String getUsuario(){
        return this.usuario;
    }
    //Declaramos un contador de visitas
    private int contadorVisitas = 1;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de Declaraciones con JSP</title>
    </head>
    <body>
        <h1>Uso de Declaraciones con JSP!</h1>
        <br>
        Valor de usuario por medio del atributo: <%= this.usuario %>
        <br>
        Valor de usuario por medio del metodo: <%= this.getUsuario() %>
        <br>
        Contador de visitas: <%= this.contadorVisitas++ %>
    </body>
</html>
