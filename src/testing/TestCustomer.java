package testing;

import Backend.Customer;
import junit.framework.TestCase;

public class TestCustomer extends TestCase {
	Customer customer1;
	
	public TestCustomer() { }
	
	protected void setUp() throws Exception {
		customer1 = new Customer("name", "phone", "email");
	}
	
	public void testDetails() {
		assertEquals("Fullname should be 'name'.", "name", customer1.getFullName());
		assertEquals("Phone should be 'phone'.", "phone", customer1.getPhone());
		assertEquals("Fullname should be 'email'.", "email", customer1.getEmail());
	}
	
	public void testDefaults() {
		assertEquals("Total orders should be zero.", 0, customer1.getTotalOrders());
		assertEquals("Total payed should be zero.", 0.0, customer1.getTotalPayed());
	}
	
	public void testInc() {
		customer1.incTotalOrders();
		assertEquals("Total orders should be 1", 1, customer1.getTotalOrders());
	}
	
	public void testPayed() {
		customer1.addTotalPayed(65);
		assertEquals("Total payed should be 65.0", 65.0, customer1.getTotalPayed());
	}
	
	public void testToString() {
		assertEquals("toString() Should be: 'name:phone:email'.", "name:phone:email", customer1.toString());
	}
}