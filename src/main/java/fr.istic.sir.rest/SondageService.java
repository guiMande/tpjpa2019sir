package fr.istic.sir.rest;

import tp.Participant;
import tp.Sondage;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author guillaume
 */
@Path("/sondage")
public class SondageService extends AbstractService<Sondage>{

    private EntityManager em;

    public SondageService() {
        super(Sondage.class);
    }

	@GET
	@Path("{id}")
	@Produces({ "application/json" })
	public Sondage find(@PathParam("id") Integer id) {
		return (super.find(id));
	}


    @GET
    @Produces({ "application/json" })
    public List<Sondage> findAll() {
        return super.findAll();
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public Response postParticipant(Sondage sondage){
        return super.create(sondage);
    }

    @DELETE @Path("delete/{id}")
    @Produces({"application/json"})
    public List<Sondage> delete(@PathParam("id") int Id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constantes.connexion);
        em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx = em.getTransaction();
        tx.begin();
        TypedQuery<Sondage> sondage = em.createQuery("DELETE FROM Sondage s WHERE s.id = " + Id, Sondage.class);

        List<Sondage> result = sondage.getResultList();

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
