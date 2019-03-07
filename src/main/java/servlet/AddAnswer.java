package servlet;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.sir.rest.Constantes;
import tp.Choix;
import tp.Reponse;

/**
 * Enregistre la reponse ou les reponses d'un utilisateur a un sondage
 * @author mathi
 *
 */
@WebServlet(name="addAnswer",
        urlPatterns={"/AddAnswer"})
public class AddAnswer extends HttpServlet {

    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction tx;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String userFirstName = request.getParameter(Constantes.firstName);
        String userLastName = request.getParameter(Constantes.lastName);
        String[] reponses = request.getParameterValues(Constantes.choix);
        for (String string : reponses) {
            factory = Persistence.createEntityManagerFactory(Constantes.connexion);
            em = factory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int choixId = Integer.parseInt(string);
            TypedQuery<Choix> query;
            query = em.createQuery("SELECT c FROM Choix c WHERE c.id = " + choixId , Choix.class);
            Reponse reponse = new Reponse(userFirstName, userLastName);
            Choix choix = query.getSingleResult();
            reponse.setChoix(choix);
            em.persist(reponse);
            tx.commit();
        }
    }
}
