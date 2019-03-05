package jpa;

import java.util.Collection;

public interface Sondage {

    public long getId();

    public void setId(long id);

    public String getTitre();

    public void setTitre(String titre);

    public String getTheme();

    public void setTheme(String theme);

    public Collection<Choix> getChoix();

    public void setChoix(Collection<Choix> choix);

    public Collection<ReponsePossible> getReponses();

}
