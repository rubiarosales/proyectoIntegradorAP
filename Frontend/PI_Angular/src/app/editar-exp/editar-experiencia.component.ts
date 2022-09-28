import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from '../model/experiencia';
import { ExperienciaService } from '../servicios/experiencia.service';

@Component({
  selector: 'app-editar-edu',
  templateUrl: './editar-exp.component.html',
  styleUrls: ['./editar-exp.component.css']
})
export class EditarExpComponent implements OnInit {
    editExp: Experiencia=null;
    // cargo: string="";
    // empresa: string="";
    // fecha: string="";
    // descripcion_cargo: string="";
    // url_logo: string="";

  constructor(private router: Router, private experienciaService: ExperienciaService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id= this.activatedRoute.snapshot.params['id'];
    this.experienciaService.detail(id).subscribe(
        { next: data =>{
           this.editExp=data;
         },
         error: err =>{
           alert("No se pudo modificar la experiencia");
           this.router.navigate(['']);
         }
       })
}

onEdit(): void{
    const id= this.activatedRoute.snapshot.params['id'];
  
  this.experienciaService.update(id,this.editExp).subscribe(
   { next: data =>{
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
