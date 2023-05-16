function validarForma(forma){
    
    var usuario = forma.usuario;
    
    if(usuario.value == "" || usuario.value == "Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus(); //enfoca en el campo
        usuario.select(); //lo selecciona
        return false; //retorna false para que no haga la accion posterior al submit
    }
    
    var password = forma.password;
    
    if(password.value == "" || password.value.length < 3){
        alert("Debe proporcionar un password de más de 3 caracteres");
        password.focus(); //enfoca en el campo
        password.select(); //lo selecciona
        return false; //retorna false para que no haga la accion posterior al submit
    }
    
    var tecnologias = forma.tecnologia; //devuelve un arreglo
    var checkSeleccionado = false;
    
    for (let i = 0; i < tecnologias.length; i++){
        if(tecnologias[i].checked){ //checked es un atributo de este tipo de input 
            checkSeleccionado = true;
        }        
    }
    
    if(!checkSeleccionado){
        alert("Debe seleccionar una tecnologia");
        return false;
    }
    
    var generos = forma.genero;
    var radioSeleccionado = false;
    
    for (let i = 0; i < generos.length; i++) {
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero");
        return false;
    }
    
    var ocupacion = forma.ocupacion;
    
    if(ocupacion.value == ""){
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    
//formulario valido!
alert("Formulario valido, enviando datos al servidor");
return true;
    
}


