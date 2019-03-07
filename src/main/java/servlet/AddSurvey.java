package servlet;

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

   /* public void creaReu(Reunion reunion){
        em.persist(reunion);
    }*/

    public void creaSon(Sondage sondage){
        em.persist(sondage);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tx.begin();
            //Envoie en base
            String titre = request.getParameter("titre");
            String resume = request.getParameter("resume");

            Sondage sondage = new Sondage(titre, resume);
            em.persist(sondage.getReunion());
            creaSon(sondage);

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
                "</UL>\n" +
                "</BODY></HTML>");
    }
}
