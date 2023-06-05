import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: []
})
export class FormularioComponent {

  operandoA=0;
  operandoB=1;
  @Output() resultado=new EventEmitter<number>;

  onSuma(){
    this.resultado.emit(this.operandoA+this.operandoB);
    console.log(this.operandoA+" + "+this.operandoB+" = "+this.resultado);
  }
  onResta(){
    this.resultado.emit(this.operandoA-this.operandoB);
  }
  onMultiplicacion(){
    this.resultado.emit(this.operandoA*this.operandoB);
  }
  onDivision(){
    this.resultado.emit(this.operandoA/this.operandoB);
  }

}
