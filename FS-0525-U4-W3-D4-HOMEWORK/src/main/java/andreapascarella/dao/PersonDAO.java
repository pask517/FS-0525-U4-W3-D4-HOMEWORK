package andreapascarella.dao;

import andreapascarella.entities.Person;
import andreapascarella.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonDAO {

    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void savePerson(Person newPerson) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newPerson);

        transaction.commit();

        System.out.println("La persona " + newPerson.getPersonId() + " è stata salvata correttamente!");
    }

    public Person findById(String personId) {
        Person found = em.find(Person.class, UUID.fromString(personId));
        if (found == null) throw new NotFoundException(personId);
        return found;
    }
}
