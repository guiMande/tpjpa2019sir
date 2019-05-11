package fr.istic.sir.rest;

import tp.Participant;


import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author guillaume
 */
@Path("/participant")
public class ParticipantService extends AbstractService<Participant>{

    private EntityManager em;

    public ParticipantService() {
        super(Participant.class);
    }

    @GET
    @Path("{id}")
    @Produces({ "application/json" })
    public Participant find(@PathParam("id") Integer id) {
        return (super.find(id));
    }

    @GET
    @Produces({ "application/json" })
    public List<Participant> findAll() {
        return super.findAll();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public Response postParticipant(Participant participant){
        return super.create(participant);
    }

    @DELETE @Path("delete/{id}")
    @Produces({"application/json"})
    public List<Participant> delete(@PathParam("id") int Id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constantes.connexion);
        em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx = em.getTransaction();
        tx.begin();
        TypedQuery<Participant> participant = em.createQuery("DELETE FROM Participant s WHERE s.id = " + Id, Participant.class);

        List<Participant> result = participant.getResultList();

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
