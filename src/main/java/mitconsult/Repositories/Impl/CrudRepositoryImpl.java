package mitconsult.Repositories.Impl;

import mitconsult.Personne;
import mitconsult.Repositories.CrudRepository;

import java.util.List;

public class CrudRepositoryImpl implements CrudRepository {

    @Override
    public List<Personne> getAll() {
        return null;
    }

    @Override
    public Personne getById(int id) {
        return null;
    }

    @Override
    public void create(Personne personne) {

    }

    @Override
    public Personne update(int id, String nom, String email) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
