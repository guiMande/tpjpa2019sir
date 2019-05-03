package tp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author guillaume
 */
@Entity
public class Participant {

    @Id
    @GeneratedValue
    int id;
    String prenom, nom;

    Date dateNaissance;

    @OneToMany(mappedBy = "participant")
    Collection<Reponse> reponses;

    public Participant(){}

    public Participant(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    @Column(length=1024, updatable=false, nullable=false)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(length=1024, updatable=false, nullable=false)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Collection<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(Collection<Reponse> reponses) {
        this.reponses = reponses;
    }
}
