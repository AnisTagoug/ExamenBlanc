package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Zone;

public interface ZoneRepository extends JpaRepository<Zone,Integer> {
}
