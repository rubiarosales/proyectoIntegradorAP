import { Component, OnInit } from '@angular/core';
import { persona } from '../model/persona.model';
import { PersonaService } from '../servicios/persona.service';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';

@Component({
  selector: 'acerca-de-section',
  templateUrl: './acerca-de-section.component.html',
  styleUrls: ['./acerca-de-section.component.css']
})
export class AcercaDeSectionComponent implements OnInit {

  persona: persona= new persona("","","","","","","","");

  miPortfolio:any;

  constructor(private datosPortfolio:PortfolioServiceService,
              public personaService:PersonaService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
      this.miPortfolio=data;
    });

    this.personaService.getPersona().subscribe(data=>{
      this.persona=data;});
  }

}
