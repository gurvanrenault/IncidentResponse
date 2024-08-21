import { Component, inject, Inject, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import { Incident } from '../../shared/models/Incident';
import { PriorityEnum } from '../../enums/PriorityEnum';
import { CommonModule } from '@angular/common';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import { User } from '../../shared/models/User';
import { IncidentService } from '../../shared/services/incidentService/incident.service';
import { UserService } from '../../shared/services/userService/user.service';
import { StatusIncidentEnum } from '../../enums/StatutsIncidentEnum';
import { MatDialogModule,MatDialogRef } from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import { StatusSnackbarComponent } from '../../shared/components/status-snackbar/status-snackbar.component';
import { MessageStatusTypeEnum } from '../../enums/MessageStatusTypeEnum';
@Component({
  selector: 'app-manage-incidents',
  standalone: true,
  animations:[],
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
  private _snackBar = inject(MatSnackBar);
 

  incidentForm:FormGroup  = new FormGroup(
    {
      title : new FormControl<string>('', Validators.required),
      description: new FormControl<string>('', Validators.required),
      priority : new FormControl<PriorityEnum>(1,Validators.required),
      user : new FormControl<number>(-1)
    }
  );
  
  users :Array<User> ;
  priorityKeys = Object.entries(PriorityEnum).slice(Object.entries(PriorityEnum).length/2,Object.entries(PriorityEnum).length);
  statusKeys = Object.entries(StatusIncidentEnum).slice(Object.entries(StatusIncidentEnum).length/2 -1,Object.entries(StatusIncidentEnum).length);
  

  constructor(private incidentService:IncidentService,
              private userService:UserService,
              public dialogRef: MatDialogRef<ManageIncidentsComponent>
  ){
    this.users = this.userService.getUsers();
  }
  
  ngOnInit(){
    if (this.edit && this.idEdit != -1){
      const incident = this.incidentService.getIncidentById(this.idEdit)
      if (incident != undefined){
        this.incidentForm = new FormGroup(
          {
            title : new FormControl<string>(incident.title, Validators.required),
            description: new FormControl<string>(incident.description, Validators.required),
            priority : new FormControl<PriorityEnum>(incident.priority,Validators.required),
            status: new FormControl<StatusIncidentEnum> (incident.status,Validators.required),
            date: new FormControl<Date>(incident.date,Validators.required),
            user : new FormControl<number>(incident.user ?? -1)
            
          }
        );

        }
    }  
  }
  
  public submitCreation():void {
    if (this.incidentForm.valid ){
      const incident = this.incidentForm.value as Incident
      this.incidentService.addIncident(incident)
      .subscribe({
        next:(data)=> {
          this._snackBar.openFromComponent(StatusSnackbarComponent, {
              data : { message : "The incident is created sucessfully",
                  type: MessageStatusTypeEnum.VALIDATION
                  },
              duration : 1000,
              panelClass:  ['success']
          });
        },
        error: (error) => {
          this._snackBar.openFromComponent(StatusSnackbarComponent, {
            data : { message : "Impossible to create an incident",
                type: MessageStatusTypeEnum.FAILURE
                },
            duration : 1000,
            panelClass:  ['failure']
        });
        },
        complete: () =>  this.closeDialog()
      }
    )
      
    
    }
    
  }
  public submitUpdate():void {
    if (this.incidentForm.valid ){
      const incident = this.incidentForm.value as Incident
      incident.id = this.idEdit;
      this.incidentService.updateIncident(incident)
      this.closeDialog()
    }
    
  }
  public closeDialog(){
    this.dialogRef.close()
  }
}


