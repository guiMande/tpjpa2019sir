package servlet;

import jpa.Participant;
import jpa.Question;
import jpa.Reunion;

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
            System.out.println(format);

            Reunion reunion = new Reunion(titre, resume);
            Question question = new Question(reunion);


            tx.commit();
        }catch (Exception e){}
    }
}
