import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PortfolioServiceService } from '../../servicios/portfolio.service';


@Component({
  selector: 'header-section',
  templateUrl: './header-section.html',
  styleUrls:['./header-section.css']
})
export class headerSection implements OnInit {

  miPortfolio:any;

  constructor(private datosPortfolio:PortfolioServiceService, private router:Router) { 



  }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data=>{
      this.miPortfolio=data;
    });

  }


}