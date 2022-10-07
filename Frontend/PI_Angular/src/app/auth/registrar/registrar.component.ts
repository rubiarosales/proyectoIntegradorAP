import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NuevoUsuario } from 'src/app/model/nuevo-usuario';
import { AuthServiceService } from 'src/app/servicios/auth-service.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.css']
})
export class RegistrarComponent implements OnInit {
  isRegister=false;
  isRegisterFail=false;
  nuevoUsuario:NuevoUsuario;
  nombre: string;
  nombreUsuario: string;
  email: string;
  password:string;
  errMsj!:string;


  constructor(private router: Router, private authService: AuthServiceService, private tokenService: TokenService) { }

  ngOnInit() {

  }

  onRegister(): void {
    this.nuevoUsuario = new NuevoUsuario(this.nombre,this.nombreUsuario,this.email, this.password);
    this.authService.nuevo(this.nuevoUsuario).subscribe({
      next: (data) => {
      this.isRegister=true;
      this.isRegisterFail=false;
      this.router.navigate(['/login']);
    },
    
    error: (err) => {
    this.isRegister=false;
    this.isRegisterFail= true;
    this.errMsj=err.error.mensaje;
    console.log(this.errMsj);
  }
});
  }
}
