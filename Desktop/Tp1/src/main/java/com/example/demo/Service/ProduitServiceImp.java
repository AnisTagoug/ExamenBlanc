package com.example.demo.Service;


import com.example.demo.Entity.Produit;
import com.example.demo.Repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProduitServiceImp implements IProduitService {

    @Autowired /*field injection*/
            ProduitRepository produitRepository;


    @Override
    public List <Produit> retrieveAllProduit() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit produit) {
        produit.setCodeProduit(produit.getCodeProduit());
        produit.setLibelleProduit(produit.getLibelleProduit());
        produit.setPrix(produit.getPrix());
        produit.setDateCreationt(produit.getDateCreationt());
        produit.setDateDernierModifcation(produit.getDateDernierModifcation());



        produitRepository.save(produit);
        return  produit;
    }

    @Override
    public Produit updateProduit(Produit categorieProduit) {
        return this.produitRepository.save(categorieProduit);
    }

    @Override
    public Produit retrieveProduit(long idProduit) {
        return produitRepository.findById(idProduit).orElse(null);
    }

    @Override
    public void removeProduit(long idProduit) {
        produitRepository.deleteById(idProduit);

    }
}
