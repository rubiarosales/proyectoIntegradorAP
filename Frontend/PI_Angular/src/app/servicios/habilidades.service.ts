import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Habilidades } from '../model/habilidades';

@Injectable({
  providedIn: 'root'
})
export class HabilidadesService {
  habURL = 'http://localhost:8080/habilidades/';

  constructor(private http:HttpClient) {}
  
  public listaHabilidades(): Observable<Habilidades[]> {
    return this.http.get<Habilidades[]>(this.habURL+'traer/');
  }
  
  public detail (id:number): Observable<Habilidades>{
    return this.http.get<Habilidades>(this.habURL+`detail/${id}`);
  }
  
  public save (habilidad:Habilidades): Observable<any>{
    return this.http.post<any>(this.habURL+'crear',habilidad);
  }
  
  public update (id:number,habilidad:Habilidades): Observable<any>{
    return this.http.put<any>(this.habURL+`actualizar/${id}`,habilidad);
  }
  
  public delete (id:number): Observable<any>{
    return this.http.delete<any>(this.habURL+`borrar/${id}`);
  }
  
  }