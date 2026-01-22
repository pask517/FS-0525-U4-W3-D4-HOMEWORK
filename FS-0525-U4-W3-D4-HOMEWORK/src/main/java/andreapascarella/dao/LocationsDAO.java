package andreapascarella.dao;


import andreapascarella.entities.Location;
import andreapascarella.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationsDAO {


    private final EntityManager em;

    public LocationsDAO(EntityManager em) {
        this.em = em;
    }

    public void saveLocation(Location newLocation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newLocation);

        transaction.commit();

        System.out.println("La location " + newLocation.getLocationId() + " è stata salvata correttamente!");
    }

    public Location findById(String locationId) {
        Location found = em.find(Location.class, UUID.fromString(locationId));
        if (found == null) throw new NotFoundException(locationId);
        return found;
    }

    public void deleteLocationById(String locationId) {
        Location found = em.find(Location.class, UUID.fromString(locationId));
        if (found == null) throw new NotFoundException(locationId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("La location " + found.getName() + " é stata eliminata con successo");
    }
}
