package tn.esprit.spring.services;

import tn.esprit.spring.entities.Parking;

import java.util.List;

public interface IParkingServices {
    public List<Parking> retrieveAllParking();

    public Parking addParking (Parking parking);
    public Parking updateParking (Parking parking, Integer id);
    public Parking retrieveParking (Integer id);
    public void removeParking(Integer id);
    public void ajoutParkingetZone(Parking parking);
}
