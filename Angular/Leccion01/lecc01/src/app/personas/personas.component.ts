import { Component } from '@angular/core';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: []
})
export class PersonasComponent {
  deshabilitar = false;
  mensaje ='';
  titulo = 'Titulo';
  mostrarMensaje=false;

  agregarPersona(){
    this.mensaje = 'Persona agregada';
    this.mostrarMensaje=!this.mostrarMensaje;
  }

  modificarTitulo(event: Event){
    this.titulo = (<HTMLInputElement>event.target).value;
  }

}
