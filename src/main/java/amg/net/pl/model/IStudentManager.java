package amg.net.pl.model;

import java.util.Map;

import amg.net.pl.pojo.Adress;
import amg.net.pl.pojo.Division;
import amg.net.pl.pojo.Student;

public interface IStudentManager {
	
	public void deleteStudent(String pesel);
	public Student getByPesel(String pesel);
	public void create(Division division,Adress adress, String vorname, String lastName,String pesel);
	public Map<String, Student> getAll();
	public void editStudent(String pesel,Division division,Adress adress, String vorname, String lastName);
}
