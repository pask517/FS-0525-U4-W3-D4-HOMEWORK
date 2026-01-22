package andreapascarella.dao;

import andreapascarella.entities.Event;
import andreapascarella.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventsDAO {

    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void saveEvent(Event newEvent) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(newEvent);

        transaction.commit();

        System.out.println("L'evento " + newEvent.getEventId() + " è stato salvato correttamente!");
    }

    public Event findById(String eventId) {
        Event found = em.find(Event.class, UUID.fromString(eventId));
        if (found == null) throw new NotFoundException(eventId);
        return found;
    }

    public Event getConcertsPerGenre() {
    }

    public Event getConcertsInStreaming() {
    }
}
