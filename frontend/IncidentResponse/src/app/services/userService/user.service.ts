import { Injectable } from '@angular/core';
import { User } from '../../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  
  private users : Array<User>= [
    {id:0, mail: "test@gmail;com", lastname: "Telsa",name: "Nicolas",company:"Tesla"},
    {id:1, mail: "test@gmail;com", lastname: "Edison",name: "Mark",company:"Tesla"}
  ];
  constructor() { }

  public getUsers(){
    return this.users
  }
  public getUserById(id:number) {
    return this.users.find( (user) => user.id === id);
  }
}
