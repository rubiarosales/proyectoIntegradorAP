import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Habilidades } from 'src/app/model/habilidades';
import { HabilidadesService } from 'src/app/servicios/habilidades.service';

@Component({
  selector: 'app-nueva-skill',
  templateUrl: './nueva-skill.component.html',
  styleUrls: ['./nueva-skill.component.css']
})
export class NuevaSkillComponent implements OnInit {
  habilidad: string="";
  nivel: number;

  constructor(private router:Router, private habilidadesService:HabilidadesService) { }

  ngOnInit(): void {
  }

  onAdd(){
    const nuevaSkill = new Habilidades (this.habilidad,this.nivel);
    this.habilidadesService.save(nuevaSkill).subscribe(
     { next: data =>{
        alert("Habilidad añadida");
        this.router.navigate(['']);
      },
      error: err =>{
        alert("No se pudo añadir la habilidad");
        this.router.navigate(['']);
      }
    }
    )
  }
}
