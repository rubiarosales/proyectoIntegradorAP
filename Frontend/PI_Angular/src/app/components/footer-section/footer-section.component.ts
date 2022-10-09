import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RedesSociales } from '../../model/redes-sociales';
import { PortfolioServiceService } from '../../servicios/portfolio.service';
import { RedesService } from '../../servicios/redes.service';
import { TokenService } from '../../servicios/token.service';


@Component({
  selector: 'footer-section',
  templateUrl: './footer-section.component.html',
  styleUrls: ['./footer-section.component.css']
})
export class FooterSectionComponent implements OnInit {
  
  red:RedesSociales[]=[];

miPortfolio:any;

constructor(private datosPortfolio:PortfolioServiceService, private tokenService:TokenService, private router:Router, private redService:RedesService) { }

  isLogged=false;

  ngOnInit(): void {
  if (this.tokenService.getToken()){
    this.cargarRedes();
    this.isLogged=true;
  }else{
    this.isLogged=false;
  }
  }
  
  cargarRedes():void{
  this.redService.listaRedes().subscribe(
    data =>{this.red = data})
  }
  }