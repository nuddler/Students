package amg.net.pl.Model;


public interface IStudentManager {
	
	public void deleteStudent(String pesel);
	public void editStudent(String pesel);
	public Student getByPesel(String pesel);
	public void create(Division division,Adress adress, String vorname, String lastName,String pesel);

}
