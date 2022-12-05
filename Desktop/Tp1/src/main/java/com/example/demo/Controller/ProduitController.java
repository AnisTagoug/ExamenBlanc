package com.example.demo.Controller;



import com.example.demo.Entity.Produit;
import com.example.demo.Service.ProduitServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private ProduitServiceImp produitServiceImp;


    @GetMapping()
    public List<Produit> produits(){

        return produitServiceImp.retrieveAllProduit();

    }


    @PostMapping()
    public ResponseEntity<Produit> addcategorieProduit(@RequestBody Produit produit){

        return ResponseEntity.ok(this.produitServiceImp.addProduit(produit));


    }


    @PutMapping()
    public ResponseEntity<Produit>updatecategorieProduit(@RequestBody Produit produit){

        return ResponseEntity.ok(this.produitServiceImp.updateProduit(produit));


    }



    @GetMapping("/{id}")
    public Produit retrieveProduit (@PathVariable("id") long id) {

        return this.produitServiceImp.retrieveProduit(id);

    }


    @DeleteMapping("/delete/{id}")
    public void removeProduit(@PathVariable("id") long id) {

        this.produitServiceImp.removeProduit(id);

    }

}
