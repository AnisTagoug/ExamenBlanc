package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Personnel;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.repositories.PersonnelRepository;
import tn.esprit.spring.repositories.ZoneRepository;

import java.util.List;

@Service
public class ZoneService implements IZoneServies{
    @Autowired
    ZoneRepository zoneRepository;
@Autowired
    PersonnelRepository personnelRepository;
    @Override
    public List<Zone> retrieveAllZone() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone addZone(Zone zone) {
        return zoneRepository.save(zone);
    }

    @Override
    public Zone updateZone(Zone zone, Integer id) {
        zone = zoneRepository.findById(id).orElse(null);
        zone.setRef(zone.getRef());
        zone.setDimension(zone.getDimension());
        return zoneRepository.save(zone);
    }

    @Override
    public Zone retrieveZone(Integer id) {
        return zoneRepository.findById(id).orElse(null);
    }

    @Override
    public void removeZone(Integer id) {
zoneRepository.deleteById(id);
    }
    public void affecterPersonnelZone(int idZone, int idGarde) {
        Zone zone = zoneRepository.findById(idZone).orElse(null);
        Personnel personnel = personnelRepository.findById(idGarde).orElse(null);
        if(zone != null && personnel != null){
            zone.setPersonnel(personnel);
            zoneRepository.save(zone);
        }
    }
}
