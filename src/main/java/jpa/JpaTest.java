package jpa;

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
		test.createEmployees();
		tx.commit();
		test.listEmployees();
		manager.close();
		System.out.println(".. done");
		manager.close();
	}

	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Participant a", Participant.class).getResultList().size();
		if (numOfEmployees == 0) {

			manager.persist(new Participant("Jakab"," Gipsz"));
			manager.persist(new Participant("Captain", "Nemo"));

		}
	}

	private void listEmployees() {
		List<Participant> resultList = manager.createQuery("Select a From Participant a", Participant.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Participant next : resultList) {
			System.out.println("next employee: " + next);
		}
	}


}
