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
public class Operateur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idOperateur;
    private String nom;
    private String prenom;
    private String password;
    @OneToMany(mappedBy = "operateurfa")
    private Set<Facture> listfacture;
}
