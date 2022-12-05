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
public class Reglement {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idReglement;
    private float montantPaye;
    private float montantRestant;
    @Temporal(TemporalType.DATE)
    private Date dateReglement;
    private Boolean archivee;
    @ManyToOne
    private Facture facture;
}
