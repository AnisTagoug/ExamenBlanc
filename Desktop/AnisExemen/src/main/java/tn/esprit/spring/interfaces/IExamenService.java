package tn.esprit.spring.interfaces;


import tn.esprit.spring.entities.Personnel;
import tn.esprit.spring.entities.Parking;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.entities.Poste;

import java.util.List;

public interface IExamenService {

    public Parking ajouterBeneficiaire (Parking bf);

    public Zone ajouterContrat (Zone c);

    public Personnel ajouterAssurance (Personnel a, int cinBf, String matricule);

    public Zone getContratBf (int idBf);

    public List<Parking> getBeneficairesByType (Poste typeContrat);
    public float getMontantBf (int cinBf);
    void statistiques();

}

