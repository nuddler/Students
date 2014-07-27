package amg.net.pl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCStudentmanager implements IStudentManager {

	private DataSource dataSource;
	
	private static final Logger logger = LogManager
			.getLogger(JDBCStudentmanager.class);

	public JDBCStudentmanager() {
	}

	@Override
	public void deleteStudent(String pesel) {

		try (Connection connection = getDataSource().getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("delete from students2 where PESEL = ?");
			statement.setString(1, pesel);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getByPesel(String pesel) {
		try (Connection connection = getDataSource().getConnection()) {

			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM STUDENTS2 where PESEL=?");
			statement.setString(1, pesel);
			ResultSet rs = statement.executeQuery();

			rs.next();
			String vorName = rs.getString("VOR_NAME");
			String lastName = rs.getString("LAST_NAME");
			String street = rs.getString("HOME_ADRESS_street");
			String flatNumber = rs.getString("HOME_ADRESS_FLAT");
			String possesionNumber = rs.getString("HOME_ADRESS_HOME");
			String divisionName = rs.getString("DIVISION");
			Adress adress = new Adress(street, possesionNumber, flatNumber);
			Division division = new Division(divisionName);

			Student student = new Student(vorName, lastName, pesel, adress,
					division);

			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void create(Division division, Adress adress, String vorname,
			String lastName, String pesel) {

		try (Connection connection = getDataSource().getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO STUDENTS2 (`VOR_NAME`,`LAST_NAME`,`PESEL`,`HOME_ADRESS_street`,"
							+ "`HOME_ADRESS_FLAT`,`HOME_ADRESS_HOME`,`DIVISION`)VALUES(?,?,?,?,?,?,?)");

			statement.setString(1, vorname);
			statement.setString(2, lastName);
			statement.setString(3, pesel);
			statement.setString(4, adress.getFlatNumber());
			statement.setString(5, adress.getPosesionNumber());
			statement.setString(6, adress.getStreet());
			statement.setString(7, division.getName());

			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Student> getAll() {

		Map<String, Student> studentsMap = new HashMap<String, Student>();
		try (Connection connection = getDataSource().getConnection()) {
			ResultSet rs = connection.createStatement().executeQuery(
					"SELECT * FROM STUDENTS2");

			while (rs.next()) {
				String vorName = rs.getString("VOR_NAME");
				String lastName = rs.getString("LAST_NAME");
				String pesel = rs.getString("PESEL");
				String street = rs.getString("HOME_ADRESS_street");
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

		try (Connection connection = getDataSource().getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE students2 SET VOR_NAME =?,LAST_NAME = ?,HOME_ADRESS_street = ?,"
							+ "HOME_ADRESS_FLAT = ?,HOME_ADRESS_HOME = ?,DIVISION = ? WHERE PESEL = ?");
			statement.setString(1, vorname);
			statement.setString(2, lastName);
			statement.setString(3, adress.getFlatNumber());
			statement.setString(4, adress.getPosesionNumber());
			statement.setString(5, adress.getStreet());
			statement.setString(6, division.getName());
			statement.setString(7, pesel);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
