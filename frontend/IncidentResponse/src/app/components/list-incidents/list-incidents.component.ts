import { Component, OnInit } from '@angular/core';
import { ManageIncidentsComponent } from '../manage-incidents/manage-incidents.component';
import {
  MatDialog,
  MatDialogRef,
} from '@angular/material/dialog'
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule} from '@angular/material/table';
import { Incident } from '../../models/Incident';
import { IncidentService } from '../../services/incidentService/incident.service';
import { Observable } from 'rxjs';
import { CommonModule, DatePipe } from '@angular/common';
import { PriorityInfoComponent } from "../priority-info/priority-info.component";
import { UserService } from '../../services/userService/user.service';
import { StatusIncidentInfoComponent } from "../status-incident-info/status-incident-info.component";
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-incidents',
  standalone: true,
  providers: [DatePipe],
  imports: [CommonModule, MatIconModule, MatButtonModule, MatTableModule, PriorityInfoComponent, StatusIncidentInfoComponent],
  templateUrl: './list-incidents.component.html',
  styleUrl: './list-incidents.component.scss'
})
export class ListIncidentsComponent implements OnInit {



  dialogCreationIncident: MatDialogRef<ManageIncidentsComponent> | undefined 
  incidents$: Observable<Incident[]>;
  displayColumns = ['id','title','user','priority','status','actions']
  constructor(public dialog: MatDialog,
              private incidentService:IncidentService,
              private userService:UserService,
              private router:Router
  ) { 
     this.incidents$ = this.incidentService.incidents$ 
  }
  
  ngOnInit(): void {}

  public openPopUpCreationIncident(){
      this.dialogCreationIncident = this.dialog.open(ManageIncidentsComponent,{
        height: '500px',
        width: '1000px',
    })
    this.dialogCreationIncident.componentInstance.edit = false;
  }

  public getUserNameById(idUtil: number){
    const user = this.userService.getUserById(idUtil);
    return  user === undefined ? 'Non Spécifié' : user.lastname.toUpperCase() + ' '+ user.name;
  }
  public deleteIncident(id:number) {
    this.incidentService.deleteIncident(id);
  }

  public viewIncident(id: number) {
    this.router.navigate(['/incident', id])
    }
  public editIncident(id: number) {
    this.dialogCreationIncident = this.dialog.open(ManageIncidentsComponent,{
      height: '500px',
      width: '1000px',
    })
    this.dialogCreationIncident.componentInstance.edit = true;
    this.dialogCreationIncident.componentInstance.idEdit = id;
    }
    




}
