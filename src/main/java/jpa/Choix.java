package jpa;

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

    // les reponses possibles pour ce choix
    @OneToMany(mappedBy="choixConcerne")
    Collection<ReponsePossible> reponsesPossibles;

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
    //	public boolean isMultiple() {
//		return multiple;
//	}
//	public void setMultiple(boolean multiple) {
//		this.multiple = multiple;
//	}
//	public Collection<Sondage> getQuestionnaires() {
//		return sondages;
//	}
//	public void setQuestionnaires(Collection<Sondage> questionnaires) {
//		this.sondages = questionnaires;
//	}
    public Collection<ReponsePossible> getReponsepossibles() {
        return reponsesPossibles;
    }
    public void setReponsepossibles(Collection<ReponsePossible> reponsepossibles) {
        this.reponsesPossibles = reponsepossibles;
    }
}
