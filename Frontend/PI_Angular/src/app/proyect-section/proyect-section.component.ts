import { Component, OnInit } from '@angular/core';
import { Proyecto } from '../model/proyecto';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';
import { ProyectoService } from '../servicios/proyecto.service';
import { TokenService } from '../servicios/token.service';

@Component({
  selector: 'proyect-section',
  templateUrl: './proyect-section.component.html',
  styleUrls: ['./proyect-section.component.css']
})
export class ProyectSectionComponent implements OnInit {
  proy:Proyecto[]=[];

  proyectList:any;

  constructor(private datosPortfolio:PortfolioServiceService,private tokenService:TokenService, private proyectoService:ProyectoService) { }
  isLogged=false;
    ngOnInit(): void {
//     this.datosPortfolio.obtenerDatos().subscribe(data=>{
//     this.proyectList=data.proyects;
//     });
//   }
// }
if (this.tokenService.getToken()){
  this.cargarProyecto();
  this.isLogged=true;
}else{
  this.isLogged=false;
}
}

cargarProyecto():void{
this.proyectoService.listaProyecto().subscribe(
  data =>{this.proy = data})
}
}