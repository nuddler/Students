package amg.net.pl.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import amg.net.pl.pojo.Adress;
import amg.net.pl.pojo.Division;
import amg.net.pl.pojo.Student;

@Component
@Transactional
public class StudentManagerJPAImpl implements IStudentManager {

	private static final Logger logger = LogManager
			.getLogger(StudentManagerJPAImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public void deleteStudent(String pesel) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start deleting student with pesel: " + pesel);
		}

		Student student = getByPesel(pesel);
		em.remove(student);

		if (logger.isDebugEnabled()) {
			logger.debug("Student was removed (PESEL: " + pesel + ")");
		}
	}

	@Override
	public Student getByPesel(String pesel) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start finding student with pesel: " + pesel);
		}
		Student student = em.find(Student.class, new Long(pesel));

		if (student == null) {
			logger.warn("Student with pesel " + pesel + " doesn't exist");
			 throw new RuntimeException();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Student was find (" + student + ")");
		}
		return student;
	}

	@Override
	public void create(Division division, Adress adress, String vorname,
			String lastName, String pesel) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start creating student -pesel:"+pesel);
		}
		em.merge(division);
		if (logger.isDebugEnabled()) {
			logger.debug("Creating - division(after merge)"+division);
		}
		Student newStudent = new Student(vorname, lastName, pesel, adress,
				division);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("Student was created -pesel:"+newStudent.getId());
		}
		em.persist(newStudent);
	}

	@Override
	public Map<String, Student> getAll() {
		
		List<Student> resultList = em.createQuery("select a from Student a").getResultList();
		
		Map<String,Student> map=new HashMap<String, Student>();
		
		for (Student student : resultList) {
			map.put(student.getPesel(), student);
		}
		return map;
	}

	@Override
	public void editStudent(String pesel, Division division, Adress adress,
			String vorname, String lastName) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start editing student with PESEL: "+pesel);
		}
		Student student=getByPesel(pesel);
		student.setDivision(division);
		student.setHomeAdress(adress);
		student.setVorName(vorname);
		student.setLastname(lastName);
		em.persist(student);
		
		if (logger.isDebugEnabled()) {
			logger.debug("Student was edited succesfully");
		}
	}
}
