package fr.istic.sir.rest;

import tp.Participant;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("participant")
public class ParticipantService extends AbstractService<Participant>{

    private EntityManager em;

    public ParticipantService() {
        super(Participant.class);
    }

    @DELETE
    @Path("remove/{id}")
    public Response remove(@PathParam("id") Integer id) {
        return super.remove(super.find(id));
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