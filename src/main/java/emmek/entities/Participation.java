package emmek.entities;

import javax.persistence.*;

@Entity
@Table(name = "participations")
public class Participation {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private ParticipationState participationState;

    public Participation() {
    }

    public Participation(Person person, Event event) {
        this.person = person;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ParticipationState getParticipationState() {
        return participationState;
    }

    public void setParticipationState(ParticipationState participationState) {
        this.participationState = participationState;
    }


}
