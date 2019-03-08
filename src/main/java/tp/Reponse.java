package tp;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;

/**
 * @author guillaume
 */
@Entity
public class Reponse {
    @Id
    @GeneratedValue
    long id;

    String nom, prenom;

    @Column(length = 2048)
    String valide;

    @OneToOne
    @JsonManagedReference
    Choix choix;

    public Reponse() {
    }

    public Reponse(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setChoix(Choix choix) {
        this.choix = choix;
    }

    public Choix getChoix() {
        return choix;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public String getValide() {
        return valide;
    }
}
