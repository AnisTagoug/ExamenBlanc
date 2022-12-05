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
public class Facture {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idFacture;
    private float montantRemise;
    private float montantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateCreationFacture;
    @Temporal(TemporalType.DATE)
    private Date dateDernierModifcation;
    @OneToMany(mappedBy = "facture")
    private Set <Reglement> listReglement;
    @OneToMany(mappedBy = "facture")
    private Set <DetailFacture> listdetailfacture;
    @ManyToOne
    private Operateur operateurfa;
    @ManyToOne
    private Fournisseur fournisseur;
}
