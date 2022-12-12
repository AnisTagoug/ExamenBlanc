package tn.esprit.spring.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String designation;
    private String adresse;
    private int capacite;
@OneToMany(mappedBy = "parking")
private Set<Zone> zones;



}
