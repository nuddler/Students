package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amg.net.pl.Model.Adress;
import amg.net.pl.Model.Division;
import amg.net.pl.Model.DivisionManager;
import amg.net.pl.Model.IDivisionManager;
import amg.net.pl.Model.IStudentManager;
import amg.net.pl.Model.StudentManager;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IStudentManager studentManager;
	private IDivisionManager divisionManager;

	public void initialize() {
		studentManager = StudentManager.getInstance();
		divisionManager = DivisionManager.getInstance();

		Adress tmpAdress = new Adress("ULICA ", "NUMER_DOMU",
				"NUMER_MIESZKANIA");
		Division tmpDivision = divisionManager.getById("FTIMS");
		studentManager.create(tmpDivision, tmpAdress, "Imie1", "Nazwisko1",
				"001");

		tmpAdress = new Adress("ULICA2", "NUMER_DOMU2", "NUMER_MIESZKANIA2");
		tmpDivision = divisionManager.getById("OIZ");
		studentManager.create(tmpDivision, tmpAdress, "Imie2", "Nazwisko2",
				"002");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorldServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		initialize();
		
		PrintWriter printer = response.getWriter();
		printer.println("HelloWorld111");
		Iterator it = studentManager.getAll().entrySet().iterator(); 
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			printer.println(pairs.getKey() + " = " + pairs.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
