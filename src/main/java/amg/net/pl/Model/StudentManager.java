package amg.net.pl.Model;

import java.util.HashMap;
import java.util.Map;

public class StudentManager implements IStudentManager {

	private static IStudentManager instance;

	private StudentManager() {
		students=new HashMap<String, Student>();
		}

	Map<String, Student> students;

	public void deleteStudent(String pesel) {
		students.remove(pesel);
	}

	public void editStudent(String pesel) {
		// TODO Auto-generated method stub

	}

	public Student getByPesel(String pesel) {
		return students.get(pesel);
	}

	public void create(Division division, Adress adress, String vorname,
			String lastName, String Pesel) {
		Student newStudent = new Student(vorname, lastName, Pesel, adress,
				division);
		students.put(Pesel, newStudent);
	}

	public static IStudentManager getInstance() {
		if (instance == null) {
			instance = new StudentManager();
		}
		return instance;
	}
}
