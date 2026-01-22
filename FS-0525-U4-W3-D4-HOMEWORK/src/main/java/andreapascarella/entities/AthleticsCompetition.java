package andreapascarella.entities;

import andreapascarella.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AthleticsCompetition extends Event {

    @OneToMany(mappedBy = "competition")
    private Set<Person> athletes = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person winner;

    public AthleticsCompetition() {
    }

    public AthleticsCompetition(String title, LocalDate eventDate, String description, EventType eventType, int maxNumberOfPartecipants, Location eventLocation, Person winner) {
        super(title, eventDate, description, eventType, maxNumberOfPartecipants, eventLocation);
        this.winner = winner;
    }

    public Set<Person> getAthletes() {
        return athletes;
    }

    public Person getWinner() {
        return winner;
    }
}
