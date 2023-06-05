import { Component, EventEmitter, Output } from '@angular/core';
import { Persona } from '../persona.model';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: []
})
export class FormularioComponent {

  nombreInput:String='';
  apellidoInput:String='';
//Clase que va a enviar el mensaje a la clase padre, va a propagar el objeto persona al
//componente padre
  @Output() personaCreada = new EventEmitter<Persona>();

  agregarPersona(){
//creo la persona con los datos de input del html
    let persona = new Persona(this.nombreInput,this.apellidoInput);
//uso el emiter para propagar la persona creada
    this.personaCreada.emit(persona);
  }

}
