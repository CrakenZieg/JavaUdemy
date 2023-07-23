// podemos usar los imports porque estan dentro de los scripts del html
const ingresos = [    
    new Ingreso('ingreso 1', 375),
    new Ingreso('ingreso 2', 2932)
];
//* lo const es la referencia al objeto, no los objetos dentro de este
const egresos = [    
    new Egreso('egreso 1', 864),
    new Egreso('egreso 2', 1807)
];

let cargarApp = ()=>{
    cargarCabecero(); 
    cargarIngresos();
    cargarEgresos();   
};

let totalIngresos = ()=>{
    let totaIngreso = 0;
    for(let ingreso of ingresos){
        totaIngreso += ingreso.valor; 
    }
    return totaIngreso;
}

let totalEgresos = ()=>{
    let totalEgreso = 0;
    for(let egreso of egresos){
        totalEgreso += egreso.valor; 
    }
    return totalEgreso;
}

let cargarCabecero = ()=>{
    let presupuestoTotal = totalIngresos() - totalEgresos();
    let porcentajeEgreso = totalEgresos()/totalIngresos();
    document.getElementById('presupuesto').innerHTML = formatoMoneda(presupuestoTotal);
    document.getElementById('porcentaje').innerHTML = formatoPorcentaje(porcentajeEgreso);
    document.getElementById('ingresos').innerHTML = formatoMoneda(totalIngresos());
    document.getElementById('egresos').innerHTML = formatoMoneda(totalEgresos());
};

const formatoMoneda = (valor)=>{
    return valor.toLocaleString('es-AR',{style:'currency', currency:'ARS', minimumFractionDigits:2});
};

const formatoPorcentaje = (porcentaje)=>{
    return porcentaje.toLocaleString('es-AR',{style:'percent', minimumFractionDigits:1});
};

const cargarIngresos = ()=>{
    let ingresosHTML = '';
    for(let ingreso of ingresos){
        ingresosHTML += crearIngresoHTML(ingreso);
    }
    document.getElementById('lista-ingresos').innerHTML = ingresosHTML;
}

const crearIngresoHTML = (ingreso)=>{
    let ingresoHTML = `
    <div class="elemento limpiarEstilos">
    <div class="elemento_descripcion">${ingreso.descripcion}</div>
        <div class="derecha limpiarEstilos">
            <div class="elemento_valor">${formatoMoneda(ingreso.valor)}</div>
            <div class="elemento_eliminar">
                <button class="elemento_eliminar--btn">
                    <ion-icon name="close-circle-outline"
                        onclick="eliminarIngreso(${ingreso.id})"
                    ></ion-icon>
                </button>
            </div>
        </div>
    </div>
    `;
    return ingresoHTML;
};

const cargarEgresos = ()=>{
    let egresosHTML = '';
    for(let egreso of egresos){
        egresosHTML += crearEgresoHTML(egreso);
    }
    document.getElementById('lista-egresos').innerHTML = egresosHTML;
}

const crearEgresoHTML = (egreso)=>{
    let totalEgreso = totalEgresos();
    let egresoHTML = `
    <div class="elemento limpiarEstilos">
    <div class="elemento_descripcion">${egreso.descripcion}</div>
        <div class="derecha limpiarEstilos">
            <div class="elemento_valor">${formatoMoneda(egreso.valor)}</div>
            <div class="elemento_porcentaje">${formatoPorcentaje(egreso.valor/totalEgreso)}</div>
            <div class="elemento_eliminar">
                <button class="elemento_eliminar--btn">
                    <ion-icon name="close-circle-outline"
                        onclick="eliminarEgreso(${egreso.id})"
                    ></ion-icon>
                </button>
            </div>
        </div>
    </div>
    `;
    return egresoHTML;
};

const eliminarIngreso = (id) =>{
//buscamos el indice del ingreso con id===param, usamos la funcion flecha que nos va a retornar el ingreso 
//cuyo id es igual al param
    let indexElim = ingresos.findIndex(ingreso => ingreso.id === id);
    console.log(indexElim);
    console.log(ingresos[indexElim]);
    ingresos.splice(indexElim,1);    
    cargarCabecero();
    cargarIngresos();
};

const eliminarEgreso = (id) =>{
    let indexElim = egresos.findIndex(egreso => egreso.id === id);
    egresos.splice(indexElim,1);
    cargarCabecero();
    cargarEgresos();
};

let agregarDato = ()=>{
//recuperamos el elemento formulario
    let formulario = document.forms['formulario'];
//recuperamos el elemento tipo, hijo de formulario, y etc
    let tipo = formulario['tipo'];
    let descripcion = formulario['descripcion'];
    let valor = formulario['valor'];
    if(descripcion.value !== '' && valor.value !== ''){
        if(tipo.value === 'ingreso'){
            ingresos.push(new Ingreso(descripcion.value,Number(valor.value)));
            cargarCabecero();
            cargarIngresos();
        }else if(tipo.value === 'egreso'){
        //en valor.value tenemos una sintaxis simplificada para parsear un string a number
            egresos.push(new Egreso(descripcion.value,+valor.value));
            cargarCabecero();
            cargarEgresos();
        }
    }
}