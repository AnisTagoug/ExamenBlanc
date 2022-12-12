package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Parking;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.repositories.ParkingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParkingService implements IParkingServices{
    @Autowired
    ParkingRepository parkingRepository;

    @Override
    public List<Parking> retrieveAllParking() {
        return parkingRepository.findAll();
    }

    @Override
    public Parking addParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    public Parking updateParking(Parking parking, Integer id) {
         parking = parkingRepository.findById(id).orElse(null);
         parking.setDesignation(parking.getDesignation());
         parking.setAdresse(parking.getAdresse());
         parking.setCapacite(parking.getCapacite());

        return parkingRepository.save(parking);
    }

    @Override
    public Parking retrieveParking(Integer id) {
        return parkingRepository.findById(id).orElse(null);
    }

    @Override
    public void removeParking(Integer id) {
        parkingRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void ajoutParkingetZone(Parking parking) {
        Parking p = parkingRepository.save(parking);
        System.out.println(p.getZones());
        for (Zone z :p.getZones()){
            z.setParking(p);
        }

    }
}
