package jpa;

import tp.Choix;
import tp.Participant;
import tp.Sondage;

import javax.persistence.*;
import java.util.List;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("localhost");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		tx.commit();
		test.listEmployees();
		manager.close();
		System.out.println(".. done");
		manager.close();
	}


	private void listEmployees() {
		List<Participant> resultList = manager.createQuery("Select a From Participant a", Participant.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Participant next : resultList) {
			System.out.println("next employee: " + next);
		}
	}
}
