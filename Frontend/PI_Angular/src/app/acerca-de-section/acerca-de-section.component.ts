import { Component, OnInit } from '@angular/core';
import { Persona } from '../model/persona';
import { persona } from '../model/persona.model';
import { PersonaService } from '../servicios/persona.service';
import { PortfolioServiceService } from '../servicios/portfolio.service';
import { TokenService } from '../servicios/token.service';

@Component({
  selector: 'acerca-de-section',
  templateUrl: './acerca-de-section.component.html',
  styleUrls: ['./acerca-de-section.component.css']
})
export class AcercaDeSectionComponent implements OnInit {

  persona: persona= new persona("","","","","","","","");

  miPortfolio:any;

  constructor(private datosPortfolio:PortfolioServiceService,
    private tokenService:TokenService, private personaService:PersonaService) { }
    isLogged=false;
  ngOnInit(): void {
    // this.datosPortfolio.obtenerDatos().subscribe(data=>{
    //   this.miPortfolio=data;
    // });
    this.cargarPersona();
    if (this.tokenService.getToken()){
      // this.cargarPersona();
      this.isLogged=true;
    }else{
      this.isLogged=false;
    }
  }

  cargarPersona():void{
    this.personaService.getPersona().subscribe(
      data =>{this.persona = data})
  }
}
