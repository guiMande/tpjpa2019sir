package servlet;

import tp.Participant;

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
@WebServlet(name="userinfo",
        urlPatterns={"/InfoUtilisateur"})
public class InfoUtilisateur extends HttpServlet {

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
            Participant participant = new Participant();
            participant.setPrenom(request.getParameter("firstname"));
            participant.setNom(request.getParameter("lastname"));
            participant.setDateNaissance(format.parse(request.getParameter("date")));
            em.persist(participant);
            tx.commit();
        } catch (Exception e) {}

        PrintWriter out = response.getWriter();
        out.println("<HTML>\n<BODY>\n" +
                "<a href='/'>Retour</a><br><H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom: "
                + request.getParameter("lastname") + "\n" +
                " <LI>Prenom: "
                + request.getParameter("firstname") + "\n" +
                " <LI>Age: "
                + request.getParameter("date") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }
}
