package andreapascarella.dao;

import andreapascarella.entities.Participation;
import andreapascarella.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class ParticipationsDAO {
    private final EntityManager em;

    public ParticipationsDAO(EntityManager em) {
        this.em = em;
    }

    public void saveParticipation(Participation newParticipation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newParticipation);

        transaction.commit();

        System.out.println("La participation " + newParticipation.getParticipationId() + " è stata salvata correttamente!");
    }

    public Participation findById(String participationId) {
        Participation found = em.find(Participation.class, UUID.fromString(participationId));
        if (found == null) throw new NotFoundException(participationId);
        return found;
    }
}