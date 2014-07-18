package amg.net.pl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import amg.net.pl.Model.Adress;
import amg.net.pl.Model.Division;
import amg.net.pl.Model.DivisionManager;
import amg.net.pl.Model.IDivisionManager;
import amg.net.pl.Model.IStudentManager;
import amg.net.pl.Model.Student;
import amg.net.pl.Model.StudentManager;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/META-INF/test-context.xml" })
public class StudentManagerTest {

	// @Autowired
	public IStudentManager studentManager;
	public IDivisionManager divisionManager;

	@Before
	public void before() {
		studentManager = StudentManager.getInstance();
		divisionManager = DivisionManager.getInstance();
		
		Adress tmpAdress = new Adress("ULICA ", "NUMER_DOMU", "NUMER_MIESZKANIA");
		Division tmpDivision = divisionManager.getById("FTIMS");

		studentManager.create(tmpDivision, tmpAdress, "Imie1", "Nazwisko1","000");
	}

	@Test
	public void testDeleteStudent() {
		fail("Not yet implemented");
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
