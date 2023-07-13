//! Podemos usar variables sin declararlas, pero no es una buena practica
//! Lo podemos solucionar simplemente incluyendo "use strict" al principio del archivo
"use strict"

//# x = 10; nos da error, debemos agregar let o var
let x = 0;
console.log(x);

//? podemos usar "use strict" al principio del archivo o al principio de una funcion