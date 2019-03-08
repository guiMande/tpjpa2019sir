package servlet;

import tp.Sondage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="surveylist",
        urlPatterns={"/SurveyList"})
public class SurveyList extends HttpServlet {

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

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        tx.begin();
        try {
            PrintWriter out = response.getWriter();
            TypedQuery<Sondage> query = em.createQuery("SELECT c FROM Sondage c", Sondage.class);

            List<Sondage> sondages = query.getResultList();

            out.println("<HTML>\n<BODY><a href='/'>Retour</a>\n" +
                    "<H1>Sondages disponibles : </H1>\n");
            for (Sondage sondage : sondages) {
                out.println("<UL>\n" +
                        " <LI>Titre: "  + "<a href=\"/AnswerSurvey?id=" + sondage.getId() + "\">" + sondage.getTitre()  + "</a>\n"
                        + " <LI>Resume: " + sondage.getReunion().getResume()+ "\n"
                        + "<LI>Commentaire: " + sondage.getCommentaire().getText() + "\n"
                        + "</UL>\n");
            }

            out.println("</BODY></HTML>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
    }

    public List<Sondage> getSondages(){
        TypedQuery<Sondage> sondages = em.createQuery("SELECT c FROM Sondage c", Sondage.class);
        List<Sondage> results = sondages.getResultList();
        return results;
    }
}
