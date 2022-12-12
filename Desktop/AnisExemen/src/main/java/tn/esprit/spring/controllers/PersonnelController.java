package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Personnel;

import tn.esprit.spring.services.IPersonnelServices;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    IPersonnelServices iPersonnelServices;
    @GetMapping()
    public List<Personnel> retrieveAllPersonnel(){
        return iPersonnelServices.retrieveAllPersonnel();
    }
    @PostMapping()
    public Personnel addPersonnel(@RequestBody Personnel personnel){
        return iPersonnelServices.addPersonnel(personnel);
    }
    @PutMapping("/{id}")
    public Personnel updatePersonnel (@RequestBody Personnel personnel,@PathVariable Integer id){
        return iPersonnelServices.updatePersonnel(personnel,id);
    }
    @GetMapping("/{id}")
    public Personnel retrievePersonnel (@PathVariable Integer id){
        return iPersonnelServices.retrievePersonnel(id);
    }
    @DeleteMapping("/{id}")
    public void removePersonnel(@PathVariable Integer id){
        iPersonnelServices.removePersonnel(id);
    }
    @GetMapping("/getAllpersonnelByParking/{id}")
    public List <Personnel> getAllPersonnelByParking(@PathVariable int id){
        return iPersonnelServices.getAllPersonnelByParking(id);
    }
    @GetMapping("/nombreGardeJour/{adresse}")
    public  Integer nombreGardeJour( @PathVariable String adresse ){
        return iPersonnelServices.nombreGardeJour(adresse);

    }
    @GetMapping("/getPbyD/{date1}/{date2}")
    public List<Personnel>getPersonalByDate(@PathVariable LocalDate date1, @PathVariable LocalDate date2)
    {
        return iPersonnelServices.getPersonelByDate(date1,date2);
    }

    @GetMapping("/getNbrGardeByZone")
    public void getNbrGardesByZone(){

    }


}
