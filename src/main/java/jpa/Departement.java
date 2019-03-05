package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departement {
    private long id;

    private String name;

    private List<Participant> employees = 	new ArrayList<Participant>();

    public Departement() {
        super();
    }

    public Departement(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    public List<Participant> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Participant> employees) {
        this.employees = employees;
    }
}
