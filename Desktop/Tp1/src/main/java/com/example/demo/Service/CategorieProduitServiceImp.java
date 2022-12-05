package com.example.demo.Service;

import com.example.demo.Entity.CategorieProduit;
import com.example.demo.Repository.CategorieProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class CategorieProduitServiceImp implements ICategorieProduitService {

    @Autowired /*field injection*/
            CategorieProduitRepository categorieProduitRepository;


    @Override
    public List <CategorieProduit> retrieveAllCategorieProduit() {
        return categorieProduitRepository.findAll();
    }

    @Override
    public CategorieProduit addCategorieProduit(CategorieProduit categorieProduit) {
        categorieProduit.setLibelleCategorieProduit(categorieProduit.getLibelleCategorieProduit());
        categorieProduit.setCodeProduit(categorieProduit.getCodeProduit());
        categorieProduit.setProduits(categorieProduit.getProduits());



        categorieProduitRepository.save(categorieProduit);
        return  categorieProduit;
    }

    @Override
    public CategorieProduit updateCategorieProduit(CategorieProduit categorieProduit) {
        return this.categorieProduitRepository.save(categorieProduit);
    }

    @Override
    public CategorieProduit retrieveCategorieProduit(long idCategorieProduit) {
        return categorieProduitRepository.findById(idCategorieProduit).orElse(null);
    }

    @Override
    public void removeCategorieProduit(long idCategorieProduit) {
        categorieProduitRepository.deleteById(idCategorieProduit);

    }
}
