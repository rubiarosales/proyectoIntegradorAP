import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from '../model/educacion';
import { EducacionService } from '../servicios/educacion.service';
import { PortfolioServiceService } from '../servicios/portfolio.service';
import { TokenService } from '../servicios/token.service';

@Component({
  selector: 'education-section',
  templateUrl: './education-section.component.html',
  styleUrls: ['./education-section.component.css']
})
export class EducationSectionComponent implements OnInit {

  edu:Educacion[]=[];

  educationList:any;

  constructor(private datosPortfolio:PortfolioServiceService,private tokenService:TokenService, private educacionService:EducacionService,
    private router:Router) { }
  isLogged=false;

  ngOnInit(): void {
  //   this.datosPortfolio.obtenerDatos().subscribe(data=>{
  //   this.educationList=data.education;
  //   });
  // }
  this.cargarEducacion();
  if (this.tokenService.getToken()){
    // this.cargarEducacion();
    this.isLogged=true;
  }else{
    this.isLogged=false;
  }
}

cargarEducacion():void{
  this.educacionService.listaEducacion().subscribe(
    data =>{this.edu = data})
}
deleteEdu(id?:number){
  if(id!=undefined){
    this.educacionService.delete(id).subscribe(
      { next: data =>{
         this.cargarEducacion();
       },
       error: err =>{
         alert("No se pudo eliminar la eduacion");
         this.router.navigate(['']);
       }
     }
     )
   }
  }

}