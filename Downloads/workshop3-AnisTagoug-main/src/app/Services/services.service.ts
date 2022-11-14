import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Users } from '../LocalData/Users';
import { User } from '../Models/user';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  
  constructor() { }
  getAllUsers():Observable<User[]>{
     const users = of (Users)
      return users
  }
  deleteUser(id:number){
    Users.splice(id,1)
    return Users ;
  }
  
  searchUserByAccountCategory(accountCategory:string):Observable<User[]>{
    const users = of ((Users.filter(user=>user.accountCategory.toUpperCase()==accountCategory.toUpperCase())))
    return users
  }
  //liveSearchUserByAccountCategory(accountCategory:string):Observable<User[]>{ 
    //const users = of (Users.filter(user=>user.accountCategory.toUpperCase().includes(accountCategory.toUpperCase())))
    //return users
 // }
}
