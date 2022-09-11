import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CargarScriptService } from '../servicios/cargar-script.service';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';


@Component({
  selector: 'header-section',
  templateUrl: './header-section.html',
  styleUrls:['./header-section.css']
})
export class headerSection implements OnInit {

  miPortfolio:any;

  constructor(private datosPortfolio:PortfolioServiceService, private script:CargarScriptService, private router:Router) { 

    script.cargar([`proyecto_integrador`]);

  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
      this.miPortfolio=data;
    });

  }
  login(){
    this.router.navigate(['/login']);
  }

}