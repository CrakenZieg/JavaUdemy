const personas = [
    new Persona('Peludo1','Gato1'),
    new Persona('Peludo2','Gato2'),
    new Persona('Peludo3','Gato3')
]

function mostrarPersonas(){
    let texto = '';
    for(let persona of personas){
        texto += `<li>${persona.nombre} ${persona.apellido}</li>`;
    }
    document.getElementById('personas').innerHTML = texto;
}

function agregarPersona(){
// Recuperamos el formulario
    const formulario = document.forms['forma']; 
// Recuperamos los 2 inputs
    const nombre = formulario['nombre'];
    const apellido = formulario['apellido'];
// Si no son vacios los valores de los elementos creamos un obj y lo cargamos al arreglo
//! lo pense antes que ubaldo, punto para mi
    if(nombre.value!=''&&apellido.value!=''){
        let persona = new Persona(nombre.value, apellido.value);
        personas.push(persona);
    }
// renovamos la vista del arreglo
    mostrarPersonas();
}