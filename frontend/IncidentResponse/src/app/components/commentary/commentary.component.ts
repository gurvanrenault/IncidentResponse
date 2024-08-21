import { Component, Input } from '@angular/core';
import { Commentary } from '../../shared/models/Commentary';
import { MatCardModule } from '@angular/material/card';
import { UserService } from '../../shared/services/userService/user.service';
import { CommonModule, DatePipe } from '@angular/common';

@Component({
  selector: 'app-commentary',
  standalone: true,
  providers:[DatePipe],
  imports: [CommonModule,MatCardModule],
  templateUrl: './commentary.component.html',
  styleUrl: './commentary.component.scss'
})
export class CommentaryComponent {
  @Input() commentary !: Commentary

  constructor(private userService:UserService){}


  public getUserNameById(idUser: number| undefined){
    const undefined_return =  'Not specified' 
    if (idUser !=undefined){
      const user = this.userService.getUserById(idUser);
      return  user === undefined ? undefined_return : user.lastname.toUpperCase() + ' '+ user.name;

    }
    return undefined_return;
  }
}
