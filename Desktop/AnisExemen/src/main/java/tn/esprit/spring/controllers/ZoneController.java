package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.services.IZoneServies;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {
    @Autowired
    IZoneServies iZoneServies;
    @GetMapping()
    public List<Zone> retrieveAllZone(){
        return iZoneServies.retrieveAllZone();
    }
    @PostMapping()
    public Zone addZone(@RequestBody Zone zone){
        return iZoneServies.addZone(zone);
    }
    @PutMapping("/{id}")
    public Zone updateZone (@RequestBody Zone zone,@PathVariable Integer id){
        return iZoneServies.updateZone(zone,id);
    }
    @GetMapping("/{id}")
    public Zone retrieveZone (@PathVariable Integer id){
        return iZoneServies.retrieveZone(id);
    }
    @DeleteMapping("/{id}")
    public void removeZone(@PathVariable Integer id){
        iZoneServies.removeZone(id);
    }
    @PostMapping("/assignpersozone/{idZone}/{idGarde}")
    public void assignpersozone(@PathVariable int idZone,@PathVariable int idGarde){
        iZoneServies.affecterPersonnelZone(idZone,idGarde);
    }
}
