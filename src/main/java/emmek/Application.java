package emmek;

import emmek.entities.*;
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
        Location location;
        Person person;
        Participation participation;
        Faker faker = new Faker();
        EventDaoImpl eventDao = new EventDaoImpl(em);
        LocationDaoImpl locationDao = new LocationDaoImpl(em);
        PersonDaoImpl personDao = new PersonDaoImpl(em);
        ParticipationDaoImpl participationDao = new ParticipationDaoImpl(em);
        try {
            for (int i = 0; i < 10; i++) {

                location = new Location(faker.address().cityName(), faker.address().city());
                locationDao.save(location);
                event = new Event(faker.book().title(),
                        faker.date().future(365, TimeUnit.DAYS).toLocalDateTime().toLocalDate(),
                        faker.lorem().paragraph(),
                        faker.options().option(EventType.class),
                        faker.number().numberBetween(10, 200),
                        location);
                eventDao.save(event);
                person = new Person(faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.date().birthday().toLocalDateTime().toLocalDate(),
                        faker.options().option(Sex.class));
                personDao.save(person);
                participation = new Participation(person, event, faker.options().option(ParticipationState.class));
                participationDao.save(participation);
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