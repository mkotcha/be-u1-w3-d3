package emmek.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ParticipationDaoImpl implements ParticipationDao {

    private final EntityManager em;

    public ParticipationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Participation participation) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(participation);
        tx.commit();
        System.out.println("Event " + participation.getPerson().getName() + " - " + participation.getEvent().getTitle() + " saved");
    }

    @Override
    public Participation getById(long id) {
        return em.find(Participation.class, id);
    }

    @Override
    public void delete(Participation participation) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(participation);
        tx.commit();
        System.out.println("Event " + participation.toString() + " deleted");
    }

    @Override
    public void refresh(Participation participation) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.refresh(participation);
        tx.commit();
        System.out.println("Participation refreshed");
    }
}
