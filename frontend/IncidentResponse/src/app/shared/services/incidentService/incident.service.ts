import { Injectable } from '@angular/core';
import { Incident } from '../../models/Incident';
import { BehaviorSubject, Observable } from 'rxjs';
import { StatusIncidentEnum } from '../../../enums/StatutsIncidentEnum';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { nextTick } from 'node:process';
import { error } from 'node:console';

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
    incident.status = StatusIncidentEnum.TO_DO;
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
    const idIncident = incident.id;
    let incidents = this._incidentsSubject.value;
    var elementPos = incidents.map(function(x) {return x.id; }).indexOf(idIncident);
    incidents[elementPos] = incident;
    this._incidentsSubject.next(incidents);

  }
  public getIncidentById(idEdit: number) {
    return this._incidentsSubject.value.find((element) => element.id == idEdit )
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
