import { Component, OnInit } from '@angular/core';
import { Educacion } from '../model/educacion';
import { EducacionService } from '../servicios/educacion.service';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';
import { TokenService } from '../servicios/token.service';

@Component({
  selector: 'education-section',
  templateUrl: './education-section.component.html',
  styleUrls: ['./education-section.component.css']
})
export class EducationSectionComponent implements OnInit {

  edu:Educacion[]=[];

  educationList:any;

  constructor(private datosPortfolio:PortfolioServiceService,private tokenService:TokenService, private educacionService:EducacionService) { }
  inLogged=false;

  ngOnInit(): void {
  //   this.datosPortfolio.obtenerDatos().subscribe(data=>{
  //   this.educationList=data.education;
  //   });
  // }

  if (this.tokenService.getToken()){
    this.cargarEducacion();
    this.inLogged=true;
  }else{
    this.inLogged=false;
  }
}

cargarEducacion():void{
  this.educacionService.listaEducacion().subscribe(
    data =>{this.edu = data})
}
}