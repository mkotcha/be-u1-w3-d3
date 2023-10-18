package emmek.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonDaoImpl implements PersonDao {

    private final EntityManager em;

    public PersonDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Person person) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(person);
        tx.commit();
        System.out.println("Location " + person.getName() + " saved");
    }

    @Override
    public Person getById(long id) {
        return em.find(Person.class, id);
    }

    @Override
    public void delete(Person person) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(person);
        tx.commit();
        System.out.println("Event " + person.getName() + " deleted");
    }

    @Override
    public void refresh(Person person) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.refresh(person);
        tx.commit();
        System.out.println("Location refreshed");
    }
}
