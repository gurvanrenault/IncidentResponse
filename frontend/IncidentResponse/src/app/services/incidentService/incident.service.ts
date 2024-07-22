import { Injectable } from '@angular/core';
import { Incident } from '../../models/Incident';
import { BehaviorSubject } from 'rxjs';
import { PrioriteEnum } from '../../enums/PrioriteEnum';
import { StatutIncidentEnum } from '../../enums/StatutIncidentEnum';

@Injectable({
  providedIn: 'root',
})
export class IncidentService {

  private _incidentsSubject= new BehaviorSubject<Incident[]>([]);
  public  incidents$ = this._incidentsSubject.asObservable() 
  private _currentid = 0;

  constructor() {}

  public addIncident(incident:Incident){
    incident.id = this._currentid
    this._currentid=this._currentid+1
    incident.date = new Date()
    incident.id= this._currentid
    incident.statut = StatutIncidentEnum.TODO
  }

  public supprimerIncident(idIncident:number){
    let incidents = this._incidentsSubject.value
    var elementPos = incidents.map(function(x) {return x.id; }).indexOf(idIncident);
    incidents.splice(elementPos,1)
    this._incidentsSubject.next(incidents)
  }


}
