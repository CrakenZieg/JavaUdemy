import { Component } from '@angular/core';
import { Persona } from './persona.model';
import { LoggingService } from './LoggingService.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Listado de Personas';

  personas:Persona[]=[
    new Persona('Carlos','Saul'),
    new Persona('Saul','Goodman'),
    new Persona('Goodman','Perez')
  ];

  constructor(private loggingService:LoggingService){}

  personaAgregada(persona:Persona){
    this.loggingService.enviarMensajeAConsola("Persona agregada al arreglo: "+ persona.nombre+" "+persona.apellido);
    this.personas.push(persona);
  }

}
