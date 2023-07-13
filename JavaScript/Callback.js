//! Una funcion callback es una funcion que se llama como parametro a otra funcion

function imprimir(msj){
    console.log("llamaste a imprimir()");
    console.log(msj);    
}

function chaChaCha(n, funcion){
    let cadena="";
    for(let i = 0; i<n ; i++){
        cadena = cadena+"Cha";
    }
    funcion(cadena);
}

chaChaCha(5,imprimir);