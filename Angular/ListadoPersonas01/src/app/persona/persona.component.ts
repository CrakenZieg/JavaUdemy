import { Component, Input } from '@angular/core';
import { Persona } from '../persona.model';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: []
})
export class PersonaComponent {

//el decorador le dice a la clase que los atributos vienen de la clase padre
  @Input() persona:Persona = new Persona('','');
  @Input() i:number = 0;

}
