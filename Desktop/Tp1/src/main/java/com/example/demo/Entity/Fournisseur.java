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
public class Fournisseur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idFournisseur;
    private String codeFournisseur;
    private String libelleFournisseur;
    @Enumerated(EnumType.STRING)
    private CategorieFrounisseur categorieFrounisseur;
    @OneToMany(mappedBy = "fournisseur")
    private Set<Facture> listfacture;
    @OneToOne
    private DetailFournisseur listdetailfacture;
    @ManyToMany(mappedBy = "fournisseursa")
    private Set<SecteurActivite>  secteurActivites;
}
