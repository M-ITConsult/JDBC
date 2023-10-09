package mitconsult.Repositories.Impl;

import mitconsult.ConnectionFactory;
import mitconsult.Repositories.CrudRepository;
import mitconsult.Repositories.Entities.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class CrudRepositoryImpl implements CrudRepository {

    @Override
    public List<Utilisateur> getAll() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT * FROM utilisateur";

        try (Connection connection = ConnectionFactory.CreateConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String email = resultSet.getString("email");

                Utilisateur utilisateur = new Utilisateur(id,nom,email);
                utilisateurs.add(utilisateur);
            }
    } catch (SQLException e) {
            throw new RuntimeException("Error connection",e);
        }

        return utilisateurs;
    }

    @Override
    public Utilisateur getById(int id){

        String query = "SELECT * FROM utilisateur WHERE id = ?";
        Utilisateur utilisateur = null;
        try (Connection connection = ConnectionFactory.CreateConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, id);

        try (ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String email = resultSet.getString("email");

                utilisateur = new Utilisateur(id, nom, email);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error Connection",e);
        }

        return utilisateur;
    }

    @Override
    public void create(Utilisateur utilisateur) {
        String query = "INSERT INTO utilisateur (nom, email) VALUES (?,?)";

        try(Connection connection = ConnectionFactory.CreateConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error connection",e);
        }
    }
    @Override
    public Utilisateur update(int id, String nom, String email) {
        String query = "UPDATE utilisateur SET nom = ?, email = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.CreateConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,email);
            preparedStatement.setInt(3,id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return getById(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error connection", e);
        }

        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM utilisateur WHERE id = ?";
        try(Connection connection = ConnectionFactory.CreateConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error to connect",e);
        }
    }
}
