import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Habilidades } from 'src/app/model/habilidades';
import { HabilidadesService } from 'src/app/servicios/habilidades.service';

@Component({
  selector: 'app-editar-skill',
  templateUrl: './editar-skill.component.html',
  styleUrls: ['./editar-skill.component.css']
})
export class EditarSkillComponent implements OnInit {
  editSkill: Habilidades=null;

  constructor(private router:Router, private habilidadesService:HabilidadesService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id=this.activatedRoute.snapshot.params['id'];
    this.habilidadesService.detail(id).subscribe(
      { next: data =>{
         this.editSkill=data;
       },
       error: err =>{
         alert("No se pudo modificar la habilidad");
         this.router.navigate(['']);
       }
     })
}
onEdit(){
  const id=this.activatedRoute.snapshot.params['id'];
    this.habilidadesService.update(id,this.editSkill).subscribe(
      {next: data =>{
        alert("Experiencia modificada correctamente");
        this.router.navigate(['']);
      },
      error: err =>{
        alert("No se pudo modificar la experiencia");
        this.router.navigate(['']);
      }
    }
    )
  }
  }
  