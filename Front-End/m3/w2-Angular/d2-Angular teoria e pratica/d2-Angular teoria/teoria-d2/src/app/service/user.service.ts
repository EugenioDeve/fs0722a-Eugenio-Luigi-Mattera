import { User } from "../models/user.interface";
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  users: User[] = [];

  constructor() { }

  createUser(nome: string){
    this.users.push({
      nome,
      stato: 'occupato'
    });

  }

  updateUser(index: number, newStatus: string){
    this.users[index].stato = newStatus;
  }
}
