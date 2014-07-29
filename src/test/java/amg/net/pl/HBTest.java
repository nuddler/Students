package amg.net.pl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import amg.net.pl.model.Student;

public class HBTest {

	
	@Test
	public void testHB(){
		
		EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("manager1");
		EntityManager em=emFactory.createEntityManager();
		
//		Student newStudent=new Student("test","test","11111111111",null,null);
//		newStudent.setId(1L);
		
//		em.getTransaction().begin();
//		em.persist(newStudent);
//		em.getTransaction().commit();
		
	}
}
