package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amg.net.pl.model.IStudentManager;
import amg.net.pl.model.StudentManager;

public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloWorldServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		IStudentManager studentManager=StudentManager.getInstance();
				
		request.setAttribute("map",studentManager.getAll());
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/studentlist.jsp");
		reqDisp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
