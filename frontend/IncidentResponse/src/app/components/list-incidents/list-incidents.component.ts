import { Component } from '@angular/core';
import { ManageIncidentsComponent } from '../manage-incidents/manage-incidents.component';
import {
  MatDialog,
  MAT_DIALOG_DATA,
  MatDialogTitle,
  MatDialogContent,
  MatDialogRef,
} from '@angular/material/dialog'
@Component({
  selector: 'app-list-incidents',
  standalone: true,
  imports: [],
  templateUrl: './list-incidents.component.html',
  styleUrl: './list-incidents.component.scss'
})
export class ListIncidentsComponent  {

  dialogCreationIncident: MatDialogRef<ManageIncidentsComponent> | undefined 
  constructor(public dialog: MatDialog) {
    this.openDialog()

  }

  public openDialog(){
      this.dialogCreationIncident = this.dialog.open(ManageIncidentsComponent,{
        height: '500px',
        width: '1000px',
    })
  }
}
