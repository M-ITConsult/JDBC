package mitconsult;
import mitconsult.Repositories.Entities.Utilisateur;
import mitconsult.Repositories.Impl.CrudRepositoryImpl;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CrudRepositoryImpl crudRepo = new CrudRepositoryImpl();

        List<Utilisateur> utilisateurs = crudRepo.getAll();
        utilisateurs.forEach(u-> System.out.println(u.toString()));

//        crudRepo.delete(3);
//        crudRepo.create(new Utilisateur("Test4","test4@gmail.com"));


//        String query = "INSERT INTO utilisateur (nom, email) VALUES ('"+ nom +"','"+ mail +"')";
//        String query2 = "SELECT * FROM utilisateur";
//        String query3 = "SELECT * FROM utilisateur WHERE id=1";
//        String query4 = "SELECT email FROM utilisateur";
//        String query5 = "INSERT INTO utilisateur (nom, email) VALUES (?,?)";

//        try {
//            Connection connection = ConnectionFactory.CreateConnection();
//            PreparedStatement statement = connection.prepareStatement(query5);
//            statement.setString(1,"Dupond");
//            statement.setString(2,"dupond@gmail.com");
//            statement.addBatch();
//
//            int[] resultCounts = statement.executeBatch();
//            System.out.println(Arrays.toString(resultCounts));
//
//            System.out.println("Connexion effectué");
//
//            // Méthode pour entrer les infos et créer l'utilisateur dans la BD
////            System.out.print("Entrez un nom: ");
////            nom = sc.nextLine();
////            System.out.print("Entrez un mail: ");
////            mail = sc.nextLine();
//            // Affiche le nombre de requêtes et execute la query
////            int nbrRowUpdate = statement.executeUpdate(query);
////            System.out.println(nbrRowUpdate);
//            // Méthode pour afficher le SELECT * FROM dans la console Java
//            statement.executeQuery(query5);
//
//            while(resultSet.next()) {
//                // Affichage d'un ou plusieurs colonnes en fonction de la requête
//                String column1 = resultSet.getString("nom");
//                String column2 = resultSet.getString("email");
//
//
//                System.out.printf("Result: %s%n", column2);
//            }
//
//            System.out.println();
//
//        } catch (SQLException e) {
//            throw new RuntimeException("Echec de connexion", e);
//        }
//

        // Méthode pour récupérer toutes les colonnes sans connaître à l'avance le nom
        String query = "SELECT * FROM utilisateur";
        try (Connection connection = ConnectionFactory.CreateConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    System.out.println(columnName + ": " + columnValue);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error Connection",e);
        }
    }
}
