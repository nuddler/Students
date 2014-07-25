package amg.net.pl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class JDBCStudentmanager implements IStudentManager {

	DataSource dataSource;

	public JDBCStudentmanager() {
		// this.dataSource=
	}

	@Override
	public void deleteStudent(String pesel) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getByPesel(String pesel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Division division, Adress adress, String vorname,
			String lastName, String pesel) {

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dupa", "root", "root")) {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO STUDENTS2 VALUES(?,?,?,?,?,?,?,?)");

			statement.setString(2, vorname);
			statement.setString(3, lastName);
			statement.setString(4, pesel);
			statement.setString(5, adress.getFlatNumber());
			statement.setString(6, adress.getPosesionNumber());
			statement.setString(7, adress.getStreet());
			statement.setString(8, division.getName());
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Student> getAll() {

		Map<String, Student> studentsMap = new HashMap<String, Student>();
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dupa", "root", "root")) {
			ResultSet rs = connection.createStatement().executeQuery(
					"SELECT * FROM STUDENTS2");

			while (rs.next()) {
				String vorName = rs.getString("VOR_NAME");
				String lastName = rs.getString("LAST_NAME");
				String street = rs.getString("HOME_ADRESS_street");
				String pesel = rs.getString("PESEL");
				String flatNumber = rs.getString("HOME_ADRESS_FLAT");
				String possesionNumber = rs.getString("HOME_ADRESS_HOME");
				String divisionName = rs.getString("DIVISION");
				Adress adress = new Adress(street, possesionNumber, flatNumber);
				Division division = new Division(divisionName);
				Student student = new Student(vorName, lastName, pesel, adress,
						division);
				studentsMap.put(pesel, student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentsMap;

	}

	@Override
	public void editStudent(String pesel, Division division, Adress adress,
			String vorname, String lastName) {
		// TODO Auto-generated method stub

	}
}
