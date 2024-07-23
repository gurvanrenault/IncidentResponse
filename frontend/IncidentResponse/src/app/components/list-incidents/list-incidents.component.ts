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
import { PrioriteInfoComponent } from "../priorite-info/priorite-info.component";
import { Utilisateur } from '../../models/Utilisateur';
import { UtilisateurService } from '../../services/utilisateurService/utilisateur.service';
import { StatutIncidentInfoComponent } from "../statut-incident-info/statut-incident-info.component";

@Component({
  selector: 'app-list-incidents',
  standalone: true,
  providers: [DatePipe],
  imports: [CommonModule, MatIconModule, MatButtonModule, MatTableModule, PrioriteInfoComponent, StatutIncidentInfoComponent],
  templateUrl: './list-incidents.component.html',
  styleUrl: './list-incidents.component.scss'
})
export class ListIncidentsComponent implements OnInit {



  dialogCreationIncident: MatDialogRef<ManageIncidentsComponent> | undefined 
  incidents$: Observable<Incident[]>;
  colonnesAffiches = ['id','titre','utilisateur','priorite','statut','actions']
  constructor(public dialog: MatDialog,
              private incidentService:IncidentService,
              private utilisateurService:UtilisateurService
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
    const util = this.utilisateurService.getUtilisateurById(idUtil);
    return  util === undefined ? 'Non Spécifié' : util.nom.toUpperCase() + ' '+ util.prenom;
  }
  public supprimerIncident(id:number) {
    this.incidentService.supprimerIncident(id);
  }

  public afficherIncident(arg0: any) {
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
