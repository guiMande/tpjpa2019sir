package tp;

import tp.Participant;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reunion {

    @Id
    @GeneratedValue
    int id;
    String titre, resume;
    Date date;

    @ManyToOne
    Participant listParticipant;

    public Reunion(){}

    public Reunion (String titre, String resume) {
        this.titre = titre;
        this.resume= resume;
        listParticipant = new Participant();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
