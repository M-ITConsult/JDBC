package mitconsult.Repositories.Entities;

import lombok.*;


@Getter@Setter@Builder@AllArgsConstructor@NoArgsConstructor@ToString@EqualsAndHashCode
public class Utilisateur {
    private int id;
    private String nom;
    private String email;

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
}
