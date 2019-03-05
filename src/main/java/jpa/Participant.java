package jpa;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class Participant {

    @Id
    @GeneratedValue
    int id;
    String prenom, nom;
    Date dateNaissance;

    public Participant(){}

    public Participant(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    private  int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    @Transient
    public int getAge() {
        LocalDate date1 = Instant.ofEpochMilli(
                dateNaissance.getTime()).atZone(
                ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = Instant.ofEpochMilli(
                System.currentTimeMillis()).
                atZone(ZoneId.systemDefault()).toLocalDate();
        return calculateAge( date1,date2
        );

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

    @Id
    @GeneratedValue
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
}
