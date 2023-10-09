package mitconsult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //            String query = "INSERT INTO utilisateur (nom, email)" +
//                    "VALUES ('"+ nom +"','"+ mail +"')";
        String query2 = "SELECT * FROM utilisateur";
        String query3 = "SELECT nom FROM utilisateur";

        try {
            Connection connection = ConnectionFactory.CreateConnection();
            System.out.println("Connexion effectué");

            // Méthode pour entrer les infos et créer l'utilisateur dans la BD
//            System.out.print("Entrez un nom: ");
//            String nom = sc.nextLine();
//            System.out.print("Entrez un mail: ");
//            String mail = sc.nextLine();
            Statement statement = connection.createStatement();
            // Affiche le nombre de requêtes et execute la query
//            int nbrRowUpdate = statement.executeUpdate(query);
//            System.out.println(nbrRowUpdate);
            // Méthode pour afficher le SELECT * FROM dans la console Java
            ResultSet resultSet = statement.executeQuery(query3);

            while(resultSet.next()) {
                // Affichage d'un ou plusieurs colonnes en fonction de la requête
                String column1 = resultSet.getString("nom");
                String column2 = resultSet.getString("email");


                System.out.printf("Result: %s", column1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Echec de connexion", e);
        }
    }
}
