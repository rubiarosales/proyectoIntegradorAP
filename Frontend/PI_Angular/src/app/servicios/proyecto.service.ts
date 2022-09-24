import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyecto } from '../model/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {
  proyURL = 'http://localhost:8080/proyectos/';

  constructor(private http:HttpClient) {}
  
  public listaProyecto(): Observable<Proyecto[]> {
    return this.http.get<Proyecto[]>(this.proyURL+'traer/');
  }
  
  public detail (id:number): Observable<Proyecto>{
    return this.http.get<Proyecto>(this.proyURL+`detail/${id}`);
  }
  
  public save (proyecto:Proyecto): Observable<any>{
    return this.http.post<any>(this.proyURL+'crear',proyecto);
  }
  
  public update (id:number,proyecto:Proyecto): Observable<any>{
    return this.http.put<any>(this.proyURL+`actualizar/${id}`,proyecto);
  }
  
  public delete (id:number): Observable<any>{
    return this.http.delete<any>(this.proyURL+`borrar/${id}`);
  }
  
  }