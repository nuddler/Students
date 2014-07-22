package amg.net.pl.controler;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amg.net.pl.model.Adress;
import amg.net.pl.model.Division;
import amg.net.pl.model.IDivisionManager;
import amg.net.pl.model.IStudentManager;

@Controller
public class StudentControler {

    private static final Logger logger = LogManager
			.getLogger(StudentControler.class);
    
	@Autowired
	private IDivisionManager divisionManager;
	@Autowired
	private IStudentManager studentManager;
	
	@RequestMapping(value="/editStudent", method=RequestMethod.POST)
	public String editStudent(HttpServletRequest request,Model model){
		
		String pesel=request.getParameter("pesel");
		if (logger.isDebugEnabled()) {
			logger.debug("PESEL:"+pesel);
		}
		Division division=divisionManager.getById(request.getParameter("divisionName"));
		Adress adress=new Adress(request.getParameter("street"), request.getParameter("posesionNumber"), request.getParameter("flatNumber"));
		String vorname=request.getParameter("vorName");
		String lastName=request.getParameter("lastName");
		
		studentManager.editStudent(pesel, division, adress, vorname, lastName);
		return "index";
	}
	
	@RequestMapping(value="/homePage", method=RequestMethod.GET)
	public String homePage(Model model) {
		return "index";	
	}
	
	@RequestMapping(value="/editjsp", method=RequestMethod.GET)
	public String editJsp(HttpServletRequest request,Model model) {
		
		String pesel=request.getParameter("pesel");
		model.addAttribute("student",studentManager.getByPesel(pesel));
		model.addAttribute("pesel",pesel);
		return "edit";	
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(Model model){
		model.addAttribute("divisions", divisionManager.getAll());
		return "add";
	}
	
	@RequestMapping(value="/createstudent", method=RequestMethod.POST)
	public String createStudent(HttpServletRequest request,
			Model model){

		Division division=divisionManager.getById(request.getParameter("divisionName"));
		Adress adress=new Adress(request.getParameter("street"), request.getParameter("posesionNumber"), request.getParameter("flatNumber"));
		String vorname=request.getParameter("vorName");
		String lastName=request.getParameter("lastName");
		String pesel=request.getParameter("pesel");
		
		studentManager.create(division, adress, vorname, lastName, pesel);
		
		return "index";
	}
	
	@RequestMapping(value="/listStudents", method=RequestMethod.GET)
	public String listStudents(Model model)  {

		model.addAttribute("map",studentManager.getAll());
		return "studentlist";
	}
}
