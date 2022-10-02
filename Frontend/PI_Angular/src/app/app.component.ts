import { Component } from '@angular/core';
import { CargarScriptService } from './servicios/cargar-script.service';

@Component({
  selector: 'app-root',
  templateUrl: `./app.component.html`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PI_Angular';

  constructor(script:CargarScriptService){
    script.cargar([`proyecto_integrador`]);
  }




  
}