package amg.net.pl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import amg.net.pl.model.IDivisionManager;
import amg.net.pl.model.IStudentManager;
import amg.net.pl.pojo.Adress;
import amg.net.pl.pojo.Division;
import amg.net.pl.pojo.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/test-context.xml" })
public class StudentManagerTest {

	private static final Logger logger = LogManager
			.getLogger(StudentManagerTest.class);
	
	@Autowired
	public IStudentManager studentManager;
	@Autowired
	public IDivisionManager divisionManager;

	@Before
	public void before() {
		Adress tmpAdress = new Adress("ULICA ", "NUMER_DOMU", "NUMER_MIESZKANIA");
		Division tmpDivision = divisionManager.getById("FTIMS");
		studentManager.create(tmpDivision, tmpAdress, "Imie1", "Nazwisko1","000");
	}

	@Test
	public void testDeleteStudent() {
		studentManager.deleteStudent("000");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeDeleteStudent()  {
		studentManager.deleteStudent("00sdgfsdgiosh0");
	}
	
	@Test
	public void testEditStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		
		Student student= studentManager.getByPesel("000");
		assertEquals("Nazwisko1", student.getLastname());
	}

	@Test
	public void testCreate() {

		Adress tmpAdress = new Adress("ul ", "55c", "5");
		Division tmpDivision = divisionManager.getById("FTIMS");
		studentManager.create(tmpDivision, tmpAdress, "Imie1", "Nazwikos1","0001");
	}

}
