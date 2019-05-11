package fr.istic.sir.rest;

import tp.Reponse;
import tp.Sondage;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author guillaume
 */
@Path("/reponse")
public class ReponseService extends AbstractService<Reponse>{

    private EntityManager em;

    public ReponseService() {
        super(Reponse.class);
    }

    @GET
    @Path("{id}")
    @Produces({ "application/json" })
    public Reponse find(@PathParam("id") Integer id) {
        return (super.find(id));
    }

    @GET
    @Produces({ "application/json" })
    public List<Reponse> findAll() {
        return super.findAll();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public Response postParticipant(Reponse reponse){
        return super.create(reponse);
    }

    @DELETE @Path("delete/{id}")
    @Produces({"application/json"})
    public List<Reponse> delete(@PathParam("id") int Id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constantes.connexion);
        em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx = em.getTransaction();
        tx.begin();
        TypedQuery<Reponse> reponse = em.createQuery("DELETE FROM Reponse s WHERE s.id = " + Id, Reponse.class);

        List<Reponse> result = reponse.getResultList();

        tx.commit();
        return result;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    protected EntityManager getEntityManager() {
        em = EntitySingleton.getManager();
        return em;
    }
}
