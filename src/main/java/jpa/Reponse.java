package jpa;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Reponse {
    @Id
    @GeneratedValue
    long id;

    @Temporal(TemporalType.DATE)
    Date datereponse;

    @OneToMany
    Collection<Participant> participants;

    @Enumerated(EnumType.STRING)
    Choix choix;

    public Reponse() {
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

    public Collection<Participant> getParticipants() {
        return participants;
    }
}
