package tp;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;

@Entity
public class Choix {
    @Id
    @GeneratedValue
    long id;

    @Column(length=2048)
    String enonce;

    @OneToOne(mappedBy="choix")
    @JsonBackReference
    Reponse reponse;

    public Choix(){}

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
        this.reponse = reponse;
    }

    public Reponse getReponse() {
        return this.reponse;
    }
}

