package servlet;

import fr.istic.sir.rest.Constantes;
import tp.Choix;
import tp.Commentaire;
import tp.Reunion;
import tp.Sondage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guillaume
 */
@WebServlet(name="addsurvey",
        urlPatterns={"/AddSurvey"})
public class AddSurvey extends HttpServlet {

    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction tx;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
        factory = Persistence.createEntityManagerFactory("localhost");
        em = factory.createEntityManager();
        tx = em.getTransaction();
    }

    @Override
    public void destroy() {
        em.close();
        super.destroy();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tx.begin();
            //Envoie en base
            Choix choix = new Choix(request.getParameter(Constantes.date));

            Commentaire commentaire = new Commentaire(request.getParameter("commentaire"));

            Reunion reunion = new Reunion(request.getParameter("titre"), request.getParameter("resume"));

            Sondage sondage = new Sondage();
            sondage.setTitre(request.getParameter("titre"));
            sondage.setChoix(choix);
            sondage.setReunion(reunion);
            sondage.setCommentaire(commentaire);
            em.persist(commentaire);
            em.persist(reunion);
            em.persist(choix);
            em.persist(sondage);
            tx.commit();
        }catch (Exception e){}

        PrintWriter out2 = response.getWriter();
        out2.println("<HTML>\n<BODY>\n" +
                "<a href='/'>Retour</a><br><H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Titre: "
                + request.getParameter("titre") + "\n" +
                " <LI>resume: "
                + request.getParameter("resume") + "\n" +
                " <LI>date: "
                + request.getParameter("date") + "\n" +
                " <LI>Commentaire: "
                + request.getParameter("commentaire") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }
}
