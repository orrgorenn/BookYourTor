package testing;

import Backend.Worker;
import junit.framework.TestCase;

public class TestWorker extends TestCase {
	Worker worker1;
	
	public TestWorker() { }
	
	protected void setUp() throws Exception {
		worker1 = new Worker("name", "phone", "email");
	}
	
	public void testDetails() {
		assertEquals("Fullname should be 'name'.", "name", worker1.getFullName());
		assertEquals("Phone should be 'phone'.", "phone", worker1.getPhone());
		assertEquals("Fullname should be 'email'.", "email", worker1.getEmail());
	}
	
	public void testDefaults() {
		assertEquals("Total orders should be zero.", 0, worker1.getTotalOrders());
		assertEquals("Total payed should be zero.", 0.0, worker1.getTotalSalary());
	}
	
	public void testInc() {
		worker1.incTotalOrders();
		assertEquals("Total orders should be 1", 1, worker1.getTotalOrders());
	}
	
	public void testSalary() {
		worker1.addTotalSalary(65);
		assertEquals("Total payed should be 65.0", 65.0, worker1.getTotalSalary());
	}
	
	public void testToString() {
		assertEquals("toString() Should be: 'name:phone:email'.", "name:phone:email", worker1.toString());
	}
}