import { Injectable } from '@angular/core';
import { Incident } from '../../models/Incident';
import { BehaviorSubject, Observable } from 'rxjs';
import { StatusIncidentEnum } from '../../../enums/StatutsIncidentEnum';
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
    incident.status = StatusIncidentEnum.TODO;
    const httpOptions = {
      headers: new HttpHeaders({ 
        'access-control-allow-origin':'*'
      })
    };
    return this.http.post<Incident>(this.urlIncident,incident,httpOptions)
  }

  public deleteIncident(idIncident:number){
    let incidents = this._incidentsSubject.value;
    var elementPos = incidents.map(function(x) {return x.id; }).indexOf(idIncident);;
    incidents.splice(elementPos,1);
    this._incidentsSubject.next(incidents);
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


  /*
  public getAllIncidents():Observable<Object>{
    const httpOptions = {
      headers: new HttpHeaders({ 
        'access-control-allow-origin':'*'
      })
    };
    return this.http.get(this.urlIncident,httpOptions); 
  }
    */
}
