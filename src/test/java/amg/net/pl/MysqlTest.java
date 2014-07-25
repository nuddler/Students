package amg.net.pl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlTest {

	@Test
	public void test() throws SQLException {

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dupa", "root", "root")) {
			ResultSet rs = connection.createStatement().executeQuery(
					"SELECT * FROM ADRESS");
			
			while (rs.next()) {
				String user = rs.getString("ID");
				String website = rs.getString("STREET");
				String summary = rs.getString("POSESION_NUMBER");
				String comment = rs.getString("FLAT_NUMBER");

				System.out.println("ID: " + user);
				System.out.println("STREET: " + website);
				System.out.println("POSESION_NUMBER: " + summary);
				System.out.println("FLAT_NUMBER: " + comment);
			}
		}
	}

}
