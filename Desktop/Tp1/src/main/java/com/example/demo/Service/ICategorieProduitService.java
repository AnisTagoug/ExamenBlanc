package com.example.demo.Service;

import com.example.demo.Entity.CategorieProduit;

import java.util.List;

public interface ICategorieProduitService {
   public List<CategorieProduit> retrieveAllCategorieProduit();

   public CategorieProduit addCategorieProduit (CategorieProduit categorieProduit);
   public  CategorieProduit updateCategorieProduit (CategorieProduit categorieProduite);
   public CategorieProduit retrieveCategorieProduit (long idCategorieProduit);
    public void removeCategorieProduit(long idCategorieProduit);
}
