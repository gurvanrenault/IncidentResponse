import { Component, Inject, Input } from '@angular/core';
import { MessageStatusTypeEnum } from '../../../enums/MessageStatusTypeEnum';
import { CommonModule } from '@angular/common';
import { MAT_SNACK_BAR_DATA } from '@angular/material/snack-bar';
import { MatIconModule } from '@angular/material/icon';
import { SnackbarStatusData } from '../../models/SnackbarStatusData';
@Component({
  selector: 'app-status-snackbar',
  standalone: true,
  imports: [CommonModule,MatIconModule],
  templateUrl: './status-snackbar.component.html',
  styleUrl: './status-snackbar.component.scss'
})
export class StatusSnackbarComponent {
  
   public messageStatusEnum = MessageStatusTypeEnum;

    public constructor(@Inject(MAT_SNACK_BAR_DATA) public data: SnackbarStatusData){}
   
  
  }