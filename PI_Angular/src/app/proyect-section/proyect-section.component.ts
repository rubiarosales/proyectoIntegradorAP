import { Component, OnInit } from '@angular/core';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';

@Component({
  selector: 'proyect-section',
  templateUrl: './proyect-section.component.html',
  styleUrls: ['./proyect-section.component.css']
})
export class ProyectSectionComponent implements OnInit {
  proyectList:any;

  constructor(private datosPortfolio:PortfolioServiceService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
    this.proyectList=data.proyects;
    });
  }
}

