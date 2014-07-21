package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amg.net.pl.model.Adress;
import amg.net.pl.model.Division;
import amg.net.pl.model.DivisionManager;
import amg.net.pl.model.IDivisionManager;
import amg.net.pl.model.IStudentManager;
import amg.net.pl.model.StudentManager;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public StudentServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		IStudentManager studentManager=StudentManager.getInstance();
		IDivisionManager divisionManager=DivisionManager.getInstance();
		
		Division division=divisionManager.getById(request.getParameter("divisionName"));
		Adress adress=new Adress(request.getParameter("street"), request.getParameter("posesionNumber"), request.getParameter("flatNumber"));
		String vorname=request.getParameter("vorName");
		String lastName=request.getParameter("lastName");
		String pesel=request.getParameter("pesel");
		
		studentManager.create(division, adress, vorname, lastName, pesel);
		
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/index.jsp");
		reqDisp.forward(request, response);
		//redirect
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
