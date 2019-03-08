package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author guillaume
 */
public class N1Select {

    private EntityManager manager;

    public N1Select(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("withoutcreate");
        EntityManager manager = factory.createEntityManager();
        N1Select test = new N1Select(manager);

/*
        TypedQuery<Departement> q = test.manager.createQuery("select d from Departement d",Departement.class);
        long start = System.currentTimeMillis();
        ListSondage<Departement> res = q.getResultList();


        for (Departement d : res){
            for (Participant e : d.getEmployees()){
                e.getFirstName();
            }
        }

        long end = System.currentTimeMillis();
        long duree = end - start;
        System.err.println("temps d'exec = " +  duree);*/

        // TODO persist entity


        // TODO run request

        System.out.println(".. done");
    }

}
