import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from '../../model/experiencia';
import { ExperienciaService } from '../../servicios/experiencia.service';

@Component({
  selector: 'app-nueva-exp',
  templateUrl: './nueva-exp.component.html',
  styleUrls: ['./nueva-exp.component.css']
})
export class NuevaExpComponent implements OnInit {
  cargo: string="";
  empresa: string="";
  fecha: string="";
  descripcion_cargo: string="";
  url_logo: string="";

  constructor(private experienciaService:ExperienciaService, private router:Router) { }

  ngOnInit(): void {
  }

  onAdd(): void{
    const nuevaExp = new Experiencia (this.cargo,this.empresa, this.fecha,this.descripcion_cargo,this.url_logo);
    this.experienciaService.save(nuevaExp).subscribe(
     { next: data =>{
        alert("Experiencia añadida");
        this.router.navigate(['']);
      },
      error: err =>{
        alert("No se pudo añadir la experiencia");
        this.router.navigate(['']);
      }
    }
    )
  }
}
