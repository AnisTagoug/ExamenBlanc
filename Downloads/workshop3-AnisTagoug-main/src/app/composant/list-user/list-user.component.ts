import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Models/user';
import { ServicesService } from 'src/app/Services/services.service';
@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {
  list! : User[];
  constructor(private ServicesService : ServicesService) { }
  Category! : string ;
  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(){
    this.ServicesService.getAllUsers().subscribe(
      (data)=>{this.list = data ,
         console.log(this.list);}
     
    )
  }
  deleteUser(id:number){
    this.ServicesService.deleteUser(id);
    this.getAllUsers();
  }
  searchUserByAccountCategory(){
    this.ServicesService.searchUserByAccountCategory(this.Category).subscribe(
      (data)=>{this.list = data ,
         console.log(this.list);}
     
    )
  }
 
}
