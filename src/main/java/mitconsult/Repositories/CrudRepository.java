package mitconsult.Repositories;

import mitconsult.Personne;

import java.util.List;

public interface CrudRepository {

    List<Personne> getAll();
    Personne getById(int id);
    void create(Personne personne);
    Personne update(int id, String nom, String email);
    void delete(int id);
}
