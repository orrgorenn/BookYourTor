package testing;

import Backend.Service;
import Backend.Worker;
import junit.framework.TestCase;

public class TestService extends TestCase {
	Service service1;
	
	public TestService() { }
	
	protected void setUp() throws Exception {
		service1 = new Service("name", 90.0, 1.5);
	}
	
	public void testDetails() {
		assertEquals("Name should be 'name'.", "name", service1.getName());
		assertEquals("Price should be '90.0'.", 90.0, service1.getPrice());
		assertEquals("Duration should be '1.5'.", 1.5, service1.getDuration());
	}
	
	public void testToString() {
		assertEquals("toString() Should be: 'name:90.0:1.5'.", "name:90.0:1.5", service1.toString());
	}
	
	public void testSetCmds() {
		String name = "name2";
		service1.setName(name);
		assertEquals("Name should be 'name2'.", name, service1.getName());
		double price = 100.0;
		service1.setPrice(price);
		assertEquals("Price should be '100.0'.", price, service1.getPrice());
		double duration = 2.0;
		service1.setDuration(duration);
		assertEquals("Duration should be '2.0'.", duration, service1.getDuration());
	}
}