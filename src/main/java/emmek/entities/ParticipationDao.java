package emmek.entities;

public interface ParticipationDao {
    public void save(Participation participation);

    public Participation getById(long id);

    public void delete(Participation participation);

    public void refresh(Participation participation);
}
