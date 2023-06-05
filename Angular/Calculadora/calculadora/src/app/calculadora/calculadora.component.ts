import { Component } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: []
})
export class CalculadoraComponent {

  resultadoR=0;

  pasoResultado(resultado:number){
    this.resultadoR=resultado;
  }

}
