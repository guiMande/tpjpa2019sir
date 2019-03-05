package jpa;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Sondage {

    @Id
    @GeneratedValue
    int id;

    String titre;

    @OneToMany
    Collection<Question> questions;

    Date date;

    @ManyToOne
    Participant utilisateur;

    @Enumerated(EnumType.STRING)
    Choix choix;

    public Sondage() {}

    public Sondage(String titre) {
        this.titre = titre;
    }

    public long getId() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setId(int id) {
        // TODO Auto-generated method stub
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Choix getChoix() {
        return this.choix;
    }

    public void setChoix(Choix choix) {
        this.choix = choix;
    }
}
