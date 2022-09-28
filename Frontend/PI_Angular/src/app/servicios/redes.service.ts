import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RedesSociales } from '../model/redes-sociales';

@Injectable({
  providedIn: 'root'
})
export class RedesService {
  redURL = 'http://localhost:8080/redes/';

  constructor(private http:HttpClient) {}
  
  public listaRedes(): Observable<RedesSociales[]> {
    return this.http.get<RedesSociales[]>(this.redURL+'traer/');
  }
  
  public detail (id:number): Observable<RedesSociales>{
    return this.http.get<RedesSociales>(this.redURL+`detail/${id}`);
  }
  
  public save (redes:RedesSociales): Observable<any>{
    return this.http.post<any>(this.redURL+'crear',redes);
  }
  
  public update (id:number,redes:RedesSociales): Observable<any>{
    return this.http.put<any>(this.redURL+`actualizar/${id}`,redes);
  }
  
  public delete (id:number): Observable<any>{
    return this.http.delete<any>(this.redURL+`borrar/${id}`);
  }
  
  }