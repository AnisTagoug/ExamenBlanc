import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/app/Models/produit';
import { ProduitService } from 'src/app/Services/produit.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-produits',
  templateUrl: './list-produits.component.html',
  styleUrls: ['./list-produits.component.css']
})
export class ListProduitsComponent implements OnInit {
  code!:string;
  list! : Produit[];
  constructor(private prodsService : ProduitService, private router: Router) { }

  ngOnInit(): void {
    this.getAllProds();
  }



  getAllProds(){
    this.prodsService.getAllProds().subscribe(
      (data)=>{this.list = data ,
         console.log(this.list);}
     
    )
  }

  AjusteTva(id:number){

    //TO Do


    Swal.fire("TVA modifiée");
    this.router.navigate(['/list-produits']);
  }



search(){
  this.list = this.list.filter(res=>{
    return res.code.toLocaleLowerCase().match(this.code.toLocaleLowerCase());
  })
}

}
