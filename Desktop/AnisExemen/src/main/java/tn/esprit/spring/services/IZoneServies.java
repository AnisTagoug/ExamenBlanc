package tn.esprit.spring.services;

import tn.esprit.spring.entities.Zone;

import java.util.List;

public interface IZoneServies {
    public List<Zone> retrieveAllZone();

    public Zone addZone(Zone zone);
    public Zone updateZone(Zone zone, Integer id);
    public Zone retrieveZone (Integer id);
    public void removeZone(Integer id);
    public void affecterPersonnelZone(int idZone, int idGarde);
}
