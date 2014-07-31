package amg.net.pl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import amg.net.pl.model.IStudentManager;
import amg.net.pl.model.JDBCStudentmanager;
import amg.net.pl.pojo.Adress;
import amg.net.pl.pojo.Division;

public class MysqlTest {

	IStudentManager jdbc;
	@Test
	public void test() throws SQLException {

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dupa", "root", "root")) {
			ResultSet rs = connection.createStatement().executeQuery(
					"SELECT * FROM STUDENTS2");
			
			while (rs.next()) {
				String user = rs.getString("ID");

				System.out.println("ID: " + user);
			}
		}
	}

	@Test
	public void jdbcTest() throws Exception {
		jdbc=new JDBCStudentmanager();
		Division division=new Division("Division");
		Adress adress=new Adress("street", "possesion_number", "flat_number");
		
		jdbc.deleteStudent("123");
		jdbc.create(division, adress, "123", "sdasd", "123");
		jdbc.editStudent("123", division, adress, "update", "update");
		System.out.println(jdbc.getByPesel("123").getPesel());
		
	}
}
