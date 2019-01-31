/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Bike;
import src.Terminal;

/**
 * 
 *
 */
class TerminalTest {

	private Terminal terminal;
	
	private List<Bike> initialBikeList = new ArrayList<Bike>(10);
	private Bike bike0 = new Bike(0);
	private Bike bike1 = new Bike(1);
	private Bike bike2 = new Bike(2);
		
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.initialBikeList.add(bike0);
		this.initialBikeList.add(bike1);
		this.initialBikeList.add(bike2);
		terminal = new Terminal(this.initialBikeList);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void shouldContains3Bike() {
		assertTrue(this.terminal.getBikeList().size() == 3);
	}
	
	@Test
	void shouldFindBike0() {
		assertTrue(this.terminal.containsBike(0));
	}
	
	@Test
	void shouldNotFindBike3() {
		assertFalse(this.terminal.containsBike(3));
	}

	@Test
	void shouldAddBike3() {
		assertFalse(this.terminal.containsBike(3));
		this.terminal.addBike(new Bike(3));
		assertTrue(this.terminal.containsBike(3));
	}
	
	@Test
	void shouldRemoveBike2() {
		assertTrue(this.terminal.removeBike(2));
		assertFalse(this.terminal.containsBike(2));
	}
	
	@Test
	void shouldNotRemoveBike3() {
		assertFalse(this.terminal.removeBike(3));
	}

}
