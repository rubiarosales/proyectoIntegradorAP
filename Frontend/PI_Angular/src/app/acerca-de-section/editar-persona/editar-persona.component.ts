import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/persona';
import { PersonaService } from 'src/app/servicios/persona.service';

@Component({
  selector: 'app-editar-persona',
  templateUrl: './editar-persona.component.html',
  styleUrls: ['./editar-persona.component.css']
})
export class EditarPersonaComponent implements OnInit {
  editPersona: Persona=null;
  
  constructor(private router: Router,private personaService: PersonaService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'] ;
    this.personaService.detail(id).subscribe(
      { next: data =>{
        this.editPersona=data;
      },
    error: err =>{
      alert("No se pudo modificar a la persona");
      this.router.navigate(['']);
    }}
    )
  }

  onEdit(){
    const id = this.activatedRoute.snapshot.params['id'] ;
    this.personaService.update(id,this.editPersona).subscribe(
      { next: data =>{
        alert("Persona modificada correctamente");
        this.router.navigate(['']);
      },
      error: err =>{
        alert("No se pudo modificar a la persona");
        this.router.navigate(['']);
      }
      }
    )
  }
}
