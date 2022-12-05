package com.example.demo.Service;

import com.example.demo.Entity.Produit;

import java.util.List;

public interface IProduitService {
   public List<Produit> retrieveAllProduit();

   public Produit addProduit (Produit produit);
   public  Produit updateProduit (Produit produit);
   public Produit retrieveProduit (long idProduit);
    public void removeProduit(long idProduit);
}
