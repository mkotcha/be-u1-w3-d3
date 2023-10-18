package emmek.entities;

public interface EventDao {
    public void save(Event event);

    public Event getById(long id);

    public void delete(Event event);

    public void refresh(Event event);
}
