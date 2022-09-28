import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private datosPortfolio:PortfolioServiceService,private tokenService:TokenService, private experienciaService:ExperienciaService, private router:Router) { }
isLogged=false;
  ngOnInit(): void {
    
    // this.datosPortfolio.obtenerDatos().subscribe(data=>{
    // this.experienceList=data.experience;
    // });

    if (this.tokenService.getToken()){
      this.cargarExperiencia();
      this.isLogged=true;
    }else{
      this.isLogged=false;
    }
  }

  cargarExperiencia():void{
    this.experienciaService.listaExperiencia().subscribe(
      data =>{this.exp = data})
  }

  deleteExp(id?:number){
    if(id!=undefined){
      this.experienciaService.delete(id).subscribe(
        { next: data =>{
           this.cargarExperiencia();
         },
         error: err =>{
           alert("No se pudo eliminar la experiencia");
           this.router.navigate(['']);
         }
       }
       )
     }
    }

  }


