package emmek.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventDaoImpl implements EventDao {

    private final EntityManager em;

    public EventDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Event event) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(event);
        tx.commit();
        System.out.println("Event " + event.getTitle() + " saved");
    }

    @Override
    public Event getById(long id) {
        return em.find(Event.class, id);
    }

    @Override
    public void delete(Event event) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(event);
        tx.commit();
        System.out.println("Event " + event.getTitle() + " deleted");
    }

    @Override
    public void refresh(Event event) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.refresh(event);
        tx.commit();
        System.out.println("Event refreshed");
    }

}
