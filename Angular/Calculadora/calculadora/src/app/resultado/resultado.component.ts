import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-resultado',
  templateUrl: './resultado.component.html',
  styleUrls: []
})
export class ResultadoComponent {

  @Input() resultado=0;

}
