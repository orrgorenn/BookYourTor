package testing;

import Backend.*;
import junit.framework.TestCase;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TestAppointment extends TestCase {
	Appointment appointment1;
	Customer customer1;
	Service service1;
	Worker worker1, worker2;
	
	public TestAppointment() { }
	
	protected void setUp() throws Exception {
		customer1 = new Customer("name", "phone", "email");
		service1 = new Service("name", 10.0, 1.5);
		worker1 = new Worker("name", "phone", "email");
		appointment1 = new Appointment("10 Jul 2020", "20:30", customer1, service1, worker1);
	}
	
	public void testDetails() {
		assertEquals("Date should be '10 Jul 2020'.", "10 Jul 2020", appointment1.getDate());
		assertEquals("Time should be '20:30'.", "20:30", appointment1.getTime());
		assertThat("Customer should be from customer class.", customer1, instanceOf(Customer.class));
		assertThat("Service should be from service class.", service1, instanceOf(Service.class));
		assertThat("Worker should be from worker class.", worker1, instanceOf(Worker.class));
		assertEquals("Customer should be customer1.", customer1, appointment1.getCustomer());
		assertEquals("Service should be service1.", service1, appointment1.getService());
		assertEquals("Worker should be worker1.", worker1, appointment1.getWorker());
	}
	
	public void testToString() {
		assertEquals("toString() Should be: '10 Jul 2020-20:30-name-name-name'.", "10 Jul 2020-20:30-name-name-name", appointment1.toString());
	}
	
	public void testSetCmds() {
		worker2 = new Worker("name2", "phone2", "email2");
		appointment1.setWorker(worker2);
		assertEquals("Customer should be customer2.", worker2, appointment1.getWorker());
		String time = "15:30";
		appointment1.setTime(time);
		assertEquals("Time should be '15:30'.", time, appointment1.getTime());
		String date = "11 Dec 1994";
		appointment1.setDate(date);
		assertEquals("Time should be '11 Dec 1994'.", date, appointment1.getDate());
	}
}