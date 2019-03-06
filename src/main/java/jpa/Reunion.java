package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Reunion {

    int id;
    String titre, resume;
    Date date;
    ArrayList<Participant> listParticipant;

    public Reunion(){}

    public Reunion (String titre, String resume) {
        this.titre = titre;
        this.resume= resume;
        listParticipant = new ArrayList<Participant>();
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
