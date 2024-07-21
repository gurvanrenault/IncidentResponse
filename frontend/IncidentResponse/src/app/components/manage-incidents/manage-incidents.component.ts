import { Component, Inject, OnInit } from '@angular/core';
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

  constructor(private incidentService:IncidentService,
              private utilisateurService:UtilisateurService,
              public dialogRef: MatDialogRef<ManageIncidentsComponent>
  ){
    this.utilisateurs = this.utilisateurService.getUtilisateurs();
  }
  
  ngOnInit(){
  
  }
  
  public soumettreCreation():void {
    if (this.incidentForm.valid ){
      const incident = this.incidentForm.value as Incident
      this.incidentService.addIncident(incident)
      this.closeDialog()
    }
    
  }
  public closeDialog(){
    this.dialogRef.close()
  }
}


