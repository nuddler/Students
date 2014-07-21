package amg.net.pl.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import amg.net.pl.model.Adress;
import amg.net.pl.model.Division;
import amg.net.pl.model.IDivisionManager;
import amg.net.pl.model.IStudentManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/test-context.xml" })
public class AddingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDivisionManager divisionManager;
	@Autowired
	private IStudentManager studentManager;
	
	private static final Logger logger = LogManager
			.getLogger(AddingServlet.class);
	
	
	public AddingServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (logger.isDebugEnabled()) {
			logger.debug(request.getParameter("divisionName"));
		}
		Division division=divisionManager.getById(request.getParameter("divisionName"));
		Adress adress=new Adress(request.getParameter("street"), request.getParameter("posesionNumber"), request.getParameter("flatNumber"));
		String vorname=request.getParameter("vorName");
		String lastName=request.getParameter("lastName");
		String pesel=request.getParameter("pesel");
		
		studentManager.create(division, adress, vorname, lastName, pesel);
		
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/index.jsp");
		reqDisp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
