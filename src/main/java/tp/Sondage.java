package tp;

import tp.Choix;
import tp.Reunion;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Sondage {

    int id;
    String titre;
    Reunion reunion;
    Choix choix;

    public Sondage() {}

    public Sondage(String titre, String resume) {
        this.titre = titre;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @OneToOne
    public Choix getChoix() {
        return this.choix;
    }

    public void setChoix(Choix choix) {
        this.choix = choix;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    @ManyToOne
    public Reunion getReunion() {
        return reunion;
    }
}