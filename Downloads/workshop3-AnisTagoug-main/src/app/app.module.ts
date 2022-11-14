import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './composant/header/header.component';
import { FooterComponent } from './composant/footer/footer.component';

import { ContentComponent } from './composant/content/content.component';
import { ListUserComponent } from './composant/list-user/list-user.component';
import { FormsModule } from '@angular/forms';
import { ListProduitsComponent } from './composant/list-produits/list-produits.component';
import { AddProduitComponent } from './composant/add-produit/add-produit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ContentComponent,
    ListUserComponent,
    ListProduitsComponent,
    AddProduitComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
