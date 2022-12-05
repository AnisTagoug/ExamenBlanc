package com.example.demo.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategorieProduit {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idCategorieProduit;
    private String codeProduit;
    private String libelleCategorieProduit;
    @OneToMany(mappedBy = "categorieProduit")
    private Set <Produit> produits;
}
