package fr.istic.sir.rest;

import tp.Participant;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import java.util.List;

/**
 * @author guillaume
 */
@Path("participant")
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
