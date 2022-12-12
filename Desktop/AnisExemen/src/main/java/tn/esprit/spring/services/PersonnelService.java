package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Personnel;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.repositories.PersonnelRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonnelService implements IPersonnelServices{
    @Autowired
    PersonnelRepository personnelRepository;

    @Override
    public List<Personnel> retrieveAllPersonnel() {
        return personnelRepository.findAll();
    }

    @Override
    public Personnel addPersonnel(Personnel personnel) {
        return personnelRepository.save(personnel);
    }

    @Override
    public Personnel updatePersonnel(Personnel personnel, Integer id) {
         personnel = personnelRepository.findById(id).orElse(null);
         personnel.setNom(personnel.getNom());
         personnel.setPrenom(personnel.getPrenom());
         personnel.setAge(personnel.getAge());
         personnel.setDateDeRecrutement(personnel.getDateDeRecrutement());
         personnel.setLogin(personnel.getLogin());
         personnel.setPassword(personnel.getPassword());
         personnel.setPoste(personnel.getPoste());
        return personnelRepository.save(personnel);
    }

    @Override
    public Personnel retrievePersonnel(Integer id) {
        return personnelRepository.findById(id).orElse(null);
    }

    @Override
    public void removePersonnel(Integer id) {
        personnelRepository.deleteById(id);
    }

    @Override
    public List<Personnel> getAllPersonnelByParking(int id) {
        return null;
    }

    @Override
    public Integer nombreGardeJour(String adresse) {
        return null;
    }

    @Override
    public List<Personnel> getPersonalByDate(LocalDate date1, LocalDate date2) {
        return null;
    }

}
