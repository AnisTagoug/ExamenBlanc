package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Parking;
import tn.esprit.spring.services.IParkingServices;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    IParkingServices iParkingServices;
    @GetMapping()
    public List<Parking> retrieveAllParking(){
        return iParkingServices.retrieveAllParking();
    }
    @PostMapping()
    public Parking addParking (@RequestBody Parking parking){
        return iParkingServices.addParking(parking);
    }
    @PutMapping("/{id}")
    public Parking updateParking (@RequestBody Parking parking,@PathVariable Integer id){
        return iParkingServices.updateParking(parking,id);
    }
    @GetMapping("/{id}")
    public Parking retrieveParking (@PathVariable Integer id){
        return iParkingServices.retrieveParking(id);
    }
    @DeleteMapping("/{id}")
    public void removeParking(@PathVariable Integer id){
        iParkingServices.removeParking(id);
    }
    @PostMapping("/zone")
    public Parking addParkingZone (@RequestBody Parking parking){
         iParkingServices.ajoutParkingetZone(parking);
         return parking;
    }


}
