package amg.net.pl.model;

import java.util.Map;

public interface IStudentManager {
	
	public void deleteStudent(String pesel);
	public Student getByPesel(String pesel);
	public void create(Division division,Adress adress, String vorname, String lastName,String pesel);
	public Map<String, Student> getAll();
}
