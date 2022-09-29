import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/servicios/proyecto.service';

@Component({
  selector: 'app-nuevo-proyecto',
  templateUrl: './nuevo-proyecto.component.html',
  styleUrls: ['./nuevo-proyecto.component.css']
})
export class NuevoProyectoComponent implements OnInit {
  titulo!: string;
  fecha!: string;
  url_img!: string;
  url_proyecto!: string;

  constructor(private router:Router, private proyectoService: ProyectoService) { }

  ngOnInit(): void {
  }

  onAdd():void{
    const nuevoProyecto = new Proyecto (this.titulo,this.fecha,this.url_img,this.url_proyecto);
    this.proyectoService.save(nuevoProyecto).subscribe(
      { next: data =>{
        alert("Proyecto agregado correctamente");
        this.router.navigate(['']);
      },
    error: err =>{
      alert("No se pudo añadir el proyecto");
      this.router.navigate(['']);
    }}
    )
  }
}
