import { Injectable } from '@angular/core';
import { Incident } from '../../models/Incident';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root',
})
export class IncidentService {
  

  private _incidentsSubject= new BehaviorSubject<Incident[]>([]);
  public  incidents$ = this._incidentsSubject.asObservable() 
  private _currentid = 0;

  private urlIncident = "/api/incidents"
  constructor(private http : HttpClient) {}

  public addIncident(incident:Incident):Observable<Incident>{
    incident.id = this._currentid;
    const httpOptions = {
      headers: new HttpHeaders({ 
        'access-control-allow-origin':'*'
      })
    };
    return this.http.post<Incident>(this.urlIncident,incident,httpOptions)
  }

  public deleteIncident(idIncident:number){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'access-control-allow-origin':'*'
      })
    };
    const path_id = "/"+idIncident;
    return this.http.delete(this.urlIncident+path_id,)
  }

  public updateIncident(incident:Incident){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'access-control-allow-origin':'*'
      })
    };
    return this.http.put(this.urlIncident, incident, httpOptions)
  }
  public getIncidentById(idIncident: number) {
    const httpOptions = {
      headers: new HttpHeaders({ 
        'access-control-allow-origin':'*'
      })
    };
    return this.http.get<Incident>(this.urlIncident+"/"+idIncident)
  }



  public getAllIncidents(page:number){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'access-control-allow-origin':'*'
      })
    };
    return this.http.get<any>(this.urlIncident+"?page="+page,httpOptions); 
  }

}
