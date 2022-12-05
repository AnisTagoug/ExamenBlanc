package com.example.demo.Controller;


import com.example.demo.Entity.CategorieProduit;
import com.example.demo.Service.CategorieProduitServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorieproduit")
public class CategorieProduitController {

    @Autowired
    private CategorieProduitServiceImp categorieProduitService;


    @GetMapping()
    public List<CategorieProduit> categorieProduits(){

        return categorieProduitService.retrieveAllCategorieProduit();

    }


    @PostMapping()
    public ResponseEntity<CategorieProduit> addcategorieProduit(@RequestBody CategorieProduit categorieProduit){

        return ResponseEntity.ok(this.categorieProduitService.addCategorieProduit(categorieProduit));


    }


    @PutMapping()
    public ResponseEntity<CategorieProduit>updatecategorieProduit(@RequestBody CategorieProduit categorieProduit){

        return ResponseEntity.ok(this.categorieProduitService.updateCategorieProduit(categorieProduit));


    }



    @GetMapping("/{id}")
    public CategorieProduit retrieveContrat (@PathVariable("id") long id) {

        return this.categorieProduitService.retrieveCategorieProduit(id);

    }


    @DeleteMapping("/delete/{id}")
    public void removeContrat(@PathVariable("id") long id) {

        this.categorieProduitService.removeCategorieProduit(id);

    }

}
