import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Injectable, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { UserService } from '../../services/userService/user.service';
import { User } from '../../models/User';
import { MatInputModule } from '@angular/material/input';
import { Commentary } from '../../models/Commentary';
import { MatButtonModule } from '@angular/material/button';
import { MatCard, MatCardModule } from '@angular/material/card';
import { CommentaryService } from '../../services/CommentaryService/commentary.service';
      

    
@Component({
  selector: 'app-manage-commentaries',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule, 
    ReactiveFormsModule,
    MatFormFieldModule

  ],
  templateUrl: './manage-commentaries.component.html',
  styleUrl: './manage-commentaries.component.scss'
})
export class ManageCommentariesComponent implements OnInit{

  @Input() edit = false;
  @Input() idEdit =-1
  @Input() idIncident = -1 
 
  commentaryForm: FormGroup =  new FormGroup({
    description: new FormControl<string>('', Validators.required),
    user : new FormControl<number>(-1,Validators.min(0))
  });
closeDialog: any;

  constructor(private userService: UserService,
              private commentaryService:CommentaryService
  ){

  }
  ngOnInit(): void {
    const currentUser:User = this.userService.getCurrentUser()
    this.commentaryForm.controls['user'].setValue(currentUser.id)
  }

  
  submitCreation() {
    if (this.commentaryForm.valid){
      const commentary = this.commentaryForm.value as Commentary
      this.commentaryService.addCommentary(this.idIncident,commentary)
  
    }
  }
  submitUpdate() {
    throw new Error('Method not implemented.');
  }

}
