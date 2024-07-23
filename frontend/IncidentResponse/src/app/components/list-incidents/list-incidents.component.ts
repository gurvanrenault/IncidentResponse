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
import { User } from '../../models/User';
import { UserService } from '../../services/userService/user.service';
import { StatusIncidentInfoComponent } from "../status-incident-info/status-incident-info.component";

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
              private userService:UserService
  ) { 
     this.incidents$ = this.incidentService.incidents$ 
  }
  
  ngOnInit(): void {}

  public ouvrirPopUpCreationIncident(){
      this.dialogCreationIncident = this.dialog.open(ManageIncidentsComponent,{
        height: '500px',
        width: '1000px',
    })
    this.dialogCreationIncident.componentInstance.edit = false;
  }

  public recupererUtilisateurNomById(idUtil: number){
    const user = this.userService.getUtilisateurById(idUtil);
    return  user === undefined ? 'Non Spécifié' : user.lastname.toUpperCase() + ' '+ user.name;
  }
  public supprimerIncident(id:number) {
    this.incidentService.deleteIncident(id);
  }

  public viewIncident(arg0: any) {
    throw new Error('Method not implemented.');
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
