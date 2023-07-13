'use strict'

try{
    let x=10;
    throw new Error('throw error en try pa!');
}catch(error){
    console.log(error);
    console.log(error.name);
    console.log(error.message);
}finally{
    console.log("finally!");
}
console.log("llegamo al final de archivo!");

//# podemos throw errores