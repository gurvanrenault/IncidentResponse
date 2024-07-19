import { Injectable } from '@angular/core';
import { Incident } from '../../models/Incident';

@Injectable({
  providedIn: 'root'
})
export class IncidentService {

  private incidents:Array<Incident> = [];

  constructor() {}

  public getIncidents():Array<Incident>{
    return this.incidents;
  }

  public addIncident(incident:Incident){
    this.incidents.push(incident);
  }


}
