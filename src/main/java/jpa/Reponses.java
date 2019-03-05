package jpa;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Reponses {
    @Id
    @GeneratedValue
    long id;

    @Temporal(TemporalType.DATE)
    Date datereponse;

    @OneToMany
    Collection<Participant> utilisateur;

    @ManyToOne
    ReponsePossible responsePossible;

    public Reponses() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatereponse() {
        return datereponse;
    }

    public void setDatereponse(Date datereponse) {
        this.datereponse = datereponse;
    }

    public ReponsePossible getReponsequestion() {
        return responsePossible;
    }

    public void setReponsequestion(ReponsePossible reponsePossible) {
        this.responsePossible = reponsePossible;
    }
}
