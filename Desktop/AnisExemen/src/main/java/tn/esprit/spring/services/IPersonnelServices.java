package tn.esprit.spring.services;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.entities.Personnel;

import java.time.LocalDate;
import java.util.List;

public interface IPersonnelServices {
    public List<Personnel> retrieveAllPersonnel();

    public Personnel addPersonnel(Personnel personnel);
    public Personnel updatePersonnel(Personnel personnel, Integer id);
    public Personnel retrievePersonnel (Integer id);
    public void removePersonnel(Integer id);
    public List <Personnel> getAllPersonnelByParking(@PathVariable int id);
    public  Integer nombreGardeJour( @PathVariable String adresse );
    public List<Personnel>getPersonalByDate(@PathVariable LocalDate date1, @PathVariable LocalDate date2);
}
