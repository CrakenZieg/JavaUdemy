<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/122618b89b.js" crossorigin="anonymous"></script>
        <title>Control de Clientes</title>
    </head>
    <body>
        <!-- igual que con otras herramientas, puedo desarmar la pagina en diferentes paginas/componentes y rearmarla -->
        <!-- header -->  
        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp"/>    
        <!-- nav -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/> 
        <!-- listado -->
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>
        <!-- footer -->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/> 

    </body>
</html>
