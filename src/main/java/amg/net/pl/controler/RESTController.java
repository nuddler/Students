package amg.net.pl.controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import amg.net.pl.model.IDivisionManager;
import amg.net.pl.model.IStudentManager;
import amg.net.pl.pojo.Adress;
import amg.net.pl.pojo.Division;
import amg.net.pl.pojo.Student;

@RestController
@RequestMapping("/rest")
public class RESTController {

	@Autowired
	private IDivisionManager divisionManager;
	@Autowired
	private IStudentManager studentManager;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public Map<String, Student> showAllstudent() {
		studentManager.getAll();
		return studentManager.getAll();
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String createStudent(@RequestBody Student newStudent) {

		String divisionName = newStudent.getDivision().getName();

		Division division = divisionManager.getById(divisionName);

		Adress adress = new Adress(newStudent.getHomeAdress().getStreet(),
				newStudent.getHomeAdress().getPosesionNumber(), newStudent
						.getHomeAdress().getFlatNumber());

		String vorname = newStudent.getVorName();
		String lastName = newStudent.getLastname();
		String pesel = newStudent.getPesel();

		studentManager.create(division, adress, vorname, lastName, pesel);

		return pesel;
	}

	@RequestMapping(value = "/students/{pesel}", method = RequestMethod.GET)
	public Student showStudent(@PathVariable("pesel") String pesel) {
		Student newStudent = studentManager.getByPesel(pesel);
		return newStudent;
	}

	@RequestMapping(value = "/students/{pesel}", method = RequestMethod.PUT)
	public String updateStudent(@ModelAttribute("student") Student student,
			@PathVariable("pesel") String pesel) {

		String divisionName = student.getDivision().getName();

		Division division = divisionManager.getById(divisionName);

		Adress adress = new Adress(student.getHomeAdress().getStreet(), student
				.getHomeAdress().getPosesionNumber(), student.getHomeAdress()
				.getFlatNumber());

		String vorname = student.getVorName();
		String lastName = student.getLastname();

		studentManager.editStudent(pesel, division, adress, vorname, lastName);

		return pesel;
	}

	@RequestMapping(value = "/students/{pesel}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable("pesel") String pesel) {
		studentManager.deleteStudent(pesel);
		return "OK!";
	}

}
