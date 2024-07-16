import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import { Incident } from '../../models/Incident';
import { PrioriteEnum } from '../../enums/PrioriteEnum';
import { CommonModule } from '@angular/common';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { Utilisateur } from '../../models/Utilisateur';
@Component({
  selector: 'app-manage-incidents',
  standalone: true,
  imports: [CommonModule,
    MatFormFieldModule, 
    MatInputModule, 
    ReactiveFormsModule,
    FormsModule,
    MatSelectModule,
    
    MatFormFieldModule ],
  templateUrl: './manage-incidents.component.html',
  styleUrl: './manage-incidents.component.scss'
})

export class ManageIncidentsComponent implements OnInit {



  utilisateurs : Array<Utilisateur>= [
    {id:0,mail: "test@gmail;com", nom: "Telsa",prenom: "Nicolas",entreprise:"Tesla"},
    {id:1,mail: "test@gmail;com", nom: "Edison",prenom: "Mark",entreprise:"Tesla"}
  ];

  incidentForm:FormGroup  = new FormGroup(
    {
      description: new FormControl<string>('', Validators.required),
      priorite : new FormControl<PrioriteEnum>(0,Validators.required),
      utilisateur : new FormControl<PrioriteEnum>(0)
    }
  )

  prioriteKeys = Object.entries(PrioriteEnum).slice(Object.entries(PrioriteEnum).length/2,Object.entries(PrioriteEnum).length)

  ngOnInit(){
   console.log(this.prioriteKeys)
   this.incidentForm.controls["priorite"].valueChanges.subscribe(value => {
    console.log(value);
   })
  }
}


