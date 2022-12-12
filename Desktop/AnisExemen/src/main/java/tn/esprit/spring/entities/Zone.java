package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ref;
    private float dimension;
    @OneToMany
    private Set<Personnel> personnels;
    @OneToOne
    private Personnel personnel;
    @ManyToOne
    private Parking parking;

}
