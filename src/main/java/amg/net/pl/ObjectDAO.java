package amg.net.pl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class ObjectDAO {

	@PersistenceContext
	private EntityManager em;


	public void saveObjectA() {

		ObjectA newObjectA = new ObjectA();
		newObjectA.setName("nameA");
		em.persist(newObjectA);
	}
	
	public void saveObjectB() {

		ObjectB newObjectB = new ObjectB();
		newObjectB.setName("nameB");
		em.persist(newObjectB);
	}
}

