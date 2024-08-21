import { Injectable } from '@angular/core';
import { Incident } from '../../models/Incident';
import { IncidentService } from '../incidentService/incident.service';
import { Commentary } from '../../models/Commentary';

@Injectable({
  providedIn: 'root'
})
export class CommentaryService {

  constructor(private incidentService:IncidentService) {
   }

   public addCommentary(incidentId:number, commentary:Commentary){
    let incident = this.incidentService.getIncidentById(incidentId);
    if (incident != undefined){
      
      commentary.date = new Date()
      incident.commentaries === undefined ? incident.commentaries=[commentary] : incident.commentaries.push(commentary);
      this.incidentService.updateIncident(incident);
    }

   
    }
}
