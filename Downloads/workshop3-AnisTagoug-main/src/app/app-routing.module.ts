import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AddProduitComponent } from './composant/add-produit/add-produit.component';
import { ListProduitsComponent } from './composant/list-produits/list-produits.component';
import { ListUserComponent } from './composant/list-user/list-user.component';

const routes: Routes = [

  {path: 'list-user', component: ListUserComponent},
  {path: 'list-produits', component: ListProduitsComponent},
  {path: 'add-produit', component: AddProduitComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
