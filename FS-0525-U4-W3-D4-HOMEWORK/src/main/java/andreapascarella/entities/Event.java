package andreapascarella.entities;

import andreapascarella.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private UUID eventId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "maxParticipants", nullable = false)
    private int maxNumberOfParticipants;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location eventLocation;

    @OneToMany(mappedBy = "eventParticipation")
    private List<Participation> allParticipations;

    public Event() {
    }

    public Event(String title, LocalDate eventDate, String description, EventType eventType, int maxNumberOfPartecipants, Location eventLocation) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxNumberOfParticipants = maxNumberOfPartecipants;
        this.eventLocation = eventLocation;
    }

    public UUID getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxNumberOfParticipants() {
        return maxNumberOfParticipants;
    }

    public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
        this.maxNumberOfParticipants = maxNumberOfParticipants;
    }

    public Location getLocation() {
        return eventLocation;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxNumberOfParticipants=" + maxNumberOfParticipants +
                ", eventLocation=" + eventLocation;
    }
}
