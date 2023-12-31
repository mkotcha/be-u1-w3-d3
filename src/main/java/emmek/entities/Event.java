package emmek.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @Column(name = "event_date")
    private LocalDate eventDate;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;

    @Column(name = "max_participants")
    private int maxParticipants;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
    private Set<Participation> participations;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Event() {
    }

    public Event(String title, LocalDate eventDate, String description, EventType eventType, int maxParticipants, Location location) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
        this.location = location;
    }

    public long getId() {
        return id;
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

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }


    public Set<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(Set<Participation> participations) {
        this.participations = participations;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
