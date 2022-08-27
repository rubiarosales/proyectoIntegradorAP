import { Component, OnInit } from '@angular/core';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';

@Component({
  selector: 'acerca-de-section',
  templateUrl: './acerca-de-section.component.html',
  styleUrls: ['./acerca-de-section.component.css']
})
export class AcercaDeSectionComponent implements OnInit {

  miPortfolio:any;

  constructor(private datosPortfolio:PortfolioServiceService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
      this.miPortfolio=data;
    });
  }

}
