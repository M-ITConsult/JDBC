package mitconsult.Repositories;
import mitconsult.Repositories.Entities.Utilisateur;
import java.util.List;

public interface CrudRepository {

    List<Utilisateur> getAll();
    Utilisateur getById(int id);
    void create(Utilisateur utilisateur);
    Utilisateur update(int id, String nom, String email);
    void delete(int id);
}
