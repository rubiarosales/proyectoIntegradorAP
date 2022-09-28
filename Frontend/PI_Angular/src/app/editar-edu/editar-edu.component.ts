import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from '../model/educacion';
import { EducacionService } from '../servicios/educacion.service';

@Component({
  selector: 'app-editar-edu',
  templateUrl: './editar-edu.component.html',
  styleUrls: ['./editar-edu.component.css']
})

export class EditarEduComponent implements OnInit {
  editEdu: Educacion=null;


constructor(private router: Router, private educacionService: EducacionService, private activatedRoute: ActivatedRoute) { }

ngOnInit(): void {
  const id= this.activatedRoute.snapshot.params['id'];
  this.educacionService.detail(id).subscribe(
      { next: data =>{
         this.editEdu=data;
       },
       error: err =>{
         alert("No se pudo modificar la educacion");
         this.router.navigate(['']);
       }
     })
}

onEdit(): void{
  const id= this.activatedRoute.snapshot.params['id'];

this.educacionService.update(id,this.editEdu).subscribe(
 { next: data =>{
    alert("Educacion modificada correctamente");
    this.router.navigate(['']);
  },
  error: err =>{
    alert("No se pudo modificar la educacion");
    this.router.navigate(['']);
  }
}
)
}
}
