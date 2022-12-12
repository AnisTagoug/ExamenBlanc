package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Parking;

public interface ParkingRepository extends JpaRepository<Parking,Integer> {
}
