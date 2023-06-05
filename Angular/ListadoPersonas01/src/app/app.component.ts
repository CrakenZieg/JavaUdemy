import { Component } from '@angular/core';
import { Persona } from './persona.model';

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

  personaAgregada(persona:Persona){
    this.personas.push(persona);
  }

}
