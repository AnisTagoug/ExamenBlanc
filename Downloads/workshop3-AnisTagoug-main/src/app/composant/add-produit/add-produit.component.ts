import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/Models/produit';
import { Observable, of } from 'rxjs';
import { Produits } from 'src/app/LocalData/Produits';

@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html',
  styleUrls: ['./add-produit.component.css']
})
export class AddProduitComponent implements OnInit {
  produit!:Produit;
  list : Produit[]=[];
  constructor() { }

  ngOnInit(): void {
    this.produit = new Produit();
  }



  save(){

      this.list.push(this.produit);
    console.log(this.produit);


  }
}
