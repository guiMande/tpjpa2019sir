package jpa;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

@Entity
public class Participant {
    String firstName, lastName;
    int id;
    Date datenaissance;
    private Departement departement;

    Collection<Reponses> reponsesChoisies;

    public Participant(){}

    public Participant(String name, String lastName, Departement departement) {
        this.firstName = name;
        this.lastName = lastName;
        this.departement = departement;
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
                datenaissance.getTime()).atZone(
                ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = Instant.ofEpochMilli(
                System.currentTimeMillis()).
                atZone(ZoneId.systemDefault()).toLocalDate();
        return calculateAge( date1,date2
        );

    }

    @Column(length=1024, updatable=false, nullable=false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(length=1024, updatable=false, nullable=false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    @OneToMany(mappedBy="utilisateur")
    public Collection<Reponses> getReponses() {
        return reponsesChoisies;
    }

    public void setReponses(Collection<Reponses> reponsesChoisies) {
        this.reponsesChoisies = reponsesChoisies;
    }

    @ManyToOne
    public Departement getDepartment() {
        return departement;
    }

    public void setDepartment(Departement department) {
        this.departement = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + this.id + ", firstname=" + this.firstName + ", department="
                + departement.getName() + "]";
    }

}
