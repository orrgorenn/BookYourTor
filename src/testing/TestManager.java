package testing;

import Backend.Manager;
import junit.framework.TestCase;

public class TestManager extends TestCase {
	Manager manager1;
	
	public TestManager() { }
	
	protected void setUp() throws Exception {
		manager1 = new Manager("name", "phone", "email");
	}
	
	public void testDetails() {
		assertEquals("Total Revenue should be '0.0'.", 0.0, manager1.getRevenue());
		assertEquals("Total Orders should be '0'.", 0, manager1.getTotalOrders());
	}
}