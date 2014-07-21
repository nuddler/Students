package amg.net.pl.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentManager implements IStudentManager {

	private static IStudentManager instance;
	private static final Logger logger = LogManager
			.getLogger(StudentManager.class);

	private StudentManager() {
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

	public static IStudentManager getInstance() {
		
		if (instance == null) {
			instance = new StudentManager();
		}
		return instance;
	}

	public Map<String,Student> getAll() {
		
		return students;
	}
}
