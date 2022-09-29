import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/servicios/proyecto.service';

@Component({
  selector: 'app-editar-proyecto',
  templateUrl: './editar-proyecto.component.html',
  styleUrls: ['./editar-proyecto.component.css']
})
export class EditarProyectoComponent implements OnInit {
  editProyecto: Proyecto = null;

  constructor(private router: Router, private proyectoService: ProyectoService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.proyectoService.detail(id).subscribe(
      {
        next: data => {
          this.editProyecto = data;
        },
        error: err => {
          alert("No se pudo modificar el proyecto");
          this.router.navigate(['']);
        }
      }
    )

  }

  onEdit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.proyectoService.update(id, this.editProyecto).subscribe(
      {
        next: data => {
          alert("El proyecto se ha modificado correctamente");
          this.router.navigate(['']);
        },
        error: err => {
          alert("No se pudo modificar el proyecto");
          this.router.navigate(['']);
        }
      }
    )
  }
}
