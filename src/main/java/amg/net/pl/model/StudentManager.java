package amg.net.pl.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class StudentManager implements IStudentManager {

	private static final Logger logger = LogManager
			.getLogger(StudentManager.class);

	public StudentManager() {
		students = new HashMap<String, Student>();
	}

	Map<String, Student> students;

	public void deleteStudent(String pesel) {
		if (!students.containsKey(pesel)) {
			logger.error("Student with PESEL:" + pesel + " doesn't exist");
			throw new IllegalArgumentException();
		}
		students.remove(pesel);
	}

	public Student getByPesel(String pesel) {
		if (!students.containsKey(pesel)) {
			logger.error("Student with PESEL:" + pesel + " doesn't exist");
			throw new IllegalArgumentException();
		}
		return students.get(pesel);
	}

	public void create(Division division, Adress adress, String vorname,
			String lastName, String pesel) {
		if (logger.isDebugEnabled()) {
			logger.debug("Starting create student");
		}
		if (division == null || adress == null || vorname == null
				|| lastName == null || pesel == null) {
			logger.error("Student params error", new RuntimeException());
		}
		Student newStudent = new Student(vorname, lastName, pesel, adress,
				division);
		students.put(pesel, newStudent);
		if (logger.isDebugEnabled()) {
			logger.debug("Student created and inserted into base");
		}
	}

	public Map<String, Student> getAll() {

		return students;
	}

	public void editStudent(String pesel, Division division, Adress adress,
			String vorname, String lastName) {
		if (logger.isDebugEnabled()) {
			logger.debug("Starting edit student with pesel:"+pesel);
		}
		students.get(pesel).setVorName(vorname);
		students.get(pesel).setLastname(lastName);
		students.get(pesel).setHomeAdress(adress);
		students.get(pesel).setDivision(division);
	}
}
