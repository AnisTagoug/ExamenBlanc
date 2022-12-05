package com.example.demo.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailFournisseur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idDetailFournisseur;
    @Temporal(TemporalType.DATE)
    private Date dateDebutCollaboration;
    private String adresse;
    private String matricule;
    @OneToOne(mappedBy = "listdetailfacture")
    private Fournisseur fournisseur;
}
