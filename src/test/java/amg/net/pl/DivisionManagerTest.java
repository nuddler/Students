package amg.net.pl;

import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import amg.net.pl.Model.DivisionManager;
import amg.net.pl.Model.IDivisionManager;

public class DivisionManagerTest {
	private static final Logger logger = LogManager
			.getLogger(DivisionManagerTest.class);

	private static IDivisionManager newDivisionManager;
	
	@BeforeClass
	public static void beforeClass(){
		newDivisionManager=DivisionManager.getInstance();

	}
	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		
	}

}
