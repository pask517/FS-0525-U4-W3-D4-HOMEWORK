package andreapascarella.entities;

import andreapascarella.enums.StateType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "participations")
public class Participation {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person owner;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event eventParticipation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StateType state;

    public Participation() {
    }

    public Participation(StateType state, Person owner, Event eventParticipation) {
        this.state = state;
        this.owner = owner;
        this.eventParticipation = eventParticipation;
    }

    public UUID getParticipationId() {
        return id;
    }

    public Person getOwner() {
        return owner;
    }

    public Event getEventParticipation() {
        return eventParticipation;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }

}
