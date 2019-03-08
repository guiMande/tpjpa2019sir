package servlet;

import tp.Choix;
import tp.Sondage;
import fr.istic.sir.rest.Constantes;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author guillaume
 */
@WebServlet(name="answerSurvey",
        urlPatterns={"/ChoixSondage"})
public class ChoixSondage extends HttpServlet {

    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction tx;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Sondage sondageChoisi = getSondage(request);

        PrintWriter out = response.getWriter();

        out.println("<HTML><head><meta charset=\"utf-8\"/></head>\n<BODY>\n"
                + "<FORM Method=\"POST\" Action=\"/AjoutReponse\">\r\n" +
                "Nom :         <INPUT type=text size=20 name=lastName><BR>\r\n" +
                "Prénom :     <INPUT type=text size=20 name=firstName><BR>\r\n"
                + sondageChoisi.getTitre());

        Choix choix = sondageChoisi.getChoix();
        out.println(" <select name=\"reponse\">" +
                "<option value=\"oui\">oui</option>\n" +
                "<option value=\"non\">non</option>\n " +
                "</select>" );

                out.println(
                "<input type=\"checkbox\" name=\"choice\" value=\"" + choix.getId() + "\" />" +  choix.getEnonce() + "<br />");

                out.println(
                "<br><INPUT type=submit value=Répondre></FORM>\r\n");
    }

    public Sondage getSondage(HttpServletRequest request) {
        factory = Persistence.createEntityManagerFactory(Constantes.connexion);
        em = factory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        String surveyId = request.getParameter("id");
        TypedQuery<Sondage> query;
        Sondage sondageChoisi = null;
        query = em.createQuery("SELECT c FROM Sondage c WHERE c.id = " + surveyId, Sondage.class);
        sondageChoisi = query.getSingleResult();
        return sondageChoisi;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

    }
}
