package jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private String id;

    @OneToOne
    Reunion reunion;

    Date date;

    @Enumerated(EnumType.STRING)
    Choix choix;

    public Question(){}

    public Question(Reunion reunion){
        this.reunion = reunion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Choix getChoix() {
        return choix;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setChoix(Choix choix) {
        this.choix = choix;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
