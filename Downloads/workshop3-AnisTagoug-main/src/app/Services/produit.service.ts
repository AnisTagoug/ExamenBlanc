import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Produits } from '../LocalData/Produits';
import { Produit } from '../Models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
 // produits:Produits;
  constructor() { }

  getAllProds():Observable<Produit[]>{

    const prods = of (Produits)
    return prods;

  }

  modifTva(id:number){

    const a=20;
    


  }

}
