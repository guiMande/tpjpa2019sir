package jpa;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class SondageTypeListeChoix implements Sondage {
    public SondageTypeListeChoix() {

    }

    public SondageTypeListeChoix(String titre, String theme) {
        this.titre = titre;
        this.theme = theme;
    }

    @Id
    @GeneratedValue
    long id;
    String titre, theme;

    // Les choix a faire figurer dans ce sondage. Un choix = une liste de reponses pour l'utilisateur
    @ManyToMany
    @JoinTable(name="SondageTypeListe_Choix")
    Collection<Choix> choix;

    public long getId() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setId(long id) {
        // TODO Auto-generated method stub

    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Collection<Choix> getChoix() {
        return this.choix;
    }

    // Dans le cas ou on cree un sondage
    public void setChoix(Collection<Choix> choixProposes) {
        this.choix = choixProposes;
    }

    public Collection<Choix> getChoix(Collection<Choix> choixProposes) {
        return this.choix ;
    }

    public Collection<ReponsePossible> getReponses() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setReponses(Collection<ReponsePossible> reponses) {
        // TODO Auto-generated method stub
    }

}
