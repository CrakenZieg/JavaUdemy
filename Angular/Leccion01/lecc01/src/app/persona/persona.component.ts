import { Component } from '@angular/core';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: [],
})
export class PersonaComponent {

  nombre: string = 'Pepe';
  apellido: string = 'Sasasa';
  edad: number = 52;
  // private edad: number = 52;
  // getEdad():number{
  //   return this.edad;
  // }

}
