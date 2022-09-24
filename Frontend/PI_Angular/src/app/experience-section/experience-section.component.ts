import { Component, OnInit } from '@angular/core';
import { Experiencia } from '../model/experiencia';
import { ExperienciaService } from '../servicios/experiencia.service';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';
import { TokenService } from '../servicios/token.service';

@Component({
  selector: 'experience-section',
  templateUrl: './experience-section.component.html',
  styleUrls: ['./experience-section.component.css']
})
export class ExperienceSectionComponent implements OnInit {

  exp:Experiencia[]=[];

  experienceList:any;

  constructor(private datosPortfolio:PortfolioServiceService,private tokenService:TokenService, private experienciaService:ExperienciaService) { }
inLogged=false;
  ngOnInit(): void {
    
    // this.datosPortfolio.obtenerDatos().subscribe(data=>{
    // this.experienceList=data.experience;
    // });

    if (this.tokenService.getToken()){
      this.cargarExperiencia();
      this.inLogged=true;
    }else{
      this.inLogged=false;
    }
  }

  cargarExperiencia():void{
    this.experienciaService.listaExperiencia().subscribe(
      data =>{this.exp = data})
  }
}
