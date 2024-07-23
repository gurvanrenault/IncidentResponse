import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import { Incident } from '../../models/Incident';
import { PrioriteEnum } from '../../enums/PrioriteEnum';
import { CommonModule } from '@angular/common';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import { Utilisateur } from '../../models/Utilisateur';
import { IncidentService } from '../../services/incidentService/incident.service';
import { UtilisateurService } from '../../services/utilisateurService/utilisateur.service';
import { MAT_DIALOG_DATA, MatDialogModule,MatDialogRef} from '@angular/material/dialog';
import { BrowserAnimationsModule, provideAnimations } from '@angular/platform-browser/animations';
import { StatutIncidentEnum } from '../../enums/StatutIncidentEnum';

@Component({
  selector: 'app-manage-incidents',
  standalone: true,
  animations:[],
  providers: [provideAnimations()],
  imports: [CommonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule, 
    ReactiveFormsModule,
    FormsModule,
    MatSelectModule,
    MatButtonModule, 
    MatDividerModule, 
    MatIconModule,
    MatFormFieldModule],
  templateUrl: './manage-incidents.component.html',
  styleUrl: './manage-incidents.component.scss'
})

export class ManageIncidentsComponent implements OnInit {

  @Input() edit: boolean = false;
  @Input() idEdit: number = -1;


  incidentForm:FormGroup  = new FormGroup(
    {
      titre : new FormControl<string>('', Validators.required),
      description: new FormControl<string>('', Validators.required),
      priorite : new FormControl<PrioriteEnum>(1,Validators.required),
      utilisateur : new FormControl<number>(-1)
    }
  );
  
  utilisateurs :Array<Utilisateur> ;
  prioriteKeys = Object.entries(PrioriteEnum).slice(Object.entries(PrioriteEnum).length/2,Object.entries(PrioriteEnum).length);
  statutKeys = Object.entries(StatutIncidentEnum).slice(Object.entries(StatutIncidentEnum).length/2 -1,Object.entries(StatutIncidentEnum).length);
  

  constructor(private incidentService:IncidentService,
              private utilisateurService:UtilisateurService,
              public dialogRef: MatDialogRef<ManageIncidentsComponent>
  ){
    this.utilisateurs = this.utilisateurService.getUtilisateurs();
  }
  
  ngOnInit(){
    if (this.edit && this.idEdit != -1){
      const incident = this.incidentService.getIncidentById(this.idEdit)
      if (incident != undefined){
        this.incidentForm = new FormGroup(
          {
            titre : new FormControl<string>(incident.titre, Validators.required),
            description: new FormControl<string>(incident.description, Validators.required),
            priorite : new FormControl<PrioriteEnum>(incident.priorite,Validators.required),
            statut: new FormControl<StatutIncidentEnum> (incident.statut,Validators.required),
            date: new FormControl<Date>(incident.date,Validators.required),
            utilisateur : new FormControl<number>(incident.utilisateur != undefined ? incident.utilisateur : -1)
            
          }
        );
        }
    }  
  }
  
  public soumettreCreation():void {
    if (this.incidentForm.valid ){
      const incident = this.incidentForm.value as Incident
      this.incidentService.addIncident(incident)
      this.closeDialog()
    }
    
  }
  public soumettreModification():void {
    if (this.incidentForm.valid ){
      const incident = this.incidentForm.value as Incident
      incident.id = this.idEdit;
      this.incidentService.modifierIncident(incident)
      this.closeDialog()
    }
    
  }
  public closeDialog(){
    this.dialogRef.close()
  }
}


