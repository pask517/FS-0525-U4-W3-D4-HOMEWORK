package andreapascarella.dao;

import andreapascarella.entities.Event;
import andreapascarella.enums.GenreType;
import andreapascarella.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    public List<Event> getConcertsPerGenre(GenreType genre) {
        TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e WHERE e.genre=:g", Event.class);
        query.setParameter("g", genre);
        return query.getResultList();
    }

    //public Event getConcertsInStreaming() {
    // }
}
