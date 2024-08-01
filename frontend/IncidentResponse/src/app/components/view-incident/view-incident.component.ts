import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { IncidentService } from '../../services/incidentService/incident.service';
import { UserService } from '../../services/userService/user.service';
import { Incident } from '../../models/Incident';
import { PriorityInfoComponent } from "../priority-info/priority-info.component";
import { MatCardModule} from '@angular/material/card';
import { StatusIncidentInfoComponent } from "../status-incident-info/status-incident-info.component";
import { MatIconModule } from '@angular/material/icon';
import { CommonModule, DatePipe, Location } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { ManageCommentariesComponent } from '../manage-commentaries/manage-commentaries.component';
import { CommentaryComponent } from "../commentary/commentary.component";
@Component({
  selector: 'app-view-incident',
  standalone: true,
  providers:[DatePipe],
  imports: [CommonModule, RouterModule, MatCardModule, MatButtonModule, MatIconModule, PriorityInfoComponent, StatusIncidentInfoComponent, ManageCommentariesComponent, CommentaryComponent],
  templateUrl: './view-incident.component.html',
  styleUrl: './view-incident.component.scss'
})
export class ViewIncidentComponent implements OnInit {

  
  public idIncident:number;

  public incident: Incident | null = null;

  constructor(
              private router: ActivatedRoute,
              private location: Location,
              private incidentService: IncidentService,
              private userService: UserService
  ) {
    const routeParams = this.router.snapshot.params;
    this.idIncident= Number(routeParams['id']);
    
  }
  ngOnInit(): void {
   
    this.incidentService.incidents$.subscribe(() =>{
      const incident = this.incidentService.getIncidentById(this.idIncident)
      if (incident != undefined){
        this.incident = incident
      }
      else{
        // Rediriger vers 404 
      }
    
    })
  }
  
  public getUserNameById(idUser: number| undefined){
    const undefined_return =  'Not specified' 
    if (idUser !=undefined){
      const user = this.userService.getUserById(idUser);
      return  user === undefined ? undefined_return : user.lastname.toUpperCase() + ' '+ user.name;

    }
    return undefined_return;
  }


  
  back() {
    this.location.back()
  }
}
