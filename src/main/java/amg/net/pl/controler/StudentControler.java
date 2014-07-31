package amg.net.pl.controler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amg.net.pl.model.IDivisionManager;
import amg.net.pl.model.IStudentManager;
import amg.net.pl.pojo.Adress;
import amg.net.pl.pojo.Division;
import amg.net.pl.pojo.Student;

@Controller
public class StudentControler {

	private static final Logger logger = LogManager.getLogger(StudentControler.class);

	@Autowired
	private IDivisionManager divisionManager;
	@Autowired
	private IStudentManager studentManager;

	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String homePage(Model model) {
		return "index";
	}

	@RequestMapping(value = "/editjsp", method = RequestMethod.POST)
	public String editJsp(HttpServletRequest request, Model model) {

		String pesel = request.getParameter("pesel");
		model.addAttribute("editStudent", studentManager.getByPesel(pesel));
		model.addAttribute("pesel", pesel);
		model.addAttribute("divisions",divisionManager.getAll());
		
		return "edit";
	}

	@RequestMapping(value = "/editStudent", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute("editStudent") Student editStudent) {

		String pesel = editStudent.getPesel();
		
		if (logger.isDebugEnabled()) {
			logger.debug("Edit controller started (PESEL:"+pesel+")");
		}
		
		String divisionName = editStudent.getDivision().getName();
		Division division = divisionManager.getById(divisionName);

		Adress adress = new Adress(editStudent.getHomeAdress().getStreet(), editStudent
				.getHomeAdress().getPosesionNumber(), editStudent.getHomeAdress()
				.getFlatNumber());

		String vorname = editStudent.getVorName();
		String lastName = editStudent.getLastname();
		
		studentManager.editStudent(pesel, division, adress, vorname, lastName);
		return "index";
	}
	
	@RequestMapping(value="/addStudent", method = RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("divisions", divisionManager.getAll().values());
		model.addAttribute("newStudent",new Student());
		return "add";
	}
	//JSP
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String createStudent(@ModelAttribute("newStudent") @Valid Student newstudent, BindingResult result,Model model) {
		
		if(result.hasErrors()){
			
			if (logger.isDebugEnabled()) {
				logger.debug("ERORR");
			}
			model.addAttribute("divisions", divisionManager.getAll().values());
			return "add";
		}
		
		String divisionName = newstudent.getDivision().getName();
		
		if (logger.isDebugEnabled()) {
			logger.debug("create - before getting division");
		}
		
		Division division = divisionManager.getById(divisionName);
		
		if (logger.isDebugEnabled()) {
			logger.debug("create - "+division);
		}
		
		Adress adress = new Adress(newstudent.getHomeAdress().getStreet(),
				newstudent.getHomeAdress().getPosesionNumber(),
				newstudent.getHomeAdress().getFlatNumber());

		
		String vorname = newstudent.getVorName();
		String lastName = newstudent.getLastname();
		String pesel = newstudent.getPesel();

		studentManager.create(division, adress, vorname, lastName, pesel);

		return "index";
	}

	@RequestMapping("/deleteStudent")
	public String deleteStudent(HttpServletRequest request,Model model) {
		String pesel = request.getParameter("pesel");
		studentManager.deleteStudent(pesel);
		return "redirect:/";
	}

	@RequestMapping(value = "/listStudents", method = RequestMethod.GET)
	public String listStudents(Model model) {

		model.addAttribute("map", studentManager.getAll());
		return "studentlist";
	}


	@RequestMapping("/error")
	public String error(Model model) {
		model.addAttribute("error",true);
		return "redirect:/addStudent";
	}
}
