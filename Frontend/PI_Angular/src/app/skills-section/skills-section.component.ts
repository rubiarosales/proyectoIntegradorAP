import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Habilidades } from '../model/habilidades';
import { HabilidadesService } from '../servicios/habilidades.service';
import { PortfolioServiceService } from '../servicios/portfolio.service';
import { TokenService } from '../servicios/token.service';


@Component({
  selector: 'skills-section',
  templateUrl: './skills-section.component.html',
  styleUrls: ['./skills-section.component.css']
})
export class SkillsSectionComponent implements OnInit {

  hab: Habilidades[] = [];
  skillList: any;

  constructor(private datosPortfolio: PortfolioServiceService, private tokenService: TokenService, private habilidadesService: HabilidadesService, private router: Router) { }
  isLogged = false;
  ngOnInit(): void {

    //     this.datosPortfolio.obtenerDatos().subscribe(data=>{
    //     this.skillList=data.skills;
    //     });
    //   }
    // }
    this.cargarHabilidad();
    if (this.tokenService.getToken()) {
      // this.cargarHabilidad();
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarHabilidad(): void {
    this.habilidadesService.listaHabilidades().subscribe(
      data => { this.hab = data })
  }


  deleteSkill(id?:number) {
    if(id!=undefined){
    this.habilidadesService.delete(id).subscribe(
      { next: data =>{
        this.cargarHabilidad();
      },
      error: err=>{
        alert("No se pudo eliminar la habilidad");
        this.router.navigate(['']);
      }}
    )

     } }
}