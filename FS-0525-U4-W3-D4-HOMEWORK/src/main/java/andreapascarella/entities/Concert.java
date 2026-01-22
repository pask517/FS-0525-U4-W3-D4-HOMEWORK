package andreapascarella.entities;

import andreapascarella.enums.EventType;
import andreapascarella.enums.GenreType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Concert extends Event {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreType genre;

    private boolean inStreaming;

    public Concert() {
    }

    public Concert(String title, LocalDate eventDate, String description, EventType eventType, int maxNumberOfPartecipants, Location eventLocation, GenreType genre, boolean inStreaming) {
        super(title, eventDate, description, eventType, maxNumberOfPartecipants, eventLocation);
        this.genre = genre;
        this.inStreaming = inStreaming;
    }

    public GenreType getGenre() {
        return genre;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    @Override
    public String toString() {
        return super.toString() +
                "genre=" + genre +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
