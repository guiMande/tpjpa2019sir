package tp;

import tp.Choix;

import javax.persistence.*;

@Entity
public class Reponse {
    @Id
    @GeneratedValue
    long id;

    String nom, prenom;

    @ManyToOne
    Choix choix;

    public Reponse() {
    }

    public Reponse(String nom, String prenom) {
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
}
