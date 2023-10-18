package emmek.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDaoImpl implements LocationDao {

    private final EntityManager em;

    public LocationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Location location) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(location);
        tx.commit();
        System.out.println("Location " + location.getCity() + " saved");
    }

    @Override
    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    @Override
    public void delete(Location location) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(location);
        tx.commit();
        System.out.println("Event " + location.getCity() + " deleted");
    }

    @Override
    public void refresh(Location location) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.refresh(location);
        tx.commit();
        System.out.println("Location refreshed");
    }
}
