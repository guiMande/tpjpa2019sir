package tp;

import tp.Participant;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Reunion {

    int id;
    String titre, resume;

    Collection<Sondage> sondages;

    public Reunion(){}

    public Reunion(String titre, String resume){
        this.titre =titre;
        this.resume = resume;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "reunion")
    public Collection<Sondage> getSondages() {
        return sondages;
    }

    public void setSondages(Collection<Sondage> sondages) {
        this.sondages = sondages;
    }
}
