import { Component, OnInit } from '@angular/core';
import { Habilidades } from '../model/habilidades';
import { HabilidadesService } from '../servicios/habilidades.service';
import { PortfolioServiceService } from '../servicios/portfolio-service.service';
import { TokenService } from '../servicios/token.service';


@Component({
  selector: 'skills-section',
  templateUrl: './skills-section.component.html',
  styleUrls: ['./skills-section.component.css']
})
export class SkillsSectionComponent implements OnInit {

  hab:Habilidades[]=[];
  skillList:any;

  constructor(private datosPortfolio:PortfolioServiceService,private tokenService:TokenService, private habilidadesService:HabilidadesService) { }
  inLogged=false;
  ngOnInit(): void {
//     this.datosPortfolio.obtenerDatos().subscribe(data=>{
//     this.skillList=data.skills;
//     });
//   }
// }

if (this.tokenService.getToken()){
  this.cargarHabilidad();
  this.inLogged=true;
}else{
  this.inLogged=false;
}
}

cargarHabilidad():void{
this.habilidadesService.listaHabilidades().subscribe(
  data =>{this.hab = data})
}
}