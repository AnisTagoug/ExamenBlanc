package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date dateDeRecrutement;
    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private Poste poste;
    @JsonIgnore
    @OneToOne(mappedBy = "personnel",fetch = FetchType.EAGER)
    private Zone zoneb;


}
