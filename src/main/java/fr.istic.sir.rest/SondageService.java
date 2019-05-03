package fr.istic.sir.rest;

import tp.Sondage;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
        /*EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constantes.connexion);
        em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx = em.getTransaction();
        tx.begin();
        TypedQuery<Sondage> sondage = em.createQuery("SELECT c FROM Sondage c", Sondage.class);

        List<Sondage> result = sondage.getResultList();

        tx.commit();
        return result;*/
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
