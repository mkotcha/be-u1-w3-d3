package emmek.entities;

public interface PersonDao {
    public void save(Person person);

    public Person getById(long id);

    public void delete(Person person);

    public void refresh(Person person);
}
