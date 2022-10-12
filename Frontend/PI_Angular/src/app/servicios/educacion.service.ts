import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Educacion } from '../model/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  eduURL = environment.URL+'educacion/';

  constructor(private http:HttpClient) {}
  
  public listaEducacion(): Observable<Educacion[]> {
    return this.http.get<Educacion[]>(this.eduURL+'traer');
  }
  
  public detail (id:number): Observable<Educacion>{
    return this.http.get<Educacion>(this.eduURL+`detail/${id}`);
  }
  
  public save (educacion:Educacion): Observable<any>{
    return this.http.post<any>(this.eduURL+'crear',educacion);
  }
  
  public update (id:number,educacion:Educacion): Observable<any>{
    return this.http.put<any>(this.eduURL+`actualizar/${id}`,educacion);
  }
  
  public delete (id:number): Observable<any>{
    return this.http.delete<any>(this.eduURL+`borrar/${id}`);
  }
  
  }