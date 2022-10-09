import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from '../../model/educacion';
import { EducacionService } from '../../servicios/educacion.service';

@Component({
  selector: 'app-nueva-edu',
  templateUrl: './nueva-edu.component.html',
  styleUrls: ['./nueva-edu.component.css']
})
export class NuevaEduComponent implements OnInit {
  institucion: string="";
  titulo: string="";
  fecha: string="";
  url_logo: string="";

  constructor(private educacionService:EducacionService, private router:Router) { }

  ngOnInit(): void {
  }

  onAdd(): void{
    const nuevaEdu = new Educacion (this.institucion,this.titulo, this.fecha,this.url_logo);
    this.educacionService.save(nuevaEdu).subscribe(
     { next: data =>{
        alert("Educacion añadida");
        this.router.navigate(['']);
      },
      error: err =>{
        alert("No se pudo añadir la educacion");
        this.router.navigate(['']);
      }
    }
    )
  }
}
