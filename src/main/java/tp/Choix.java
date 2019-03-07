package tp;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Choix {
    @Id
    @GeneratedValue
    long id;

    @Column(length=2048)
    String enonce;
//	boolean multiple;

    // les reponses des utilisateurs
    @OneToMany(mappedBy="choix")
    Collection<Reponse> reponse;

    public Choix (String resume){
        this.enonce = resume;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEnonce() {
        return enonce;
    }
    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public void addReponse(Reponse reponse) {
        this.reponse.add(reponse);
    }

    public Collection<Reponse> getReponses() {
        return this.reponse;
    }
}

