import { Component, inject, OnInit, ViewChild } from '@angular/core';
import { ManageIncidentsComponent } from '../manage-incidents/manage-incidents.component';
import {
  MatDialog,
  MatDialogRef,
} from '@angular/material/dialog'
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatTableDataSource, MatTableModule} from '@angular/material/table';
import { Incident } from '../../shared/models/Incident';
import { IncidentService } from '../../shared/services/incidentService/incident.service';
import { Observable } from 'rxjs';
import { CommonModule, DatePipe } from '@angular/common';
import { PriorityInfoComponent } from "../../shared/components/priority-info/priority-info.component";
import { UserService } from '../../shared/services/userService/user.service';
import { Router } from '@angular/router';
import { StatusIncidentInfoComponent } from '../../shared/components/status-incident-info/status-incident-info.component';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { PriorityEnum } from '../../enums/PriorityEnum';
import { StatusSnackbarComponent } from '../../shared/components/status-snackbar/status-snackbar.component';
import { MessageStatusTypeEnum } from '../../enums/MessageStatusTypeEnum';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-list-incidents',
  standalone: true,
  providers: [DatePipe],
  imports: [CommonModule, MatIconModule, MatButtonModule, MatTableModule, PriorityInfoComponent, StatusIncidentInfoComponent,MatPaginator],
  templateUrl: './list-incidents.component.html',
  styleUrl: './list-incidents.component.scss'
})
export class ListIncidentsComponent implements OnInit {

  
  @ViewChild('paginator') paginator: MatPaginator | null = null ;
  private _snackBar = inject(MatSnackBar);
  
  currentPageNo = 0
  pageSize = 0;
  numberElements = 0;
  dialogCreationIncident: MatDialogRef<ManageIncidentsComponent> | undefined 
  
  datasource = new MatTableDataSource();
  displayColumns = ['id','title','user','priority','status','actions']
  priorityEnum =  PriorityEnum;
  constructor(public dialog: MatDialog,
              private incidentService:IncidentService,
              private userService:UserService,
              private router:Router
  ) { 
    
  }
  
  ngOnInit(): void {
    this.incidentService.getAllIncidents(this.currentPageNo).subscribe((resp) =>
      {

        this.datasource.data =  resp.content;
        this.pageSize = resp.page.size;
        this.numberElements = resp.page.totalElements
        this.datasource.paginator = this.paginator
      });
  }

  public openPopUpCreationIncident(){
      this.dialogCreationIncident = this.dialog.open(ManageIncidentsComponent,{
        height: '500px',
        width: '1000px',
    })

    this.dialogCreationIncident.componentInstance.edit = false;
    this.dialogCreationIncident.afterClosed().subscribe(()=>{
      this.incidentService.getAllIncidents(this.currentPageNo).subscribe((resp) =>
        {
            this.datasource.data =  resp.content;
            this.numberElements = resp.page.totalElements
        });
    });
  }

  public getUserNameById(idUtil: number){
    const user = this.userService.getUserById(idUtil);
    return  user === undefined ? 'Non Spécifié' : user.lastname.toUpperCase() + ' '+ user.name;
  }
  public deleteIncident(id:number) {
    this.incidentService.deleteIncident(id).subscribe({
      next:(data)=> {
        this._snackBar.openFromComponent(StatusSnackbarComponent, {
            data : { message : "The incident is deleted sucessfully",
                type: MessageStatusTypeEnum.VALIDATION
                },
            duration : 1000,
            panelClass:  ['success']
        });
        this.incidentService.getAllIncidents(this.currentPageNo).subscribe((resp) =>
        {
            this.datasource.data =  resp.content;
            this.numberElements = resp.page.totalElements
        });
      },
      error: (error) => {
        this._snackBar.openFromComponent(StatusSnackbarComponent, {
          data : { message : "Impossible to delete this incident",
              type: MessageStatusTypeEnum.FAILURE
              },
          duration : 1000,
          panelClass:  ['failure']
      });
      }
    });
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
    this.dialogCreationIncident.afterClosed().subscribe(()=>{
      this.incidentService.getAllIncidents(this.currentPageNo).subscribe((resp) =>
        {
            this.datasource.data =  resp.content;
            this.numberElements = resp.page.totalElements
        });
    });
    }
    
    
    public pageEvents($event: PageEvent) {
      this.currentPageNo =$event.pageIndex;

      this.incidentService.getAllIncidents(this.currentPageNo).subscribe((resp) =>
        {
          this.datasource.data =  resp.content;
        });
      }
  




}
