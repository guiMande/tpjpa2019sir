package tp;

import tp.Choix;
import tp.Reunion;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Sondage {

    @Id
    @GeneratedValue
    int id;

    String titre;

    @OneToOne
    Reunion reunion;

    @ManyToMany
    @JoinTable(name = "sondage_choix")
    Collection<Choix> choix;

    public Sondage() {}

    public Sondage(String titre, String resume) {
        this.titre = titre;
        reunion = new Reunion(titre, resume);
        Choix choix1 = new Choix("OUI");
        Choix choix2 = new Choix("NON");
        choix.add(choix1);
        choix.add(choix2);
    }

    public int getId() {
        return this.id;
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

    public Collection<Choix> getChoix() {
        return this.choix;
    }

    public void setChoix(Collection<Choix> choix) {
        this.choix = choix;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public Reunion getReunion() {
        return reunion;
    }
}
