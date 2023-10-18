package emmek;

import emmek.entities.Event;
import emmek.entities.EventDaoImpl;
import emmek.entities.EventType;
import emmek.utils.JpaUtil;
import net.datafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.concurrent.TimeUnit;

public class Application {
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Event event;
        Faker faker = new Faker();
        EventDaoImpl eventDao = new EventDaoImpl(em);
        try {
            for (int i = 0; i < 10; i++) {
                event = new Event(faker.book().title(),
                        faker.date().future(365, TimeUnit.DAYS).toLocalDateTime().toLocalDate(),
                        faker.lorem().paragraph(),
                        faker.options().option(EventType.class),
                        faker.number().numberBetween(10, 200));
                eventDao.save(event);

            }
            System.out.println();
            eventDao.delete(eventDao.getById(42));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}