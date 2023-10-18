package emmek.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String city;

    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    private Set<Event> events;


    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
