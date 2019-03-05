package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Joinfetch {

    private EntityManager manager;

    public Joinfetch(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("withoutcreate");
        EntityManager manager = factory.createEntityManager();
        Joinfetch test = new Joinfetch(manager);


        TypedQuery<Departement> q = test.manager.createQuery("select distinct d from Departement d join fetch d.employees e",Departement.class);
        long start = System.currentTimeMillis();
        List<Departement> res = q.getResultList();

        for (Departement d : res){
            for (Participant e : d.getEmployees()){
                e.getFirstName();
            }
        }

        long end = System.currentTimeMillis();
        long duree = end - start;
        System.err.println("temps d'exec = " +  duree);

        // TODO persist entity


        // TODO run request

        System.out.println(".. done");
    }

}